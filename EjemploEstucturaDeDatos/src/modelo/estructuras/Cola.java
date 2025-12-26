package modelo.estructuras;

import modelo.Sucursal;

public class Cola {
    private NodoSimple frente;
    private NodoSimple finalCola;
    
    public Cola() {
        this.frente = null;
        this.finalCola = null;
    }
    
    // Encolar (agregar al final)
    public void encolar(Sucursal sucursal) {
        NodoSimple nuevoNodo = new NodoSimple(sucursal);
        
        if (finalCola == null) {
            frente = nuevoNodo;
            finalCola = nuevoNodo;
        } else {
            finalCola.setSiguiente(nuevoNodo);
            finalCola = nuevoNodo;
        }
    }
    
    // Desencolar (eliminar del frente)
    public Sucursal desencolar() {
        if (frente == null) {
            System.out.println("La cola está vacía");
            return null;
        }
        
        Sucursal sucursal = frente.getSucursal();
        frente = frente.getSiguiente();
        
        if (frente == null) {
            finalCola = null;
        }
        
        return sucursal;
    }
    
    // Ver el frente sin eliminar
    public Sucursal verFrente() {
        if (frente == null) {
            return null;
        }
        return frente.getSucursal();
    }
    
    // Mostrar todos los elementos
    public void mostrar() {
        if (frente == null) {
            System.out.println("La cola está vacía");
            return;
        }
        
        NodoSimple actual = frente;
        while (actual != null) {
            System.out.println(actual.getSucursal());
            actual = actual.getSiguiente();
        }
    }
    
    public boolean estaVacia() {
        return frente == null;
    }
}
