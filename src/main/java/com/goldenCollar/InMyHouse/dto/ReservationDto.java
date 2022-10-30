package com.goldenCollar.InMyHouse.dto;

import javax.persistence.Column;
import java.time.LocalDate;

public class ReservationDto {

    private long idPropriete;
    private String emailLocataire;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    public ReservationDto() {
    }

    public ReservationDto(long idPropriete, String emailLocataire, LocalDate dateDebut, LocalDate dateFin) {
        this.idPropriete = idPropriete;
        this.emailLocataire = emailLocataire;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public long getIdPropriete() {
        return idPropriete;
    }

    public String getEmailLocataire() {
        return emailLocataire;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setIdPropriete(long idPropriete) {
        this.idPropriete = idPropriete;
    }

    public void setEmailLocataire(String emailLocataire) {
        this.emailLocataire = emailLocataire;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
}
