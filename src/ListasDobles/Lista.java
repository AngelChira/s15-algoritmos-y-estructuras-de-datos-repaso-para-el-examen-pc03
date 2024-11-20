package ListasDobles;

import javax.swing.JOptionPane;

public class Lista {
    Nodo inicio;
    Nodo fin;

    public Lista() {
        inicio = null;
        fin = null;
    }

    public void agregarInicio(Persona per) {
        if (inicio == null) {
            inicio = new Nodo(per, null, null);
            fin = inicio;
        } else {
            Nodo nuevo = new Nodo(per, null, inicio);
            inicio.setAnterior(nuevo);
            inicio = nuevo;
        }
    }

    public void agregarFinal(Persona per) {
        if (inicio == null) {
            inicio = new Nodo(per, null, null);
            fin = inicio;
        } else {
            Nodo nuevo = new Nodo(per, fin, null);
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }

    public void eliminarInicio() {
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "Lista vacia.");
            return;
        }

        inicio = inicio.getSiguiente();
        if (inicio != null) {
            inicio.setAnterior(null);
        } else {
            fin = null;
        }
    }

    public void eliminarFinal() {
        if (inicio == null || fin == null) {
            JOptionPane.showMessageDialog(null, "Lista vacia.");
            return;
        }

        fin = fin.getAnterior();
        if (fin != null) {
            fin.setSiguiente(null);
        } else {
            inicio = null;
        }
    }

    public void eliminarPersona(Persona per) {
        if (inicio == null || fin == null) {
            JOptionPane.showMessageDialog(null, "Lista vacia.");
            return;
        }

        if (inicio.getPersona().getCod().equalsIgnoreCase(per.getCod())) {
            if (inicio == fin) {
                inicio = null;
                fin = null;
            } else {
                inicio = inicio.getSiguiente();
                inicio.setAnterior(null);
            }
            JOptionPane.showMessageDialog(null, "Se elimino la persona.");
            return;
        } else {
            Nodo actual = inicio;
            while (actual != null) {
                if (actual.getPersona().getCod().equalsIgnoreCase(per.getCod())) {
                    if (actual == fin) {
                        fin = fin.getAnterior();
                        fin.setSiguiente(null);
                    } else {
                        actual.getAnterior().setSiguiente(actual.getSiguiente());
                        actual.getSiguiente().setAnterior(actual.getAnterior());
                    }
                    JOptionPane.showMessageDialog(null, "Se elimino la persona.");
                    return;
                }
                actual = actual.getSiguiente();
            }
        }
        JOptionPane.showMessageDialog(null, "No se elimino la persona.");
    }

    public void eliminarPosicion(int posicion) {
        if (inicio == null || fin == null) {
            JOptionPane.showMessageDialog(null, "Lista vacia.");
            return;
        }
        if (posicion == 0) {
            if (inicio == fin) {
                inicio = null;
                fin = null;
            } else {
                inicio = inicio.getSiguiente();
                inicio.setAnterior(null);
            }
            JOptionPane.showMessageDialog(null, "Se elimino la persona en la posicion 1.");
            return;
        }

        if (posicion > 0) {
            Nodo actual = inicio;
            int contador = 0;
            while (actual != null && contador < posicion) {
                actual = actual.getSiguiente();
                contador++;
            }
            if (actual == null) {
                JOptionPane.showMessageDialog(null, "Posición fuera del rango.");
                return;
            }
            if (actual == fin) {
                fin = fin.getAnterior();
                fin.setSiguiente(null);
            } else {
                actual.getAnterior().setSiguiente(actual.getSiguiente());
                actual.getSiguiente().setAnterior(actual.getAnterior());
            }
            JOptionPane.showMessageDialog(null, "Se elimino la persona en la posicion " + (posicion + 1) + ".");
            return;
        }
        JOptionPane.showMessageDialog(null, "No se elimino la persona.");
    }

    public boolean agregarPosicion(Persona per, int posicion) {
        if (posicion < 0) {
            JOptionPane.showMessageDialog(null, "Posicion invalida.");
            return false;
        }

        if (posicion == 0) {
            Nodo nuevo = new Nodo(per, null, inicio);
            if (inicio != null) {
                inicio.setAnterior(nuevo);
            }
            inicio = nuevo;
            if (fin == null) {
                fin = inicio;
            }
            return true;
        }

        Nodo actual = inicio;
        int contador = 0;
        while (actual != null && contador < posicion - 1 ) {
            actual = actual.getSiguiente();
            contador++;
        }
        if (actual == null || actual.getSiguiente() == null && contador < posicion - 1) {
            JOptionPane.showMessageDialog(null, "Posición fuera del rango.");
            return false;
        }
        Nodo nuevo = new Nodo(per, actual, actual.getSiguiente());
        if (actual.getSiguiente() != null) {
            actual.getSiguiente().setAnterior(nuevo);
        } else {
            fin = nuevo;
        }
        actual.setSiguiente(nuevo);
        return true;
    }

}
