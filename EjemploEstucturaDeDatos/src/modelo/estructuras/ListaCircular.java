package modelo.estructuras;

import modelo.Sucursal;

public class ListaCircular {
    private NodoSimple cabeza;
    private NodoSimple cola;
    
    public ListaCircular() {
        this.cabeza = null;
        this.cola = null;
    }
    
    // Agregar al final
    public void agregar(Sucursal sucursal) {
        NodoSimple nuevoNodo = new NodoSimple(sucursal);
        
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            nuevoNodo.setSiguiente(cabeza); // Circular
        } else {
            cola.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(cabeza); // Mantener circular
            cola = nuevoNodo;
        }
    }
    
    // Eliminar por ID
    public boolean eliminar(int id) {
        if (cabeza == null) {
            return false;
        }
        
        // Si solo hay un nodo
        if (cabeza == cola && cabeza.getSucursal().getIdSucursal() == id) {
            cabeza = null;
            cola = null;
            return true;
        }
        
        // Si es la cabeza
        if (cabeza.getSucursal().getIdSucursal() == id) {
            cabeza = cabeza.getSiguiente();
            cola.setSiguiente(cabeza);
            return true;
        }
        
        // Buscar en el resto
        NodoSimple actual = cabeza;
        do {
            if (actual.getSiguiente().getSucursal().getIdSucursal() == id) {
                if (actual.getSiguiente() == cola) {
                    cola = actual;
                }
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual = actual.getSiguiente();
        } while (actual != cola);
        
        return false;
    }
    
    // Buscar por ID
    public Sucursal buscar(int id) {
        if (cabeza == null) {
            return null;
        }
        
        NodoSimple actual = cabeza;
        do {
            if (actual.getSucursal().getIdSucursal() == id) {
                return actual.getSucursal();
            }
            actual = actual.getSiguiente();
        } while (actual != cabeza);
        
        return null;
    }
    
    // Mostrar todos
    public void mostrar() {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }
        
        NodoSimple actual = cabeza;
        do {
            System.out.println(actual.getSucursal());
            actual = actual.getSiguiente();
        } while (actual != cabeza);
    }
    
    public boolean estaVacia() {
        return cabeza == null;
    }
}
