package com.goldenCollar.InMyHouse.service;

import com.goldenCollar.InMyHouse.dto.ProprieteDto;
import com.goldenCollar.InMyHouse.mapper.ProprieteMapper;
import com.goldenCollar.InMyHouse.model.Propriete;
import com.goldenCollar.InMyHouse.repositories.ProprieteRepository;
import com.goldenCollar.InMyHouse.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
