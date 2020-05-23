package com.uca.capas.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(schema = "public", name = "contribuyente")
public class Contribuyente {
    @Id
    @Column(name = "c_contribuyente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer c_contribuyente;

    @Column(name = "c_importancia")
    @NotEmpty(message = "Este campo no puede estar vacio")
    private Integer c_importancia;

    @Column(name = "s_nombre")
    @NotEmpty(message = "Este campo no puede estar vacio")
    private String nombre;

    @Column(name = "s_apellido")
    @NotEmpty(message = "Este campo no puede estar vacio")
    private String apellido;

    @Column(name = "s_nit")
    @NotEmpty(message = "Este campo no puede estar vacio")
    private String s_nit;

    @Column(name = "f_fecha_ingreso")
    @NotEmpty(message = "Este campo no puede estar vacio")
    @Pattern(regexp = "^([0-2][0-9]|3[0-1])(\\/)(0[1-9]|1[0-2])\\2(\\d{4})$", message = "El formato debe ser dd/MM/aaaa")
    private Date f_fecha_ingreso;

    public Integer getC_contribuyente() {
        return c_contribuyente;
    }

    public void setC_contribuyente(Integer c_contribuyente) {
        this.c_contribuyente = c_contribuyente;
    }

    public Integer getC_importancia() {
        return c_importancia;
    }

    public void setC_importancia(Integer c_importancia) {
        this.c_importancia = c_importancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getS_nit() {
        return s_nit;
    }

    public void setS_nit(String s_nit) {
        this.s_nit = s_nit;
    }

    public Date getF_fecha_ingreso() {
        return f_fecha_ingreso;
    }

    public void setF_fecha_ingreso(Date f_fecha_ingreso) {
        this.f_fecha_ingreso = f_fecha_ingreso;
    }

    public Contribuyente() {
    }
}

