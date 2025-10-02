package insteducativa;

public abstract class Empleado extends Persona{
    private int añoIncorporacion;

    public Empleado(int añoIncorporacion, String nombre, String apellidos, long numeroIdentificacion, String estadoCivil) {
        super(nombre, apellidos, numeroIdentificacion, estadoCivil); // Llama al constructor de Persona
        setAñoIncorporacion(añoIncorporacion);  // Ahora inicializa lo propio de Empleado
    }

    public int getAñoIncorporacion() {
        return añoIncorporacion;
    }

    // Setter con validación
    public void setAñoIncorporacion(int añoIncorporacion) {
        if (añoIncorporacion > 1900 && añoIncorporacion <= 2025) {  // se pone un rango 
            this.añoIncorporacion = añoIncorporacion;
        } else {
            throw new IllegalArgumentException("El año de incorporación debe estar entre 1900 y 2025.");
        }
    }
    
     @Override
    public String toString() {
        return super.toString() + ", añoIncorporacion=" + añoIncorporacion;
    }
    
}
