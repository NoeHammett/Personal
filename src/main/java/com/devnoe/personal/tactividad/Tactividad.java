package com.devnoe.personal.tactividad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_actividad")
public class Tactividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_tipo_actividad;
    
    private String nombre;

    public Tactividad() {}
  
    public Tactividad(Long id_tipo_actividad, String nombre) {
        this.id_tipo_actividad = id_tipo_actividad;
        this.nombre = nombre;
    }
    
    public Tactividad(String nombre) {
        this.nombre = nombre;
    }
    public Long getId_tipo_actividad() {
        return this.id_tipo_actividad;
    }

    public void setId_tipo_actividad(Long id_tipo_actividad) {
        this.id_tipo_actividad = id_tipo_actividad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

}
