package com.goldenCollar.InMyHouse.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long idResrvation;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_LOCATAIRE",referencedColumnName = "ID")
    private Utilisateur locataire;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_PROPRIETE",referencedColumnName = "ID")
    private Propriete propriete;
    @Column(name = "DATE_DEBUT")
    private LocalDate dateDebut;
    @Column(name = "DATE_FIN")
    private LocalDate dateFin;


    public Reservation() {
    }

    public Reservation(Utilisateur locataire, Propriete propriete, LocalDate dateDebut, LocalDate dateFin) {
        this.locataire = locataire;
        this.propriete = propriete;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Long getIdResrvation() {
        return idResrvation;
    }

    public void setIdResrvation(Long idResrvation) {
        this.idResrvation = idResrvation;
    }

    public Utilisateur getLocataire() {
        return locataire;
    }

    public void setLocataire(Utilisateur locataire) {
        this.locataire = locataire;
    }

    public Propriete getPropriete() {
        return propriete;
    }

    public void setPropriete(Propriete propriete) {
        this.propriete = propriete;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }


}
