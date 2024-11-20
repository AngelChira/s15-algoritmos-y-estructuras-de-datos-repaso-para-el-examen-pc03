package PilasEstaticas;

public class Proveedor {
    private String cod, nombres, apellido;

    public Proveedor() {
    }

    public Proveedor(String cod) {
        this.cod = cod;
    }

    public Proveedor(String cod, String nombres, String apellido) {
        this.cod = cod;
        this.nombres = nombres;
        this.apellido = apellido;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return cod + " \t " + nombres + " \t " + apellido;
    }
    
    
}
