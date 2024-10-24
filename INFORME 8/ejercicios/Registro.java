package model;

public class Registro {
    private int id;
    private String nombre;
    private int edad;
    private String ciudad;

    public Registro(int id, String nombre, int edad, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad + ", Ciudad: " + ciudad;
    }
}
