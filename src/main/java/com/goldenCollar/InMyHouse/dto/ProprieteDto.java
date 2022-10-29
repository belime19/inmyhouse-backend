package com.goldenCollar.InMyHouse.dto;
import com.goldenCollar.InMyHouse.model.Adresse;
import com.goldenCollar.InMyHouse.model.TypePropriete;


public class ProprieteDto {

    private TypePropriete typePropriete ;

    private String emailProprietaire ;

    private Adresse adresse;

    private double surface;

    private double prixUnitaire;

    private String titre;

    private String description;

    private int etoiles;

    private String image;

    public ProprieteDto() {
    }

    public ProprieteDto(TypePropriete typePropriete, String emailProprietaire, Adresse adresse, double surface, double prixUnitaire, String titre, String description, int etoiles, String image) {
        this.emailProprietaire = emailProprietaire;
        this.adresse = adresse;
        this.surface = surface;
        this.prixUnitaire = prixUnitaire;
        this.titre = titre;
        this.description = description;
        this.etoiles = etoiles;
        this.image = image;
        this.typePropriete = typePropriete;
    }

    public String getEmailProprietaire() {
        return emailProprietaire;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public double getSurface() {
        return surface;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public int getEtoiles() {
        return etoiles;
    }

    public String getImage() {
        return image;
    }

    public void setEmailProprietaire(String emailProprietaire) {
        this.emailProprietaire = emailProprietaire;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEtoiles(int etoiles) {
        this.etoiles = etoiles;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public TypePropriete getTypePropriete() {
        return typePropriete;
    }

    public void setTypePropriete(TypePropriete typePropriete) {
        this.typePropriete = typePropriete;
    }
}
