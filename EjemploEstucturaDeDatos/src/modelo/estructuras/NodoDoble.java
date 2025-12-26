package modelo.estructuras;

import modelo.Sucursal;

public class NodoDoble {
    private Sucursal sucursal;
    private NodoDoble siguiente;
    private NodoDoble anterior;
    
    public NodoDoble(Sucursal sucursal) {
        this.sucursal = sucursal;
        this.siguiente = null;
        this.anterior = null;
    }
    
    public Sucursal getSucursal() {
        return sucursal;
    }
    
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
    public NodoDoble getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }
    
    public NodoDoble getAnterior() {
        return anterior;
    }
    
    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
}
