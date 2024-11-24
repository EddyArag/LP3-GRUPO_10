import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interfaz Observer: Define el contrato para los usuarios
interface Usuario {
    void recibirNotificacion(String mensaje);
}

// Clase concreta Usuario
class UsuarioConcreto implements Usuario {
    private String nombre;

    public UsuarioConcreto(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void recibirNotificacion(String mensaje) {
        System.out.println("Usuario " + nombre + " recibió: " + mensaje);
    }
}

// Clase Sujeto (Canal de Notificaciones)
class CanalNotificaciones {
    private List<Usuario> usuarios = new ArrayList<>();

    // Método para suscribir un usuario
    public void suscribir(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario suscrito.");
    }

    // Método para desuscribir un usuario
    public void desuscribir(Usuario usuario) {
        usuarios.remove(usuario);
        System.out.println("Usuario desuscrito.");
    }

    // Método para notificar a todos los usuarios
    public void notificarUsuarios(String mensaje) {
        for (Usuario usuario : usuarios) {
            usuario.recibirNotificacion(mensaje);
        }
    }
}

// Clase principal
public class KickNotificaciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear el canal de notificaciones
        CanalNotificaciones canal = new CanalNotificaciones();

        // Solicitar al usuario si desea suscribirse
        System.out.print("¿QUIERE SUSCRIBIRSE AL CANAL DE Vadr0? (S/N): ");
        String respuesta = scanner.nextLine().toUpperCase();

        if (respuesta.equals("S")) {
            // Crear el usuario y suscribirlo al canal
            System.out.print("Ingrese su nombre: ");
            String nombreUsuario = scanner.nextLine();
            Usuario usuario = new UsuarioConcreto(nombreUsuario);
            canal.suscribir(usuario);

            // Enviar notificaciones
            canal.notificarUsuarios("¡Vadr0 está en vivo ahora!");
            canal.notificarUsuarios("Nuevo contenido exclusivo disponible.");
        } else if (respuesta.equals("N")) {
            System.out.println("Gracias por su interés. ¡Hasta la próxima!");
        } else {
            System.out.println("Opción no válida. El programa terminará.");
        }
    }
}
