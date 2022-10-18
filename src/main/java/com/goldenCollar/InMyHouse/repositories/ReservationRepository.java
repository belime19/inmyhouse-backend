package com.goldenCollar.InMyHouse.repositories;

import com.goldenCollar.InMyHouse.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
