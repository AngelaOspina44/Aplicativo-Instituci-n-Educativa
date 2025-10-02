package insteducativa;

public class Estudiante extends Persona {

    private String curso;

    // Constructor: Llama al de Persona directamente
    public Estudiante(String curso, String nombre, String apellidos, long numeroIdentificacion, String estadoCivil) {
        super(nombre, apellidos, numeroIdentificacion, estadoCivil); // Inicializa lo heredado de Persona
        this.curso = curso; // Asigna lo específico de Estudiante
    }

    //Getter para curso
    public String getCurso() {
        return curso;
    }
    
    //Setter para curso
    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    //Metodo para matricular o cambiar curso
    public void matricularEnCurso(String nuevoCurso) {
        setCurso(nuevoCurso);
        System.out.println(getNombre() + " matriculado en: " + nuevoCurso);
    }
    
    // toString sobrescrito para incluir el curso (polimorfismo)
    @Override
    public String toString() {
        return super.toString() + ", curso='" + curso + '\'';
    }
}
