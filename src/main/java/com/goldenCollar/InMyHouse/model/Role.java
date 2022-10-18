package com.goldenCollar.InMyHouse.model;

import javax.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long idRole;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE_NAME")
    private RoleUtilisateur name;

    public Role() {
    }

    public Role(RoleUtilisateur name) {
        this.name = name;
    }

    public Long getIdRole() {
        return idRole;
    }

    public RoleUtilisateur getName() {
        return name;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public void setName(RoleUtilisateur name) {
        this.name = name;
    }
}
