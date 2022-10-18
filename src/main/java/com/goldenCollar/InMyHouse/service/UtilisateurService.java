package com.goldenCollar.InMyHouse.service;

import com.goldenCollar.InMyHouse.model.Propriete;
import com.goldenCollar.InMyHouse.model.Role;
import com.goldenCollar.InMyHouse.model.RoleUtilisateur;
import com.goldenCollar.InMyHouse.model.Utilisateur;
import com.goldenCollar.InMyHouse.repositories.RoleRepository;
import com.goldenCollar.InMyHouse.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    RoleRepository roleRepository;

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

    public Optional<Role> findRoleByName(RoleUtilisateur utilisateur) {
        return roleRepository.findByName(utilisateur);
    }
}
