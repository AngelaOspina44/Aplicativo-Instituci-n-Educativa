package insteducativa;

public class Persona {

    private String nombre;
    private String apellidos;
    private long numeroIdentificacion;
    private String estadoCivil;

    //constructor
    public Persona(String nombre, String apellidos, long numeroIdentificacion, String estadoCivil) {
        // Validar y asignar nombre
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numeroIdentificacion = numeroIdentificacion;
        this.estadoCivil = estadoCivil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public long getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(long numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    // Método requerido: Cambio del estado civil
    public void cambiarEstadoCivil(String nuevoEstadoCivil) {
        setEstadoCivil(nuevoEstadoCivil);
        System.out.println("Estado civil de " + nombre + " cambiado a: " + nuevoEstadoCivil);
    }
    // toString para imprimir fácilmente 
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", numeroIdentificacion=" + numeroIdentificacion +
                ", estadoCivil='" + estadoCivil + '\'' +
                '}';
    }
    
}
