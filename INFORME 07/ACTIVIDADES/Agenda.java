import java.io.FileInputStream; // Para leer archivos como secuencia de bytes
import java.io.FileNotFoundException; // Excepción si el archivo no se encuentra
import java.io.IOException; // Excepciones de E/S
import java.io.InputStream; // Para leer datos de flujo de entrada

public class Agenda {
    ArrayPersona lista; // Lista de contactos
    FileInputStream agendaFile; // Archivo de la agenda
    final int longLinea = 32; // Longitud de línea

    public Agenda() {
        this.lista = cargaContactos(); // Cargar los contactos al crear la agenda
    }

    public void bucle() { // Bucle para pedir nombres
        String nombre;
        System.out.println("Introduzca un nombre o <ENTER>"); // Pedir nombre
        try {
            while (!"".equals(nombre = leeEntrada(System.in))) { // Leer nombres hasta que se presione Enter
                lista.printArray(nombre); // Imprimir personas con ese nombre
                System.out.println("Introduzca un nombre o <ENTER>"); // Pedir otro nombre
            }
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Mostrar mensaje de error
        }
    }

    private String leeEntrada(InputStream entrada) throws IOException { // Leer entrada del usuario
        byte chars[] = new byte[longLinea]; // Crear buffer de bytes
        int contador = 0;
        while (contador < longLinea && (chars[contador++] = (byte) entrada.read()) != '\n')
            if (chars[contador - 1] == -1)
                return null; // Fin de archivo
        return (new String(chars, 0, contador - 1)); // Convertir bytes a String
    }

    private Persona cargaAgenda() throws IOException { // Cargar una persona de la agenda
        String nombre = leeEntrada(agendaFile);
        if (nombre == null)
            return null;
        String telefono = leeEntrada(agendaFile);
        String direccion = leeEntrada(agendaFile);
        return new Persona(nombre, telefono, direccion); // Crear y devolver una persona
    }

    private ArrayPersona cargaContactos() { // Cargar todos los contactos
        ArrayPersona directorio = new ArrayPersona();
        Persona nuevaPersona;
        try {
            agendaFile = new FileInputStream("src/agenda.txt"); // Abrir el archivo de la agenda
            while (true) {
                nuevaPersona = cargaAgenda();
                if (nuevaPersona == null)
                    return directorio; // Devolver directorio si no hay más personas
                directorio.addArray(nuevaPersona); // Añadir persona al directorio
            }
        } catch (FileNotFoundException e) {
            System.out.println("No hay archivo de agenda"); // Mostrar mensaje si no se encuentra el archivo
        } catch (Exception e) {
            System.out.println("Error en la carga de los contactos"); // Mostrar mensaje de error
            System.exit(1);
        }
        return directorio;
    }

    public static void main(String[] args) {
        Agenda agenda = new Agenda(); // Crear una agenda
        agenda.bucle(); // Ejecutar el bucle
    }
}