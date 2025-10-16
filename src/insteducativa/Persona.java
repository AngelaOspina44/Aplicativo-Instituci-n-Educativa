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

    // MÉTODO AUXILIAR: evita errores con ; en textos
    protected String esc(String s) {
        return (s == null) ? "" : s.replace(";", ",");
    }

    // NUEVO: Método base toCSV() que todas las subclases pueden sobrescribir
    public String toCSV() {
        // PERSONA;nombre;apellidos;numeroId;estadoCivil
        return "PERSONA;" + esc(nombre) + ";" + esc(apellidos) + ";" + numeroIdentificacion + ";" + esc(estadoCivil);
    }

    // toString para imprimir fácilmente 
    @Override
    public String toString() {
        return "Persona " +
                "nombre = '" + nombre + '\'' +
                ", apellidos = '" + apellidos + '\'' +
                ", numeroIdentificacion = " + numeroIdentificacion +
                ", estadoCivil = '" + estadoCivil + '\'' +
                '}';
    }
}
