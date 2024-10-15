package MVCFinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PedidoModelo modelo = new PedidoModelo();
        PedidoVista vista = new PedidoVista();
        PedidoControlador controlador = new PedidoControlador(modelo, vista);
        controlador.iniciar();
    }
}
