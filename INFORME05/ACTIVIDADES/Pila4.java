public class Pila<E> {
    private final int tamaño;
    private int superior;
    private E[] elementos;

    // Constructor que inicializa la pila
    public Pila(int s) {
        tamaño = s > 0 ? s : 10;
        superior = -1;
        elementos = (E[]) new Object[tamaño];
    }

    public void push(E valor) {
        if (superior == tamaño - 1) {
            throw new IllegalStateException("Pila llena");
        }
        elementos[++superior] = valor;
    }

    // Método para comparar dos pilas
    public boolean esIgual(Pila<E> otraPila) {
        if (this.superior != otraPila.superior) {
            return false;
        }
        for (int i = 0; i <= superior; i++) {
            if (!this.elementos[i].equals(otraPila.elementos[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Pila<Integer> pila1 = new Pila<>(5);
        Pila<Integer> pila2 = new Pila<>(5);

        pila1.push(10);
        pila1.push(20);

        pila2.push(10);
        pila2.push(20);

        System.out.println("¿Las pilas son iguales? " + pila1.esIgual(pila2)); // true
    }
}
