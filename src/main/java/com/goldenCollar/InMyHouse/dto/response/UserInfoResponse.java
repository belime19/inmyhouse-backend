package com.goldenCollar.InMyHouse.dto.response;

import java.util.List;

public class UserInfoResponse {
    private Long id;

    private String nom;

    private String prenom;
    private String email;

    private String accessToken;
    private List<String> roles;

    public UserInfoResponse(Long id, String nom, String prenom, String email, List<String> roles, String accessToken) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.roles = roles;
        this.accessToken = accessToken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
