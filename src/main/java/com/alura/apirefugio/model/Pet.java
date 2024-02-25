package com.alura.apirefugio.model;

import com.alura.apirefugio.helper.IdGenerator;

public class Pet {
    private final Long id;
    private String tipo;
    private String nombre;
    private String raza;
    private int edad;
    private String color;
    private Float peso;

    public Pet(String tipo, String nombre, String raza, int edad, String color, Float peso) {
        this.id = IdGenerator.generatePetId();
        this.tipo = tipo;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.color = color;
        this.peso = peso;
    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                ", edad=" + edad +
                ", color='" + color + '\'' +
                ", peso=" + peso +
                '}';
    }
}
