package MVCFinal;

public class Pedido {
    private String nombrePlato;
    private boolean completado;

    public Pedido(String nombrePlato) {
        this.nombrePlato = nombrePlato;
        this.completado = false;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void completar() {
        this.completado = true;
    }
}
