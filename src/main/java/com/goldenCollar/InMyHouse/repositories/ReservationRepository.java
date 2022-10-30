package com.goldenCollar.InMyHouse.repositories;

import com.goldenCollar.InMyHouse.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    public List<Reservation> findByPropriete_IdPrpreite(long idPropriete);
}
