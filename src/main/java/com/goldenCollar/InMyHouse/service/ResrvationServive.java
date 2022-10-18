package com.goldenCollar.InMyHouse.service;

import com.goldenCollar.InMyHouse.model.Propriete;
import com.goldenCollar.InMyHouse.model.Reservation;
import com.goldenCollar.InMyHouse.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResrvationServive {

    @Autowired
    ReservationRepository reservationRepository;

    public  Reservation getReservation(Long id) {
        return reservationRepository.findById(id).get();
    }

    public  void apdateReservation(Long id, Reservation reservation) {
        //reservationRepository
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public void addReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }
}
