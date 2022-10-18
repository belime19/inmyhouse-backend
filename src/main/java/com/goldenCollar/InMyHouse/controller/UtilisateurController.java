package com.goldenCollar.InMyHouse.controller;

import com.goldenCollar.InMyHouse.model.Propriete;
import com.goldenCollar.InMyHouse.model.Utilisateur;
import com.goldenCollar.InMyHouse.repositories.UtilisateurRepository;
import com.goldenCollar.InMyHouse.service.ProprieteService;
import com.goldenCollar.InMyHouse.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@PreAuthorize("hasRole('ADMINISTRATEUR')")
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
    @Autowired
    UtilisateurService utilisateurService;


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


}
