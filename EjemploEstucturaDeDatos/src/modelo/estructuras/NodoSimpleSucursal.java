package modelo.estructuras;

import modelo.Sucursal;

public class NodoSimple {
    private Sucursal sucursal;
    private NodoSimple siguiente;
    
    public NodoSimple(Sucursal sucursal) {
        this.sucursal = sucursal;
        this.siguiente = null;
    }
    
    public Sucursal getSucursal() {
        return sucursal;
    }
    
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
    public NodoSimple getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(NodoSimple siguiente) {
        this.siguiente = siguiente;
    }
}
