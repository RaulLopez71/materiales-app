package com.example.materiales_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "El nomnbre es obligatorio" )  //Validation
    @Column(nullable = false, length = 120)
    String nombre;

    @NotBlank(message = "La unidad es obligatoria" )  //Validation
    @Column(nullable = false, length = 20)
    String unidad;

    @NotNull(message = "El precio es obligatorio" )  //Validation
    @Positive(message="El precio debe ser mayor que CERO") //Validation
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal precio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
