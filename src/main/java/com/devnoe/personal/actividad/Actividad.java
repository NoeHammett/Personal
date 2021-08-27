package com.devnoe.personal.actividad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="actividad")
public class Actividad {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (unique = true, nullable = false)
    private Long id_actividad;

    private String nombre;
    private String descripcion;
    private Long horas;

    public Actividad() {
    }

    public Actividad(Long id_actividad, String nombre, String descripcion, Long horas) {
        this.id_actividad = id_actividad;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horas = horas;
    }
    
     public Actividad(String nombre, String descripcion, Long horas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horas = horas;
    }


    public Long getId_actividad() {
        return this.id_actividad;
    }

    public void setId_actividad(Long id_actividad) {
        this.id_actividad = id_actividad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getHoras() {
        return this.horas;
    }

    public void setHoras(Long horas) {
        this.horas = horas;
    }
}
