package com.goldenCollar.InMyHouse.controller;

import com.goldenCollar.InMyHouse.dto.ProprieteDto;
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
    public void addPropriete(@RequestBody ProprieteDto propriete){
        proprieteService.addPropriete(propriete);
    }

    @RequestMapping(value = "/proprietes/{id}")
    public ProprieteDto getPropriete (@PathVariable Long id){
        return proprieteService.getPropriete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void updatePropriete(@RequestBody ProprieteDto propriete, @PathVariable Long id){
        proprieteService.updatePropriete(id,propriete);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deletePropriete (@PathVariable Long id){
        proprieteService.deletePropriete(id);
    }


}
