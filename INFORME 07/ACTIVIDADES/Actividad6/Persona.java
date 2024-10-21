public class Persona {
    private String nombre; // Nombre de la persona
    private int edad;
    private String nif;

    public Persona(String nif, String nombre, int edad) {
        this.nif = nif;
        this.nombre = nombre; // Asignar nombre
        this.edad = edad;
    }

    public String getNombre() {
        return nombre; // Obtener nombre
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Nif: " + nif; // Representación en
                                                                                              // String
    }
}
