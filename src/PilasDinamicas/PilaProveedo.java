package PilasDinamicas;

import java.util.LinkedList;
import javax.swing.JOptionPane;

public class PilaProveedo {
    LinkedList<Proveedo> proveedos = new LinkedList<>();

    public PilaProveedo() {
    }
    
    public void push(Proveedo prove) {
        proveedos.add(prove);
    }
    
    public Proveedo pop() {
        Proveedo prove = null;
        if (proveedos.size() > 0) {
            prove = proveedos.getLast();
            proveedos.removeLast();
        } else {
            JOptionPane.showMessageDialog(null, "Pila vacia.");
        }
        return prove;
    }
    
    public Proveedo peek() {
        Proveedo prove = null;
        if (proveedos.size() > 0) {
            prove = proveedos.getLast();
        } else {
            JOptionPane.showMessageDialog(null, "Pila vacia.");
        }
        return prove;
    }
    
    public int size() {
        return proveedos.size();
    }
    
    public boolean isEmpty() {
        return proveedos.isEmpty();
    }
    
    public void clear() {
        proveedos.clear();
        JOptionPane.showMessageDialog(null, "La pila se ha vaciado.");
    }
    
    public LinkedList<Proveedo> listar() {
        return proveedos;
    }
    
    
}
