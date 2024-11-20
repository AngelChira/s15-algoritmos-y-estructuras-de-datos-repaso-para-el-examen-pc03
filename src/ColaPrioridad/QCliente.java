package ColaPrioridad;

import java.time.LocalDateTime;
import java.util.Objects;

public class QCliente {
    public enum TipoCliente{GOLD, PREMIUN, REGULAR}
    
    private int orden;
    private String nombre;
    private int edad;
    private TipoCliente tipo;
    private LocalDateTime hora;

    public QCliente() {
    }

    public QCliente(int orden, String nombre, int edad, TipoCliente tipo, LocalDateTime hora) {
        this.orden = orden;
        this.nombre = nombre;
        this.edad = edad;
        this.tipo = tipo;
        this.hora = hora;
    }

    public QCliente(int orden) {
        this.orden = orden;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final QCliente other = (QCliente) obj;
        if (this.orden != other.orden) {
            return false;
        }
        if (this.edad != other.edad) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.hora, other.hora);
    }

    @Override
    public String toString() {
        return orden + " \t " + nombre + " \t " + edad + " \t " + tipo + " \t " + hora;
    }   
}
