package com.goldenCollar.InMyHouse.controller;

import com.goldenCollar.InMyHouse.dto.ProprieteDto;
import com.goldenCollar.InMyHouse.service.ProprieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/proprietes")
public class ProprieteController {

    @Autowired
    ProprieteService proprieteService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addPropriete(@RequestBody ProprieteDto propriete){
        try{
            proprieteService.addPropriete(propriete);
            return ResponseEntity.ok()
                    .body(propriete);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError()
                    .body(e.getMessage());
        }


    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<?> getPropriete (@PathVariable Long id){
        return  ResponseEntity.ok()
                .body(proprieteService.getPropriete(id)) ;
    }

    @RequestMapping()
    public ResponseEntity<?> getProprietes (@RequestParam(name= "ville") String ville,
                                      @RequestParam(name= "startDate") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate startDate,
                                      @RequestParam(name= "endDate") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate endDate){
        return ResponseEntity.ok()
                .body(proprieteService.searchProprietes(ville, startDate, endDate)) ;
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
