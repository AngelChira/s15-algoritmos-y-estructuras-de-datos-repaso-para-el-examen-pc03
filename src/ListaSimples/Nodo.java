package ListaSimples;

public class Nodo {
    private Cliente cliente;
    private Nodo siguiente;

    public Nodo() {
    }

    public Nodo(Cliente cliente, Nodo siguiente) {
        this.cliente = cliente;
        this.siguiente = siguiente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
