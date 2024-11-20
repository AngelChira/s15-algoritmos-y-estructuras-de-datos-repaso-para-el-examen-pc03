package PilasEstaticas;

import javax.swing.JOptionPane;

public class PilaProveedor {
    private Proveedor[] proveedores = new Proveedor[15];
    private int top;

    public PilaProveedor() {
        this.top = -1;
    }
    
    public void push(Proveedor prove) {
        if (top == proveedores.length - 1) {
            System.out.println("La pila esta llena.");
        } else {
            top++;
            proveedores[top]=prove;
        }
    }
    
    public Proveedor pop() {
        Proveedor proveedor =null;
        if (top == -1) {
            JOptionPane.showMessageDialog(null,"La pila esta vacia.");
        } else {
            proveedor = proveedores[top];
            proveedores[top] = null;
            top--;
        }
        return proveedor;
    }
    
    public Proveedor peek() {
        Proveedor proveedor = null;
        if (top == -1) {
            System.out.println("La pila esta vacia.");
        } else {
            proveedor = proveedores[top];
        }
        return proveedor;
    }
    
    public int size() {
        return top +1;
    }
    
    public boolean isEmpty() {
        return top ==- 1;
    }
    
    public void clear() {
        top = -1;
        for (int i = 0; i < proveedores.length; i++) {
            proveedores[i] = null;
        }
        JOptionPane.showMessageDialog(null, "Se ha limpiado toda la pila.");
    }
    
    public Proveedor[] lista() {
        return proveedores;
    } 
}
