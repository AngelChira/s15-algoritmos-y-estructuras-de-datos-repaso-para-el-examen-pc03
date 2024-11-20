package ColaPrioridad;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.swing.JOptionPane;

public class ColaCliente {
    // Comparadores
    Comparator<QCliente> porOrden = Comparator.comparing(QCliente::getOrden);
    Comparator<QCliente> porEdad = Comparator.comparing(QCliente::getEdad);
    Comparator<QCliente> porTipo = Comparator.comparing(QCliente::getTipo);
    Comparator<QCliente> porHora = Comparator.comparing(QCliente::getHora);
    
    // Reglas del negocio
    Comparator<QCliente> porEdadDescOrden = porEdad.reversed().thenComparing(porOrden);
    Comparator<QCliente> porTipoOrden = porTipo.thenComparing(porOrden);
    Comparator<QCliente> porTipoHora = porTipo.thenComparing(porHora);
    Comparator<QCliente> porEdadTipoHora = porEdad.thenComparing(porTipo).thenComparing(porHora);
    
    // creamos prioridad 
    Queue<QCliente> colaClientes = new PriorityQueue<>(porEdadTipoHora);
    
    public void enqueue(QCliente cli) {
        colaClientes.offer(cli);
    }
    
    public QCliente dequeue() {
        QCliente cliente = null;
        if (colaClientes.size() > 0) {
            cliente = colaClientes.poll();
        } else {
            JOptionPane.showMessageDialog(null, "La cola esta vacia.");
        }
        return cliente;
    }
    
    public QCliente peek() {
        QCliente cliente = null;
        if (colaClientes.size() > 0) {
            cliente = colaClientes.peek();
        } else {
            JOptionPane.showMessageDialog(null, "La cola esta vacia.");
        }
        return cliente;
    }
    
    public int size() {
        return colaClientes.size();
    }
    
    public boolean isEmpty() {
        return colaClientes.isEmpty();
    }
    
    public void clear() {
        colaClientes.clear();
        JOptionPane.showMessageDialog(null, "Se ha limpiado la cola.");
    }
    
    public Queue<QCliente> listar() {
        return colaClientes;
    }
}
