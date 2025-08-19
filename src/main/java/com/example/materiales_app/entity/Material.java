package com.example.materiales_app.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @Column(nullable = false, length = 120)
    String nombre;

    @Column(nullable = false, length = 20)
    String unidad;

    @Column(nullable = false, precision = 12, scale = 2)
    BigDecimal precio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nonbre) {
        this.nombre = nonbre;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
