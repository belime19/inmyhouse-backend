package com.goldenCollar.InMyHouse.controller;

import com.goldenCollar.InMyHouse.dto.request.LoginRequest;
import com.goldenCollar.InMyHouse.dto.request.SignupRequest;
import com.goldenCollar.InMyHouse.dto.response.MessageResponse;
import com.goldenCollar.InMyHouse.mapper.UtilisateurMapper;
import com.goldenCollar.InMyHouse.model.Propriete;
import com.goldenCollar.InMyHouse.model.Utilisateur;
import com.goldenCollar.InMyHouse.repositories.UtilisateurRepository;
import com.goldenCollar.InMyHouse.service.ProprieteService;
import com.goldenCollar.InMyHouse.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
    @Autowired
    UtilisateurService utilisateurService;

    @Autowired
    UtilisateurMapper utilisateurMapper;

    @RequestMapping(method = RequestMethod.POST)
    public void addUtilisateur(@RequestBody Utilisateur utilisateur){
        utilisateurService.addUtilisateur(utilisateur);
    }

    @RequestMapping(value = "/{id}")
    public Utilisateur getUtilisateur (@PathVariable Long id){
        return utilisateurService.getUtilisateur(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void updateUtilisateur(@RequestBody Utilisateur utilisateur,@PathVariable Long id){
        utilisateurService.apdateUtilisateur(id,utilisateur);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteUtilisateur (@PathVariable Long id){
       utilisateurService.deleteUtilisateur(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> connexion(@Valid @RequestBody LoginRequest loginRequest) {
        Utilisateur utilisateur = utilisateurService.getByEmail(loginRequest.getEmail());
        if(utilisateur != null
                && loginRequest.getPassword() != null
                && loginRequest.getPassword().equals(utilisateur.getMotDePass())){
            return ResponseEntity.ok()
                    .body(utilisateurMapper.entityToDto(utilisateur));
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/signup")
    public ResponseEntity<?> inscription(@Valid @RequestBody SignupRequest signUpRequest) {

        if (utilisateurService.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Erreur: l'email est utilisé !"));
        }

        // Créer un nouveau compte utilisateur
        Utilisateur utilisateur = new Utilisateur(signUpRequest.getNom(),signUpRequest.getPrenom(),
                signUpRequest.getEmail(),signUpRequest.getNumero(),
                signUpRequest.getMotDePass());
        utilisateurService.addUtilisateur(utilisateur);

        return ResponseEntity.ok()
                .body(new MessageResponse("Utilisateur enregistré avec succès !"));
    }

    @PostMapping("/signout")
    public ResponseEntity<?> deconnexion() {
        return ResponseEntity.ok().body(new MessageResponse("Vous avez été déconnecté"));
    }


}
