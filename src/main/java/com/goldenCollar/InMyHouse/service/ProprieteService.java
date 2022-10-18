package com.goldenCollar.InMyHouse.service;

import com.goldenCollar.InMyHouse.model.Propriete;
import com.goldenCollar.InMyHouse.model.Utilisateur;
import com.goldenCollar.InMyHouse.repositories.ProprieteRepository;
import com.goldenCollar.InMyHouse.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProprieteService {

    @Autowired
    ProprieteRepository proprieteRepository;

    public Propriete getPropriete(Long id) {

        return proprieteRepository.findById(id).get();
    }

    public  void apdatePropriete(Long id, Propriete propriete) {
    }
    public void deletePropriete(Long id) {
        proprieteRepository.deleteById(id);
    }
    public void addPropriete(Propriete propriete) {
        proprieteRepository.save(propriete);
    }


}
