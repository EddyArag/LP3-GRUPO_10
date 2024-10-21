public class Persona {
    private String nombre; // Nombre de la persona
    private String telefono; // Teléfono de la persona
    private String direccion; // Dirección de la persona

    public Persona(String nombre, String telefono, String direccion) {
        this.nombre = nombre; // Asignar nombre
        this.telefono = telefono; // Asignar teléfono
        this.direccion = direccion; // Asignar dirección
    }

    public String getNombre() {
        return nombre; // Obtener nombre
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Teléfono: " + telefono + ", Dirección: " + direccion; // Representación en String
    }
}
