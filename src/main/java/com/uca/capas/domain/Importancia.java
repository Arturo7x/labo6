package com.uca.capas.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(schema = "public", name = "importancia")
public class Importancia {
    @Id
    @Column(name = "c_importancia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer c_importancia;

    @Column(name = "s_importancia")
    @NotEmpty(message = "Este campo no puede estar vacio")
    private String s_importancia;

    public Integer getC_importancia() {
        return c_importancia;
    }

    public void setC_importancia(Integer c_importancia) {
        this.c_importancia = c_importancia;
    }

    public String getS_importancia() {
        return s_importancia;
    }

    public void setS_importancia(String s_importancia) {
        this.s_importancia = s_importancia;
    }

    public Importancia() {
    }
}

