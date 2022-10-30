package com.goldenCollar.InMyHouse.service;

import com.goldenCollar.InMyHouse.Exception.AlreadyReservedException;
import com.goldenCollar.InMyHouse.dto.ReservationDto;
import com.goldenCollar.InMyHouse.mapper.ReservationMapper;
import com.goldenCollar.InMyHouse.model.Propriete;
import com.goldenCollar.InMyHouse.model.Reservation;
import com.goldenCollar.InMyHouse.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResrvationServive {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ReservationMapper reservationMapper;

    public  Reservation getReservation(Long id) {
        return reservationRepository.findById(id).get();
    }

    public  void apdateReservation(Long id, Reservation reservation) {
        //reservationRepository
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public void addReservation(ReservationDto reservationDto) throws AlreadyReservedException{
        List<Reservation> allPropertyReservations =  reservationRepository.findByPropriete_IdPrpreite(reservationDto.getIdPropriete());
        Optional<Reservation> reservationInTheSamePeriode= allPropertyReservations.stream().filter(
                res -> res.getDateDebut().isAfter(reservationDto.getDateDebut())
                 && res.getDateDebut().isBefore(reservationDto.getDateFin())
                 ||
                 res.getDateFin().isAfter(reservationDto.getDateDebut())
                         && res.getDateFin().isBefore(reservationDto.getDateFin())
                 ||
                 reservationDto.getDateDebut().isAfter(res.getDateDebut())
                         && reservationDto.getDateDebut().isBefore(res.getDateFin())
                 ||
                 reservationDto.getDateFin().isAfter(res.getDateDebut())
                         && reservationDto.getDateFin().isBefore(res.getDateFin())
                 ||
                 res.getDateDebut().isEqual(reservationDto.getDateDebut())
                 ||
                 res.getDateFin().isEqual(reservationDto.getDateDebut())
                 ||
                 res.getDateDebut().isEqual(reservationDto.getDateFin())
                 ||
                 res.getDateFin().isEqual(reservationDto.getDateFin())
        ).findFirst();
        if(reservationInTheSamePeriode.isPresent()){
            throw new  AlreadyReservedException("Déjà reservée");
        }
        reservationRepository.save(reservationMapper.dtoToEntity(reservationDto));
    }
}
