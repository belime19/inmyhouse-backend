package com.goldenCollar.InMyHouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Propriete {


    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long idPrpreite;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_PROPRIETAIRE",referencedColumnName = "ID")
    private Utilisateur proprietaire;

    @JsonIgnore
    @OneToMany(mappedBy = "propriete")
    private Set<Reservation> reservations =new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Adresse adresse;
    @Column(name = "SURFACE")
    private double surface;
    @Column(name = "DATE")
    private LocalDate date;
    @Column(name = "PRIX_UNITAIRE")
    private double prixUnitaire;

    public Propriete() {
    }

    public Propriete(Adresse adresse, double surface, LocalDate date, double prixUnitaire) {
        this.adresse = adresse;
        this.surface = surface;
        this.date = date;
        this.prixUnitaire = prixUnitaire;
    }

    public Long getIdPrpreite() {
        return idPrpreite;
    }

    public void setIdPrpreite(Long idPrpreite) {
        this.idPrpreite = idPrpreite;
    }

    public Utilisateur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Utilisateur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<Reservation> getReservation() {
        return reservations;
    }

    public void setReservation(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}
