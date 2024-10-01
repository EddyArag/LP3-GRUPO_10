public class Pila<E> {
    private final int tamaño;
    private int superior;
    private E[] elementos;

    // Constructor que inicializa la pila con un tamaño predeterminado
    public Pila() {
        this(10); // Tamaño predeterminado de la pila
    }

    // Constructor que crea una pila de tamaño especificado
    public Pila(int s) {
        tamaño = s > 0 ? s : 10; // Establece el tamaño de la pila
        superior = -1; // Al principio la pila está vacía
        elementos = (E[]) new Object[Tamaño]; //Arreglo de tipo E
    }

    // Método para agregar un elemento a la pila
    public void push(E valorAMeter) {
        if (superior == Tamaño - 1) {
            throw new IllegalStateException("Pila llena");
        }
        elementos[++superior] = valorAMeter; // Agrega el elemento
    }

    // Método para sacar un elemento de la pila
    public E pop() {
        if (superior == -1) {
            throw new IllegalStateException("Pila vacía");
        }
        return elementos[superior--]; // Elimina y devuelve el último elemento
    }

    // Método para verificar si un elemento está en la pila
    public boolean contains(E elemento) {
        for (int i = superior; i >= 0; i--) {
            if (elementos[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>(5);
        pila.push(10);
        pila.push(20);
        pila.push(30);
        System.out.println("¿La pila contiene 20? " + pila.contains(20)); // true
        System.out.println("¿La pila contiene 40? " + pila.contains(40)); // false
    }
}
