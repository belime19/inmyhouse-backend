package com.goldenCollar.InMyHouse.service;

import com.goldenCollar.InMyHouse.dto.ProprieteDto;
import com.goldenCollar.InMyHouse.mapper.ProprieteMapper;
import com.goldenCollar.InMyHouse.model.Propriete;
import com.goldenCollar.InMyHouse.repositories.ProprieteRepository;
import com.goldenCollar.InMyHouse.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProprieteService {

    @Autowired
    ProprieteRepository proprieteRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    ProprieteMapper proprieteMapper;

    public ProprieteDto getPropriete(Long id) {

        Propriete propriete =  proprieteRepository.findById(id).orElseThrow();
        return proprieteMapper.entityToDto(propriete);
    }

    public  void updatePropriete(Long id, ProprieteDto propriete) {
    }
    public void deletePropriete(Long id) {
        proprieteRepository.deleteById(id);
    }
    public void addPropriete(ProprieteDto propriete) {
        proprieteRepository.save(proprieteMapper.dtoToEntity(propriete));
    }


    public List<ProprieteDto> searchProprietes(String ville, LocalDate startDate, LocalDate endDate) {
        List<Propriete>  proprietesInVille =  proprieteRepository.findAllByVilleIgnoreCase(ville);
        return proprietesInVille.stream().filter(propriete ->
            propriete.getReservations().stream()
                    .noneMatch(reservation -> reservation.getDateDebut().isAfter(startDate)
                                            && reservation.getDateDebut().isBefore(endDate)
                                            ||
                                            reservation.getDateFin().isAfter(startDate)
                                            && reservation.getDateFin().isBefore(endDate)
                                            ||
                                            startDate.isAfter(reservation.getDateDebut())
                                                    && startDate.isBefore(reservation.getDateFin())
                                            ||
                                            endDate.isAfter(reservation.getDateDebut())
                                                    && endDate.isBefore(reservation.getDateFin())
                                            ||
                                            reservation.getDateDebut().isEqual(startDate)
                                            ||
                                            reservation.getDateFin().isEqual(startDate)
                                            ||
                                            reservation.getDateDebut().isEqual(endDate)
                                            ||
                                            reservation.getDateFin().isEqual(endDate)
                            )
        )
        .map(proprieteMapper::entityToDto)
        .collect(Collectors.toList());

    }
}
