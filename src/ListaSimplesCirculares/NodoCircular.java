package ListaSimplesCirculares;

public class NodoCircular {
    private Client client;
    private NodoCircular sgte;

    public NodoCircular() {
    }

    public NodoCircular(Client client, NodoCircular sgte) {
        this.client = client;
        this.sgte = sgte;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public NodoCircular getSgte() {
        return sgte;
    }

    public void setSgte(NodoCircular sgte) {
        this.sgte = sgte;
    }
    
}
