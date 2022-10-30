package com.goldenCollar.InMyHouse.repositories;

import com.goldenCollar.InMyHouse.model.Propriete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProprieteRepository extends JpaRepository<Propriete,Long> {
    public List<Propriete> findAllByVilleIgnoreCase(String Ville);
}
