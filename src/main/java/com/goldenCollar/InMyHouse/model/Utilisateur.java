package com.goldenCollar.InMyHouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long idUtilisateur;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "PRENOM")
    private String prenom;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "MOT_DE_PASS")
    private String motDePass;
    @Column(name = "NUMERO")
    private String numero;
    @JsonIgnore
    @OneToMany(mappedBy = "locataire")
    private Set<Reservation> reservation =new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "proprietaire")
    private Set<Propriete> proprietes =new HashSet<>();

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String email,  String numero, String motDePass) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePass = motDePass;
        this.numero = numero;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePass() {
        return motDePass;
    }

    public void setMotDePass(String motDePass) {
        this.motDePass = motDePass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Set<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(Set<Reservation> reservation) {
        this.reservation = reservation;
    }

    public Set<Propriete> getPropriete() {
        return proprietes;
    }

    public void setPropriete(Set<Propriete> propriete) {
        this.proprietes = propriete;
    }
}
