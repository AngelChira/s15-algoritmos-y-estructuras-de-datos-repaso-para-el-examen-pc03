package ColaEstatica;

import javax.swing.JOptionPane;

public class ColaUsuario {
    private Usuario[] usuarios = new Usuario[15];
    private int size;
    private int inicio, fin;
    
    public ColaUsuario() {
        size = 0;
        inicio = 0;
        fin = 0;
    }
    
    public void enqueue(Usuario user) {
        if (size < usuarios.length - 1) {
            usuarios[fin] = user;
            fin = (fin + 1) % usuarios.length;
            size++;
        } else {
            JOptionPane.showMessageDialog(null, "La cola esta llena.");
        }
    }
    
    public Usuario dequeue() {
        Usuario user = null;
        if (size > 0) {
            user = usuarios[inicio];
            usuarios[inicio] = null;
            inicio = (inicio + 1) % usuarios.length;
            size--;
        } else {
            JOptionPane.showMessageDialog(null, "La cosa esta vacia.");
        }
        return user;
    }
    
    public Usuario peek() {
        Usuario user = null;
        if (size > 0) {
            user = usuarios[inicio];
        } else {
            JOptionPane.showMessageDialog(null, "La cosa esta vacia.");
        }
        return user;
    }
    
    public void clear() {
        for (int i = 0; i < usuarios.length; i++) {
            usuarios[i] = null;
        }
        size = 0;
        inicio = 0;
        fin = 0;
        JOptionPane.showMessageDialog(null, "Se limpio la cola.");
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    public Usuario[] listar() {
        return usuarios;
    }
}
