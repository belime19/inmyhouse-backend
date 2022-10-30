package com.goldenCollar.InMyHouse.mapper;

import com.goldenCollar.InMyHouse.dto.ProprieteDto;
import com.goldenCollar.InMyHouse.dto.UtilisateurDto;
import com.goldenCollar.InMyHouse.model.Propriete;
import com.goldenCollar.InMyHouse.model.Utilisateur;
import com.goldenCollar.InMyHouse.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class UtilisateurMapper implements EntityDtoMapper<Utilisateur, UtilisateurDto> {

    @Override
    public Utilisateur dtoToEntity(UtilisateurDto dto) {
        return new Utilisateur(
                dto.getNom(),
                dto.getPrenom(),
                dto.getEmail(),
                dto.getNumero(),
                dto.getMotDePass()

        );
    }

    @Override
    public UtilisateurDto entityToDto(Utilisateur entity) {
        return new UtilisateurDto(
                entity.getNom(),
                entity.getPrenom(),
                entity.getEmail(),
                entity.getNumero(),
                entity.getMotDePass());
    }
}
