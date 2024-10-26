public class Sobreviviente {
    private int id;
    private String nombre;
    private String rol; // Ejemplo: 'Líder', 'Médico'
    private int salud;

    public Sobreviviente(int id, String nombre, String rol, int salud) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.salud = salud;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    public int getSalud() {
        return salud;
    }

    @Override
    public String toString() {
        return "Sobreviviente{" + "id=" + id + ", nombre='" + nombre + "', rol='" + rol + "', salud=" + salud + "}";
    }
}
