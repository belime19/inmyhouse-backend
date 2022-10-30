package com.goldenCollar.InMyHouse.controller;

import com.goldenCollar.InMyHouse.Exception.AlreadyReservedException;
import com.goldenCollar.InMyHouse.dto.ReservationDto;
import com.goldenCollar.InMyHouse.model.Propriete;
import com.goldenCollar.InMyHouse.model.Reservation;
import com.goldenCollar.InMyHouse.model.Utilisateur;
import com.goldenCollar.InMyHouse.service.ProprieteService;
import com.goldenCollar.InMyHouse.service.ResrvationServive;
import com.goldenCollar.InMyHouse.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    ResrvationServive resrvationServive;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addReservation(@RequestBody ReservationDto reservation){
       try{
           resrvationServive.addReservation(reservation);
           return ResponseEntity.ok()
                   .body("Merci d'avoir reservé cette propriété !") ;
       }
       catch(AlreadyReservedException e){
           return ResponseEntity.internalServerError()
                   .body("La propriété est déjà Réservé !") ;
       }


    }
    @RequestMapping(value = "/reservations/{id}")
    public Reservation getReservation (@PathVariable Long id){
        return resrvationServive.getReservation(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/reservations/{id}")
    public void updateReservation(@RequestBody Reservation reservation,@PathVariable Long id){
        resrvationServive.apdateReservation(id,reservation);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/reservations/{id}")
    public void deleteReservation (@PathVariable Long id){
        resrvationServive.deleteReservation(id);
    }
}
