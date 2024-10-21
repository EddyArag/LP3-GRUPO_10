import java.io.Serializable; // Para que la clase sea serializable

public class Fecha implements Serializable { // Clase que implementa Serializable

    private int dia; // Día de la fecha
    private int mes; // Mes de la fecha
    private int año; // Año de la fecha

    public Fecha(int dia, int mes, int año) { // Constructor con parámetros
        this.dia = dia; // Asignar día
        this.mes = mes; // Asignar mes
        this.año = año; // Asignar año
    }

    public Fecha() {
    }

    public int getAño() {
        return año; // Obtener año
    }

    public void setAño(int año) {
        this.año = año; // Asignar año
    }

    public int getDia() {
        return dia; // Obtener día
    }

    public void setDia(int dia) {
        this.dia = dia; // Asignar día
    }

    public int getMes() {
        return mes; // Obtener mes
    }

    public void setMes(int mes) {
        this.mes = mes; // Asignar mes
    }
}
