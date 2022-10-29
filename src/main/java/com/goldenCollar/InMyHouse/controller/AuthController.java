package com.goldenCollar.InMyHouse.controller;

import com.goldenCollar.InMyHouse.dto.request.LoginRequest;
import com.goldenCollar.InMyHouse.dto.request.SignupRequest;
import com.goldenCollar.InMyHouse.dto.response.MessageResponse;
import com.goldenCollar.InMyHouse.dto.response.UserInfoResponse;
import com.goldenCollar.InMyHouse.model.Role;
import com.goldenCollar.InMyHouse.model.RoleUtilisateur;
import com.goldenCollar.InMyHouse.model.Utilisateur;
import com.goldenCollar.InMyHouse.security.JwtUtils;
import com.goldenCollar.InMyHouse.security.UserDetailsImpl;
import com.goldenCollar.InMyHouse.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UtilisateurService utilisateurService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> connexion(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String jwt = jwtUtils.generateTokenFromUsername(userDetails.getUsername());

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok()
                .header("Access-Control-Allow-Headers", "Authorization, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, " +
                        "Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwt)
                .body(new UserInfoResponse(userDetails.getId(),
                        userDetails.getUsername().split("\\.")[0],
                        userDetails.getUsername().split("\\.")[1],
                        userDetails.getEmail(),
                        roles,
                        jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> inscription(@Valid @RequestBody SignupRequest signUpRequest) {

        if (utilisateurService.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Erreur: l'email est utilisé !"));
        }

        // Créer un nouveau compte utilisateur
        Utilisateur utilisateur = new Utilisateur(signUpRequest.getNom(),signUpRequest.getPrenom(),
                signUpRequest.getEmail(),signUpRequest.getNumero(),
                encoder.encode(signUpRequest.getMotDePass()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = utilisateurService.findRoleByName(RoleUtilisateur.UTILISATEUR)
                    .orElseThrow(() -> new RuntimeException("Erreur: Role non trouvable."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                    Role adminRole = utilisateurService.findRoleByName(RoleUtilisateur.ADMINISTRATEUR)
                                .orElseThrow(() -> new RuntimeException("Erreur: Role non trouvable."));
                        roles.add(adminRole);
                        break;
                    default:
                        Role userRole = utilisateurService.findRoleByName(RoleUtilisateur.UTILISATEUR)
                                .orElseThrow(() -> new RuntimeException("Erreur: Role non trouvable."));
                        roles.add(userRole);
                }
            });
        }
        utilisateur.setRoles(roles);
        utilisateurService.addUtilisateur(utilisateur);

        return ResponseEntity.ok()
                .header("Access-Control-Allow-Headers", "Authorization, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, " +
                "Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers")
                .body(new MessageResponse("Utilisateur enregistré avec succès !"));
    }

    @PostMapping("/signout")
    public ResponseEntity<?> deconnexion() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("Vous avez été déconnecté"));
    }
}
