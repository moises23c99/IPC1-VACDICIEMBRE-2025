package modelo.estructuras;

import modelo.Sucursal;

public class ListaDoble {
    private NodoDoble cabeza;
    private NodoDoble cola;
    
    public ListaDoble() {
        this.cabeza = null;
        this.cola = null;
    }
    
    // Agregar al final
    public void agregar(Sucursal sucursal) {
        NodoDoble nuevoNodo = new NodoDoble(sucursal);
        
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(cola);
            cola = nuevoNodo;
        }
    }
    
    // Eliminar por ID
    public boolean eliminar(int id) {
        if (cabeza == null) {
            return false;
        }
        
        NodoDoble actual = cabeza;
        while (actual != null) {
            if (actual.getSucursal().getIdSucursal() == id) {
                if (actual.getAnterior() != null) {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                } else {
                    cabeza = actual.getSiguiente();
                }
                
                if (actual.getSiguiente() != null) {
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                } else {
                    cola = actual.getAnterior();
                }
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }
    
    // Buscar por ID
    public Sucursal buscar(int id) {
        NodoDoble actual = cabeza;
        while (actual != null) {
            if (actual.getSucursal().getIdSucursal() == id) {
                return actual.getSucursal();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }
    
    // Mostrar de adelante hacia atrás
    public void mostrar() {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }
        
        NodoDoble actual = cabeza;
        while (actual != null) {
            System.out.println(actual.getSucursal());
            actual = actual.getSiguiente();
        }
    }
    
    // Mostrar de atrás hacia adelante
    public void mostrarReversa() {
        if (cola == null) {
            System.out.println("La lista está vacía");
            return;
        }
        
        NodoDoble actual = cola;
        while (actual != null) {
            System.out.println(actual.getSucursal());
            actual = actual.getAnterior();
        }
    }
    
    public boolean estaVacia() {
        return cabeza == null;
    }
}
