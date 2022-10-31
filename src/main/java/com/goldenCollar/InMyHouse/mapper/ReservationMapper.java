package com.goldenCollar.InMyHouse.mapper;

import com.goldenCollar.InMyHouse.dto.ProprieteDto;
import com.goldenCollar.InMyHouse.dto.ReservationDto;
import com.goldenCollar.InMyHouse.model.Propriete;
import com.goldenCollar.InMyHouse.model.Reservation;
import com.goldenCollar.InMyHouse.model.Utilisateur;
import com.goldenCollar.InMyHouse.repositories.ProprieteRepository;
import com.goldenCollar.InMyHouse.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ReservationMapper implements EntityDtoMapper<Reservation, ReservationDto> {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    ProprieteRepository proprieteRepository;

    @Override
    public Reservation dtoToEntity(ReservationDto dto) {
        Utilisateur locataire = utilisateurRepository.findByEmail(dto.getEmailLocataire()).orElseThrow(() ->{
            return new RuntimeException("User not found "+dto.getEmailLocataire());
        });
        Propriete propriete = proprieteRepository.findById(dto.getIdPropriete()).orElseThrow(() -> {
            return new RuntimeException("Property not found : "+ dto.getIdPropriete());
        });
        return new Reservation(
               locataire,
                propriete,
                dto.getDateDebut(),
                dto.getDateFin()
                );
    }

    @Override
    public ReservationDto entityToDto(Reservation entity) {
        return new ReservationDto(
                entity.getPropriete().getIdPrpreite(),
                entity.getLocataire().getEmail(),
                entity.getDateDebut(),
                entity.getDateFin());
    }
}
