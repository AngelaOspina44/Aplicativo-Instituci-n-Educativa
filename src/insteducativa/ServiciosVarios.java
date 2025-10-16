package insteducativa;

public class ServiciosVarios extends Empleado{
    
    private String labor;

    // Constructor: Llama al de Empleado (que inicializa Persona + añoIncorporacion)
    public ServiciosVarios(String labor, int añoIncorporacion, String nombre, String apellidos, long numeroIdentificacion, String estadoCivil) {
        super(añoIncorporacion, nombre, apellidos, numeroIdentificacion, estadoCivil);
        this.labor = labor;
    }

    //Getter para labor 
    public String getLabor() {
        return labor;
    }

    //Setter para labor 
    public void setLabor(String labor) {
        this.labor = labor;
    }
    
    //Metodo requerido: Regitrar labor especifica 
    public void modificarLabor(String nuevaLabor) {
        setLabor(nuevaLabor);
        System.out.println("Labor de " + getNombre() + " modificada a: " + nuevaLabor);
    }
    
    @Override
    public String toCSV() {
        // SERVICIOS;labor;añoIncorporacion;nombre;apellidos;numeroId;estadoCivil
        return "SERVICIOS;" + esc(getLabor()) + ";" + getAñoIncorporacion() + ";" +
               esc(getNombre()) + ";" + esc(getApellidos()) + ";" + getNumeroIdentificacion() + ";" + esc(getEstadoCivil());
    }

}
