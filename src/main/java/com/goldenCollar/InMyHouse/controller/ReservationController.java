package com.goldenCollar.InMyHouse.controller;

import com.goldenCollar.InMyHouse.model.Propriete;
import com.goldenCollar.InMyHouse.model.Reservation;
import com.goldenCollar.InMyHouse.model.Utilisateur;
import com.goldenCollar.InMyHouse.service.ProprieteService;
import com.goldenCollar.InMyHouse.service.ResrvationServive;
import com.goldenCollar.InMyHouse.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@PreAuthorize("hasRole('UTILISATEUR')")
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    ResrvationServive resrvationServive;

    @RequestMapping(method = RequestMethod.POST)
    public void addReservation(@RequestBody Reservation reservation){
        resrvationServive.addReservation(reservation);
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
