package com.goldenCollar.InMyHouse.controller;

import com.goldenCollar.InMyHouse.model.Propriete;
import com.goldenCollar.InMyHouse.model.Utilisateur;
import com.goldenCollar.InMyHouse.service.ProprieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@PreAuthorize("hasRole('UTILISATEUR')")
@RequestMapping("/api/proprietes")
public class ProprieteController {

    @Autowired
    ProprieteService proprieteService;

    @RequestMapping(method = RequestMethod.POST)
    public void addPropriete(@RequestBody Propriete propriete){
        proprieteService.addPropriete(propriete);
    }

    @RequestMapping(value = "/proprietes/{id}")
    public Propriete getPropriete (@PathVariable Long id){
        return proprieteService.getPropriete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void updatePropriete(@RequestBody Propriete propriete,@PathVariable Long id){
        proprieteService.apdatePropriete(id,propriete);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deletePropriete (@PathVariable Long id){
        proprieteService.deletePropriete(id);
    }


}
