package ListaSimplesCirculares;

import javax.swing.JOptionPane;

public class ListaEnlazadaCircular {
    NodoCircular inicio;
    int tamanio;

    public ListaEnlazadaCircular() {
        this.inicio = null;
        tamanio = 0;
    }
    
    public void agregarInicio(Client cli) {
        NodoCircular nuevo = new NodoCircular(cli, null);
        if (inicio == null) { 
            nuevo.setSgte(nuevo);
            inicio = nuevo;
        } else {
            NodoCircular actual = inicio;
            while (actual.getSgte() != inicio) {
                actual = actual.getSgte();
            }
            actual.setSgte(nuevo); 
            nuevo.setSgte(inicio); 
            inicio = nuevo;
        }
        tamanio++;
    }
    
    public void agregarFinal(Client cli) {
        NodoCircular nuevo = new NodoCircular(cli, null);
        if (inicio == null) {
            nuevo.setSgte(nuevo);
            inicio = nuevo;
        } else {
            NodoCircular actual = inicio;
            while (actual.getSgte() != inicio) {
                actual = actual.getSgte();
            }
            actual.setSgte(nuevo);
            nuevo.setSgte(inicio);
        }
        tamanio++;
    }
    
    public void eliminarInicio() {
        if(inicio == null) {
            JOptionPane.showMessageDialog(null, "Lista vacia.");
            return;
        }
        if (inicio.getSgte() == inicio) {
            inicio = null;
        } else {
            NodoCircular actual = inicio;
            while(actual.getSgte() != inicio) {
                actual = actual.getSgte();
            }
            inicio = inicio.getSgte();
            actual.setSgte(inicio);
        }
        tamanio--;
    }
    
    public void eliminarFinal() {
        if(inicio == null) {
            JOptionPane.showMessageDialog(null, "Lista vacia.");
            return;
        }
        
        if (inicio.getSgte() == inicio) {
            inicio = null;
        } else {
            NodoCircular ultimo = inicio;
            NodoCircular anterior = null;
            while (ultimo.getSgte() != inicio) {
                anterior = ultimo;
                ultimo = ultimo.getSgte();
            }
            anterior.setSgte(inicio);
        }
        tamanio--;
    }
    
    public void eliminarPersona(Client cli) {
        if(inicio == null) {
            JOptionPane.showMessageDialog(null, "Lista vacia.");
            return;
        }
        
        if (inicio.getClient().getCod().equalsIgnoreCase(cli.getCod())) {
            if (inicio.getSgte() == inicio) {
                inicio = null;
            } else {
                NodoCircular actual = inicio;
                while (actual.getSgte() != inicio) {                
                    actual = actual.getSgte();
                }
                inicio = inicio.getSgte();
                actual.setSgte(inicio);
            }
            tamanio--;
        } else {
            NodoCircular actual = inicio;
            while(actual.getSgte() != inicio) {
                if (actual.getSgte().getClient().getCod().equalsIgnoreCase(cli.getCod())) {
                    actual.setSgte(actual.getSgte().getSgte());
                    tamanio--;
                    return;
                }
                actual = actual.getSgte();
            }
        }
        
    }
    
    public void eliminarPosicion(int posicion) {
        if(inicio == null) {
            JOptionPane.showMessageDialog(null, "Lista vacia.");
            return;
        }
        
        if (posicion < 0) {
            JOptionPane.showMessageDialog(null, "Posición invalida.");
            return;
        }
        
        if (posicion == 0) {
            if (inicio.getSgte() == inicio) {
                inicio = null;
            } else {
                NodoCircular actual = inicio;
                while (actual.getSgte() != inicio) {
                    actual = actual.getSgte();
                }
                inicio = inicio.getSgte();
                actual.setSgte(inicio);
            }
            tamanio--;
        } else {
            NodoCircular actual = inicio;
            int contador = 0;
            while(actual.getSgte() != inicio && contador < posicion - 1) {
                actual = actual.getSgte();
                contador++;
            }
            if (posicion >= tamanio) {
                JOptionPane.showMessageDialog(null, "Posición fuera del rango.");
                return;
            }
            actual.setSgte(actual.getSgte().getSgte()); 
            tamanio--;
        }
    }
    
    public boolean agregarPosicion(Client cli, int posicion) {
        if (posicion < 0) {
            JOptionPane.showMessageDialog(null, "Posición invalida.");
            return false;
        }
        
        if (posicion > tamanio) {
            JOptionPane.showMessageDialog(null, "Posición fuera del rango.");
            return false;
        }
        
        NodoCircular nuevo = new NodoCircular(cli, null);
        if (posicion == 0) {
            if (inicio == null) {
                inicio = nuevo;
                nuevo.setSgte(nuevo);
            } else {
                NodoCircular actual = inicio;
                while (actual.getSgte() != inicio) {
                    actual = actual.getSgte();
                }
                actual.setSgte(nuevo);
                nuevo.setSgte(inicio);
                inicio = nuevo;
            }
            tamanio++;
            return true;
        }
        NodoCircular actual = inicio;
        int contador = 0;
        while(contador < posicion -1 && actual.getSgte() != inicio) {
            actual = actual.getSgte();
            contador++;
        }
        nuevo.setSgte(actual.getSgte());
        actual.setSgte(nuevo);
        tamanio++;
        return true;
    }
}
