package sc.ejemploestudiante.modelos;

public class Estudiante extends Usuario{
    private String carrera;
    private int semestre;
    private String facultad;
    private String carne;
    private boolean activo;
    
    public Estudiante(String carrera, int semestre, String facultad, String carne,String nombre, String CUI, String correo, String contrasena, String usuario,
            char genero, int telefono, int edad, char estadoCivil){
        super(nombre, CUI, correo, contrasena, usuario, genero, telefono, edad, estadoCivil);
        this.carrera = carrera;
        this.semestre = semestre;
        this.facultad = facultad;
        this.carne = carne;
        this.activo=true;
    }
    
    public Estudiante(){
        super();
    }
    
    public String getCarrera(){
        return carrera;
    }
    
    public void setCarrera(String carrera){
        this.carrera= carrera;
    }
    
    public int getSemestre(){
        return semestre;
    }
    
    public void setSemestr(int semestre){
        this.semestre = semestre;
    }
    
    public String getFacultad(){
        return facultad;
    }
    
    public void setFacultad(String facultad){
        this.facultad=facultad;
    }
    
    public String getCarne(){
        return carne;
    }
    
    public void setCarne(String carne){
        this.carne = carne;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "carrera=" + carrera + ", semestre=" + semestre + ", facultad=" + facultad + ", carne=" + carne + ", activo=" + activo + super.toString()+'}';
    }
       
}
