package insteducativa;

public class Profesor extends Empleado{

    private String facultad;

    // Constructor: Llama al de Empleado (que inicializa Persona + añoIncorporacion)    
    public Profesor(String facultad, int añoIncorporacion, String nombre, String apellidos, long numeroIdentificacion, String estadoCivil) {
        super(añoIncorporacion, nombre, apellidos, numeroIdentificacion, estadoCivil);
        this.facultad = facultad;
    }

    // Getter para facultad
    public String getFacultad() {
        return facultad;
    }
    
    // Setter para facultad
    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
    
    //Metodo para cambiar la facultad
    public void cambiarFacultad(String nuevaFacultad) {
        setFacultad(nuevaFacultad);
        System.out.println("Facultad de " + getNombre() + "cambiada a: " + nuevaFacultad);
    }
    
    @Override
    public String toCSV() {
        // PROFESOR;facultad;añoIncorporacion;nombre;apellidos;numeroId;estadoCivil
        return "PROFESOR;" + esc(getFacultad()) + ";" + getAñoIncorporacion() + ";" +
               esc(getNombre()) + ";" + esc(getApellidos()) + ";" + getNumeroIdentificacion() + ";" + esc(getEstadoCivil());
}

}
