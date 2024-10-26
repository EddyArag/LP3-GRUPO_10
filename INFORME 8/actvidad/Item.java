public class Item {
    private int id;
    private String nombre;
    private String efecto; // Ejemplo: 'Cura', 'Aumenta Resistencia'

    public Item(int id, String nombre, String efecto) {
        this.id = id;
        this.nombre = nombre;
        this.efecto = efecto;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEfecto() {
        return efecto;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", nombre='" + nombre + "', efecto='" + efecto + "'}";
    }
}
