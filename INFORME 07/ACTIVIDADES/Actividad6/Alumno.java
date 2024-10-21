public class Alumno extends Persona { // Alumno extiende Persona

    private Fecha fechaMatricula; // Fecha de matrícula del alumno

    public Alumno(String nif, String nombre, int edad, Fecha fechaMatricula) { // Constructor con parámetros
        super(nif, nombre, edad); // Llamar al constructor de la superclase
        this.fechaMatricula = new Fecha(); // Inicializar la fecha de matrícula
        setFechaMatricula(fechaMatricula); // Asignar la fecha de matrícula
    }

    public Alumno() {
    }

    public Fecha getFechaMatricula() {
        return fechaMatricula; // Obtener la fecha de matrícula
    }

    public void setFechaMatricula(Fecha fechaMatricula) {
        this.fechaMatricula.setDia(fechaMatricula.getDia()); // Asignar día de la fecha de matrícula
        this.fechaMatricula.setMes(fechaMatricula.getMes()); // Asignar mes de la fecha de matrícula
        this.fechaMatricula.setAño(fechaMatricula.getAño()); // Asignar año de la fecha de matrícula
    }
}
