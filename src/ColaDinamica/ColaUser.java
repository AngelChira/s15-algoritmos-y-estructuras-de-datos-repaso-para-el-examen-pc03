package ColaDinamica;

import java.util.LinkedList;
import javax.swing.JOptionPane;

public class ColaUser {
    LinkedList<User> users = new LinkedList<>();

    public ColaUser() {
    }
    
    public void enqueue(User us) {
        users.addLast(us);
    }
    
    public User dequeue() {
        User use = null;
        if (users.size() > 0) {
            use = users.removeFirst();
        } else {
            JOptionPane.showMessageDialog(null, "La cola esta vacia.");
        }
        return use;
    }
    
    public User peek() {
        User use = null;
        if (users.size() > 0) {
            use = users.getFirst();
        } else {
            JOptionPane.showMessageDialog(null, "La cola esta vacia.");
        }
        return use;
    }
    
    public int size() {
        return users.size();
    }
    
    public void clear() {
        users.clear();
        JOptionPane.showMessageDialog(null, "La cola cola se ha limpiado.");
    }
    
    public boolean isEmpty() {
        return users.isEmpty();
    }
    
    public LinkedList<User> listar() {
        return users;
    }
}
