package ListaSimples;

import javax.swing.JOptionPane;

public class ListaEnlazada {
    Nodo inicio;
    Nodo fin;

    public ListaEnlazada() {
        this.inicio = null;
        this.fin = null;
    }

    public void agregarInicio(Cliente cli) {
        Nodo nuevo = new Nodo(cli, inicio);
        inicio = nuevo;
        if (fin == null) {
            fin = inicio;
        }
    }

    public void agregarFinal(Cliente cli) {
        Nodo nuevo = new Nodo(cli, null);
        if (inicio == null) {
            fin = nuevo;
            inicio = fin;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }
    
    public boolean agregarPosicion(Cliente cli, int posicion) {
        if (posicion < 0) {
            JOptionPane.showMessageDialog(null, "Posición invalida.");
            return false;
        }
        
        Nodo nuevo = new Nodo(cli, null);
        if (posicion == 0) {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
            if (fin == null) {
                fin = nuevo;
            }
            return true;
        } else {
            Nodo actual = inicio;
            int contador = 0;
            while(actual != null && contador < posicion -1) {
                actual = actual.getSiguiente();
                contador++;
            }
            if (actual == null) {
                JOptionPane.showMessageDialog(null, "Posición fuera del rango.");
                return false;
            }
            
            nuevo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevo);
            if (nuevo.getSiguiente() == null) {
                fin = nuevo;
            }
            return true;
        }
    }

    public void eliminarInicio() {
        if (inicio == null || fin == null) {
            JOptionPane.showMessageDialog(null, "Lista vacia.");
        } else {
            inicio = inicio.getSiguiente();
        }
    }

    public void eliminarFinal() {
        if (inicio == null || fin == null) {
            JOptionPane.showMessageDialog(null, "Lista vacia.");
            return;
        }
        
        if (inicio == fin) {
            inicio = null;
            fin = null;
        } else {
            Nodo actual = inicio;
            while(actual.getSiguiente() != fin ) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(null);
            fin = actual;
        }
    }
    
    public void eliminarCliente(Cliente clie) {
        if (inicio == null || fin == null) {
            JOptionPane.showMessageDialog(null, "Lista vacia.");
            return;
        }
        if (inicio.getCliente().getCod().equalsIgnoreCase(clie.getCod())) {
            inicio = inicio.getSiguiente();
            if (inicio == null) {
                fin = null;
            }
            JOptionPane.showMessageDialog(null, "Se elimino el cliente.");
            return;
        } else {
            Nodo actual = inicio;
            while(actual.getSiguiente() != null) {
                if (actual.getSiguiente().getCliente().getCod().equalsIgnoreCase(clie.getCod())) {
                    actual.setSiguiente(actual.getSiguiente().getSiguiente());
                    if(actual.getSiguiente() == null) {
                        fin = actual;
                    }
                    JOptionPane.showMessageDialog(null, "Se elimino el cliente.");
                    return;
                }
                actual = actual.getSiguiente();
            }
        }
        JOptionPane.showMessageDialog(null, "No se elimino el cliente.");
    }
    
    public void eliminarPosicion(int posicion) {
        if (inicio == null || fin == null) {
            JOptionPane.showMessageDialog(null, "Lista vacia.");
            return;
        }
        if (posicion < 0) {
            JOptionPane.showMessageDialog(null, "Posición invalida.");
            return;
        }
        
        if (posicion == 0) {
            inicio = inicio.getSiguiente();
            if (inicio == null) {
                fin = null;
            }
            JOptionPane.showMessageDialog(null, "Se elimino el cliente en la posición 1.");
        } else {
            Nodo actual = inicio;
            int contador = 0;
            while (actual != null && contador < posicion - 1) {
                actual = actual.getSiguiente();
                contador++;
            }
            if (actual == null || actual.getSiguiente() == null) {
                JOptionPane.showMessageDialog(null, "Posición fuera del rango");
            } else {
                Nodo siguiente = actual.getSiguiente().getSiguiente();
                if (siguiente == null) {
                    fin = actual;
                }
                actual.setSiguiente(siguiente);
                JOptionPane.showMessageDialog(null, "Se elimino el cliente en la posición " + (posicion + 1) + ".");
            }
        }
    }
    
    
    
}
