package com.dedae.m3.domain.entities;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @SequenceGenerator(name = "rol_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_sequence")
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserRol> userRol;

    public Rol() {
    }

    public Rol(Integer id, String name, UserRol userRol) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserRol> getUserRol() {
        return userRol;
    }

    public void setUserRol(Set<UserRol> userRol) {
        this.userRol = userRol;
    }
}
