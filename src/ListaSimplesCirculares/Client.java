package ListaSimplesCirculares;

public class Client {
    private String cod, nombre, apellido;

    public Client() {
    }

    public Client(String cod) {
        this.cod = cod;
    }

    public Client(String cod, String nombre, String apellido) {
        this.cod = cod;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return cod + " \t " + nombre + " \t " + apellido;
    }
    
}
