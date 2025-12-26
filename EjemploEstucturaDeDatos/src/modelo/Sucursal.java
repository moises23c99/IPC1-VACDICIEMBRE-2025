package modelo;

public class Sucursal {
    private static int contadorID = 1;
    
    private int idSucursal;
    private String nombreSucursal;
    private String direccion;
    private String telefono;
    private String gerenteAsignado;
    private int capacidadMesas;
    private String horarioApertura;
    private String horarioCierre;
    private String estado; // "Activa" o "Inactiva"
    
    // Constructor
    public Sucursal(String nombreSucursal, String direccion, String telefono, 
                   String gerenteAsignado, int capacidadMesas, 
                   String horarioApertura, String horarioCierre, String estado) {
        this.idSucursal = contadorID++;
        this.nombreSucursal = nombreSucursal;
        this.direccion = direccion;
        this.telefono = telefono;
        this.gerenteAsignado = gerenteAsignado;
        this.capacidadMesas = capacidadMesas;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.estado = estado;
    }
    
    // Getters y Setters
    public int getIdSucursal() {
        return idSucursal;
    }
    
    public String getNombreSucursal() {
        return nombreSucursal;
    }
    
    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getGerenteAsignado() {
        return gerenteAsignado;
    }
    
    public void setGerenteAsignado(String gerenteAsignado) {
        this.gerenteAsignado = gerenteAsignado;
    }
    
    public int getCapacidadMesas() {
        return capacidadMesas;
    }
    
    public void setCapacidadMesas(int capacidadMesas) {
        this.capacidadMesas = capacidadMesas;
    }
    
    public String getHorarioApertura() {
        return horarioApertura;
    }
    
    public void setHorarioApertura(String horarioApertura) {
        this.horarioApertura = horarioApertura;
    }
    
    public String getHorarioCierre() {
        return horarioCierre;
    }
    
    public void setHorarioCierre(String horarioCierre) {
        this.horarioCierre = horarioCierre;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Sucursal{" +
                "ID=" + idSucursal +
                ", Nombre='" + nombreSucursal + '\'' +
                ", Dirección='" + direccion + '\'' +
                ", Teléfono='" + telefono + '\'' +
                ", Gerente='" + gerenteAsignado + '\'' +
                ", Capacidad Mesas=" + capacidadMesas +
                ", Horario=" + horarioApertura + " - " + horarioCierre +
                ", Estado='" + estado + '\'' +
                '}';
    }
}
