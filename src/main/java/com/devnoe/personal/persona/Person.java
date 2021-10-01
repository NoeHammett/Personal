package com.devnoe.personal.persona;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="person")
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nombre;
    private String primer_apellido; 
    private String segundo_apellido;

    
    @Transient
    private Integer edad;
    private LocalDate nacimiento;
    private String email;
    public Person() {
    }


    public Person( String nombre, String primer_apellido, String segundo_apellido, Integer edad, LocalDate nacimiento, String email) {
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.edad = edad;
        this.nacimiento = nacimiento;
        this.email = email;
    }

    public Person(Long id, String nombre, String primer_apellido, String segundo_apellido, Integer edad, LocalDate nacimiento, String email) {
        this.id = id;
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.edad = edad;
        this.nacimiento = nacimiento;
        this.email = email;
    }
    

    //Getters and Setter haciendo referencia a los campos en la tabla
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPrimer_apellido() {
        return this.primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return this.segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }


    public Integer getEdad() {
        return this.edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public LocalDate getNacimiento() {
        return this.nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", primer_apellido='" + getPrimer_apellido() + "'" +
            ", segundo_apellido='" + getSegundo_apellido() + "'" +
            ", edad='" + getEdad() + "'" +
            ", nacimiento='" + getNacimiento() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }
    

        
    
}
