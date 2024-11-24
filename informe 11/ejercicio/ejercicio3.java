import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// INTERFAZ OBSERVER
interface Observer {
    void update(String message); // Método para notificar al usuario
}

// CLASE CONCRETA USUARIO (OBSERVADOR)
class Usuario implements Observer {
    private String nombre;

    public Usuario(String nombre) { // Constructor
        this.nombre = nombre;
    }

    @Override
    public void update(String message) {
        System.out.println("Notificación para " + nombre + ": " + message);
    }
}

// CLASE SUBJECT (NetflixService)
class NetflixService {
    private List<Observer> usuarios = new ArrayList<>(); // Lista de suscriptores

    public void agregarUsuario(Observer usuario) {
        usuarios.add(usuario);
    }

    public void eliminarUsuario(Observer usuario) {
        usuarios.remove(usuario);
    }

    public void notificarUsuarios(String mensaje) {
        for (Observer usuario : usuarios) {
            usuario.update(mensaje);
        }
    }

    public void nuevaPelicula(String titulo) {
        System.out.println("Nueva película lanzada: " + titulo);
        notificarUsuarios("¡Nueva película disponible: " + titulo + "!");
    }
}

// INTERFAZ STRATEGY PARA PLANES
interface PlanSuscripcion {
    double calcularPrecio(); // Método para calcular el precio del plan
    String getDescripcion(); // Descripción del plan
}

// PLAN BÁSICO
class PlanBasico implements PlanSuscripcion {
    @Override
    public double calcularPrecio() {
        return 7.99;
    }

    @Override
    public String getDescripcion() {
        return "Plan Básico: calidad estándar, sin HD.";
    }
}

// PLAN ESTÁNDAR
class PlanEstandar implements PlanSuscripcion {
    @Override
    public double calcularPrecio() {
        return 10.99;
    }

    @Override
    public String getDescripcion() {
        return "Plan Estándar: calidad HD, para dos dispositivos.";
    }
}

// PLAN PREMIUM
class PlanPremium implements PlanSuscripcion {
    @Override
    public double calcularPrecio() {
        return 15.99;
    }

    @Override
    public String getDescripcion() {
        return "Plan Premium: calidad 4K, para cuatro dispositivos.";
    }
}

// CLASE SUSCRIPCIÓN (Contexto del Strategy)
class Suscripcion {
    private PlanSuscripcion plan; // Plan actual seleccionado

    public void setPlan(PlanSuscripcion plan) {
        this.plan = plan;
    }

    public void mostrarDetallesPlan() {
        if (plan == null) {
            System.out.println("No se ha seleccionado un plan de suscripción.");
        } else {
            System.out.println(plan.getDescripcion() + " Precio: $" + plan.calcularPrecio());
        }
    }
}

// CLASE PRINCIPAL
public class NetflixApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Configuración del servicio Netflix
        NetflixService netflix = new NetflixService();

        // Crear usuarios
        Usuario usuario1 = new Usuario("Juan");
        Usuario usuario2 = new Usuario("María");

        // Suscribir usuarios al servicio
        netflix.agregarUsuario(usuario1);
        netflix.agregarUsuario(usuario2);

        // Simular el lanzamiento de una nueva película
        netflix.nuevaPelicula("El Señor de los Anillos");

        // Manejo de planes de suscripción
        Suscripcion suscripcion = new Suscripcion();

        System.out.println("\nSeleccione un plan de suscripción:");
        System.out.println("1. Básico");
        System.out.println("2. Estándar");
        System.out.println("3. Premium");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                suscripcion.setPlan(new PlanBasico());
                break;
            case 2:
                suscripcion.setPlan(new PlanEstandar());
                break;
            case 3:
                suscripcion.setPlan(new PlanPremium());
                break;
            default:
                System.out.println("Opción no válida. No se seleccionó ningún plan.");
                break;
        }

        // Mostrar detalles del plan seleccionado
        suscripcion.mostrarDetallesPlan();

        scanner.close();
    }
}
