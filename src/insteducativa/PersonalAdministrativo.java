package insteducativa;

public class PersonalAdministrativo extends Empleado {
    
    private String dependencia;

    // Constructor: Llama al de Empleado (que a su vez llama a Persona)
    public PersonalAdministrativo(String dependencia, int añoIncorporacion, String nombre, String apellidos, long numeroIdentificacion, String estadoCivil) {
        super(añoIncorporacion, nombre, apellidos, numeroIdentificacion, estadoCivil);
        this.dependencia = dependencia;
    }
    
    // Getter para dependencia
    public String getDependencia() {
        return dependencia;
    }

    //Setter para dependencia     
    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }
    
    //Metodo para modificar dependencia
    public void modificarDependencia(String nuevaDependencia) {
        setDependencia(nuevaDependencia);
        System.out.println("Dependencia de " + getNombre() + " modificada a: " + nuevaDependencia);
    }
    
    // toString sobrescrito para incluir la dependencia (polimorfismo)
    @Override
    public String toString() {
        return super.toString() + ", dependencia='" + dependencia + '\'';
    }        
}
