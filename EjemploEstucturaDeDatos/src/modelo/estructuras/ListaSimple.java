package modelo.estructuras;

import modelo.Sucursal;

public class ListaSimple {
    private NodoSimpleSucursal cabeza;
    
    public ListaSimple() {
        this.cabeza = null;
    }
    
    // Agregar al final
    public void agregar(Sucursal sucursal) {
        NodoSimpleSucursal nuevoNodo = new NodoSimpleSucursal(sucursal);
        
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoSimpleSucursal actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }
    
    // Eliminar por ID
    public boolean eliminar(int id) {
        if (cabeza == null) {
            return false;
        }
        
        if (cabeza.getSucursal().getIdSucursal() == id) {
            cabeza = cabeza.getSiguiente();
            return true;
        }
        
        NodoSimpleSucursal actual = cabeza;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getSucursal().getIdSucursal() == id) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }
    
    
    // Buscar por ID
    public Sucursal buscar(int id) {
        NodoSimpleSucursal actual = cabeza;
        while (actual != null) {
            if (actual.getSucursal().getIdSucursal() == id) {
                return actual.getSucursal();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }
    
    // Mostrar todos
    public void mostrar() {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }
        
        NodoSimpleSucursal actual = cabeza;
        while (actual != null) {
            System.out.println(actual.getSucursal());
            actual = actual.getSiguiente();
        }
    }
    
    public boolean estaVacia() {
        return cabeza == null;
    }
}
