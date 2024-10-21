public class ArrayPersona {
    private Persona[] arreglo; // Arreglo de personas
    final int max = 128; // Tamaño máximo del arreglo
    int tamano = 0; // Tamaño actual del arreglo

    public ArrayPersona() {
    this.arreglo = new Persona[this.max]; // Inicializar el arreglo
    }

    public void printArray(String nombre) { // Imprimir personas con el nombre dado
        for (int i = 0; i < this.tamano; i++) {
            if (this.arreglo[i].getNombre().equals(nombre))
                System.out.println(this.arreglo[i]); // Imprimir la persona si coincide el nombre
        }
    }

    public void addArray(Persona persona) { // Añadir una persona al arreglo
        if (this.tamano == max)
            System.exit(1); // Salir si el arreglo está lleno
        this.arreglo[this.tamano++] = persona; // Añadir la persona y aumentar el tamaño
    }
}
