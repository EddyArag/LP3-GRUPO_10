import java.util.Scanner;

// Interfaz Strategy para las estrategias de descuento
interface EstrategiaDescuento {
    double aplicarDescuento(double precio, int cantidad);
}

// Estrategia Sin Descuento
class SinDescuento implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(double precio, int cantidad) {
        return precio * cantidad; // No aplica descuento
    }
}

// Estrategia Descuento Fijo (10%)
class DescuentoFijo implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(double precio, int cantidad) {
        return (precio * cantidad) * 0.9; // Aplica un 10% de descuento
    }
}

// Estrategia Descuento Porcentual (30% para 2 productos iguales)
class DescuentoPorcentual implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(double precio, int cantidad) {
        if (cantidad == 2) {
            return (precio * cantidad) * 0.7; // Aplica un 30% de descuento
        } else {
            return precio * cantidad; // Sin descuento si no son 2 productos
        }
    }
}

// Estrategia Descuento Porcentual Acumulado (50% sobre el más barato si hay 3 o más productos)
class DescuentoPorcentualAcumulado implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(double precio, int cantidad) {
        if (cantidad >= 3) {
            return (precio * cantidad) - (precio * 0.5); // Aplica un 50% de descuento en el más barato
        } else {
            return precio * cantidad; // Sin descuento si hay menos de 3 productos
        }
    }
}

// Clase Producto
class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}

// Clase Calculadora de Precios (Contexto)
class CalculadoraDePrecios {
    private EstrategiaDescuento estrategiaDescuento;

    public void setEstrategiaDescuento(EstrategiaDescuento estrategia) {
        this.estrategiaDescuento = estrategia;
    }

    public double calcularPrecioFinal(Producto producto, int cantidad) {
        return estrategiaDescuento.aplicarDescuento(producto.getPrecio(), cantidad);
    }
}

// Clase principal
public class TiendaComponentes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear productos
        Producto[] productos = {
            new Producto("Procesador Intel i7", 1200.0),
            new Producto("NVIDIA RTX 3060", 2000.0),
            new Producto("Memoria RAM 16GB", 500.0)
        };

        // Mostrar productos disponibles
        System.out.println("Productos disponibles:");
        for (int i = 0; i < productos.length; i++) {
            System.out.println((i + 1) + ". " + productos[i].getNombre() + " - $" + productos[i].getPrecio());
        }

        // Seleccionar producto
        System.out.print("Selecciona el número del producto: ");
        int seleccionProducto = scanner.nextInt();
        if (seleccionProducto < 1 || seleccionProducto > productos.length) {
            System.out.println("Opción no válida. El programa terminará.");
            return;
        }

        Producto productoSeleccionado = productos[seleccionProducto - 1];

        // Pedir cantidad
        System.out.print("Ingrese la cantidad: ");
        int cantidad = scanner.nextInt();
        if (cantidad <= 0) {
            System.out.println("Cantidad no válida. El programa terminará.");
            return;
        }

        // Seleccionar estrategia de descuento
        System.out.println("Selecciona una estrategia de descuento:");
        System.out.println("1. Sin Descuento");
        System.out.println("2. Descuento Fijo (10%)");
        System.out.println("3. Descuento Porcentual (30% para 2 productos iguales)");
        System.out.println("4. Descuento Porcentual Acumulado (50% sobre el producto más barato a partir de 3 productos)");
        int seleccionEstrategia = scanner.nextInt();

        CalculadoraDePrecios calculadora = new CalculadoraDePrecios();
        switch (seleccionEstrategia) {
            case 1 -> calculadora.setEstrategiaDescuento(new SinDescuento());
            case 2 -> calculadora.setEstrategiaDescuento(new DescuentoFijo());
            case 3 -> calculadora.setEstrategiaDescuento(new DescuentoPorcentual());
            case 4 -> calculadora.setEstrategiaDescuento(new DescuentoPorcentualAcumulado());
            default -> {
                System.out.println("Opción no válida. El programa terminará.");
                return;
            }
        }

        // Calcular precio final
        double precioFinal = calculadora.calcularPrecioFinal(productoSeleccionado, cantidad);
        System.out.printf("El precio final es: $%.2f%n", precioFinal);
    }
}
