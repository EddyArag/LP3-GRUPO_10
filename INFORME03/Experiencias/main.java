package main;

import practica01.*;
import practica02.*;
import practica03.*;
import practica04.*;
import practica05.*;

public class Main {
    public static void main(String[] args) {
        // Ejemplo de uso para Práctica 01 (SRP)
        System.out.println("Práctica 01: SRP");
        Habitacion habitacion = new Habitacion("Doble", 150.0);
        System.out.println("Habitación disponible: " + habitacion.verificarDisponibilidad("2024-09-10", "2024-09-15"));

        // Ejemplo de uso para Práctica 02 (OCP)
        System.out.println("\nPráctica 02: OCP");
        Reserva reserva = new Reserva();
        PoliticaCancelacion politica = new PoliticaCancelacionFlexible();
        System.out.println("¿Se puede cancelar la reserva?: " + politica.puedeCancelar(reserva));

        // Ejemplo de uso para Práctica 03 (LSP)
        System.out.println("\nPráctica 03: LSP");
        Habitacion habitacion1 = new HabitacionIndividual();
        habitacion1.asignarCliente(new Cliente());

        // Ejemplo de uso para Práctica 04 (ISP)
        System.out.println("\nPráctica 04: ISP");
        HabitacionEstandar habitacionEstandar = new HabitacionEstandar();
        habitacionEstandar.solicitarLimpieza();

        // Ejemplo de uso para Práctica 05 (DIP)
        System.out.println("\nPráctica 05: DIP");
        CanalNotificacion canalCorreo = new EnviadorCorreo();
        NotificadorReserva notificador = new NotificadorReserva(canalCorreo);
        notificador.notificar("Mensaje de prueba para envío de correo.");
    }
}
