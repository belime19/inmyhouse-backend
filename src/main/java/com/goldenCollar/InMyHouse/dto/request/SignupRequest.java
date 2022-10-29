package com.goldenCollar.InMyHouse.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class SignupRequest {

    private String nom;

    private String prenom;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private Set<String> roles;

    @NotBlank
    private String motDePass;

    private String numero;

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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePass() {
        return motDePass;
    }

    public String getNumero() {
        return numero;
    }

    public void setMotDePAas(String motDePass) {
        this.motDePass = motDePass;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Set<String> getRole() {
        return this.roles;
    }

    public void setRole(Set<String> role) {
        this.roles = role;
    }
}
