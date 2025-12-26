package modelo.estructuras;

import modelo.Sucursal;

public class Pila {
    private NodoSimple cima;
    
    public Pila() {
        this.cima = null;
    }
    
    // Apilar (push)
    public void apilar(Sucursal sucursal) {
        NodoSimple nuevoNodo = new NodoSimple(sucursal);
        nuevoNodo.setSiguiente(cima);
        cima = nuevoNodo;
    }
    
    // Desapilar (pop)
    public Sucursal desapilar() {
        if (cima == null) {
            System.out.println("La pila está vacía");
            return null;
        }
        
        Sucursal sucursal = cima.getSucursal();
        cima = cima.getSiguiente();
        return sucursal;
    }
    
    // Ver la cima sin eliminar
    public Sucursal verCima() {
        if (cima == null) {
            return null;
        }
        return cima.getSucursal();
    }
    
    // Mostrar todos los elementos
    public void mostrar() {
        if (cima == null) {
            System.out.println("La pila está vacía");
            return;
        }
        
        NodoSimple actual = cima;
        while (actual != null) {
            System.out.println(actual.getSucursal());
            actual = actual.getSiguiente();
        }
    }
    
    public boolean estaVacia() {
        return cima == null;
    }
}
