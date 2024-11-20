package ListasDobles;

public class Nodo {
    // Semana 09 -- Lunes recuperación
    private Persona persona;
    private Nodo anterior;
    private Nodo siguiente;

    public Nodo() {
    }

    public Nodo(Persona persona, Nodo anterior, Nodo siguiente) {
        this.persona = persona;
        this.anterior = anterior;
        this.siguiente = siguiente;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
