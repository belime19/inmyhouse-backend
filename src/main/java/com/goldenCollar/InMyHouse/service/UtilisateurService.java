package com.goldenCollar.InMyHouse.service;

import com.goldenCollar.InMyHouse.model.Utilisateur;
import com.goldenCollar.InMyHouse.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    public Utilisateur getByEmail(String email) {
        return utilisateurRepository.findByEmail(email).orElse(null);
    }

    public boolean existsByEmail(String email) {
        return utilisateurRepository.findByEmail(email).isPresent();
    }


    public  void apdateUtilisateur(Long id, Utilisateur utilisateur) {
        //utilisateurRepository
    }

    public  void deleteUtilisateur(Long idUtilisateur) {
        utilisateurRepository.deleteById(idUtilisateur);
    }

    public void addUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

    public Utilisateur getUtilisateur(Long id) {
        return utilisateurRepository.findById(id).get();
    }
}
