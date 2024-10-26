public class Arma {
    private int id;
    private String nombre;
    private String tipo; // Ejemplo: 'Rifle', 'Escopeta'
    private int daño;

    public Arma(int id, String nombre, String tipo, int daño) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.daño = daño;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getDaño() {
        return daño;
    }

    @Override
    public String toString() {
        return "Arma{" + "id=" + id + ", nombre='" + nombre + "', tipo='" + tipo + "', daño=" + daño + "}";
    }
}
