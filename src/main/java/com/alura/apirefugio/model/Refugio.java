package com.alura.apirefugio.model;

import com.alura.apirefugio.helper.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class Refugio {
    private final Long id;
    private String nombre;
    private String telefono;
    private String email;
    private List<Pet> pets = new ArrayList<>();

    public Refugio(String nombre, String telefono, String email) {
        this.id = IdGenerator.generateRefugioId();
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Refugio{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", pets=" + pets +
                '}';
    }
}
