package com.goldenCollar.InMyHouse.model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long idAdresse;
    @Column(name = "RUE")
    private String rue;
    @Column(name = "CODE_POSTALE")
    private int codePostale;
    @Column(name = "VILLE")
    private String ville;
    @Column(name = "PAYS")
    private String pays;

    public Adresse() {
    }

    public Adresse(String rue, int codePostale, String ville, String pays) {
        this.rue = rue;
        this.codePostale = codePostale;
        this.ville = ville;
        this.pays = pays;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(int codePostale) {
        this.codePostale = codePostale;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}
