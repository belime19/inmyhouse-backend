package com.goldenCollar.InMyHouse.mapper;

import com.goldenCollar.InMyHouse.dto.ProprieteDto;
import com.goldenCollar.InMyHouse.model.Propriete;
import com.goldenCollar.InMyHouse.model.Utilisateur;
import com.goldenCollar.InMyHouse.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ProprieteMapper implements EntityDtoMapper<Propriete, ProprieteDto> {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Override
    public Propriete dtoToEntity(ProprieteDto dto) {
        Utilisateur proprietaire = utilisateurRepository.findByEmail(dto.getEmailProprietaire()).orElseThrow();
        return new Propriete(
                dto.getTypePropriete(),
                proprietaire,
                Collections.emptySet(),
                dto.getAdresse(),
                dto.getSurface(),
                dto.getPrixUnitaire(),
                dto.getTitre(),
                dto.getDescription(),
                dto.getEtoiles(),
                dto.getImage()
                );
    }

    @Override
    public ProprieteDto entityToDto(Propriete entity) {
        return new ProprieteDto(
                entity.getTypePropriete(),
                entity.getProprietaire().getEmail(),
                entity.getAdresse(),
                entity.getSurface(),
                entity.getPrixUnitaire(),
                entity.getTitre(),
                entity.getDescription(),
                entity.getEtoiles(),
                entity.getImage()
        );
    }
}
