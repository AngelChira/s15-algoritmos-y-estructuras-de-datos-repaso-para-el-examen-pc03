package ListasDobles;

public class Persona {
    private String cod, nombre, apellido;

    public Persona() {
    }

    public Persona(String cod, String nombre, String apellido) {
        this.cod = cod;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Persona(String cod) {
        this.cod = cod;
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
    
}