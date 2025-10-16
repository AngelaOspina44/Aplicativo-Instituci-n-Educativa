package insteducativa;

import java.io.*;
import java.util.ArrayList;

public class GestorDatos {

    private static final String ARCHIVO = "personas.csv";
    private static final ArrayList<Persona> listaPersonas = new ArrayList<>();

    // Obtener la lista actual
    public static ArrayList<Persona> getLista() {
        return listaPersonas;
    }

    // Cargar desde CSV (al iniciar)
    public static void cargar() {
        listaPersonas.clear();
        File f = new File(ARCHIVO);
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.isBlank()) continue;

                String[] datos = linea.split(";", -1);
                String tipo = datos[0].toUpperCase();

                switch (tipo) {
                    case "PROFESOR":
                        // PROFESOR;facultad;añoIncorporacion;nombre;apellidos;numeroId;estadoCivil
                        listaPersonas.add(new Profesor(
                            datos[1],
                            Integer.parseInt(datos[2]),
                            datos[3], datos[4],
                            Long.parseLong(datos[5]),
                            datos[6]
                        ));
                        break;

                    case "ESTUDIANTE":
                        // ESTUDIANTE;curso;nombre;apellidos;numeroId;estadoCivil
                        listaPersonas.add(new Estudiante(
                            datos[1],
                            datos[2], datos[3],
                            Long.parseLong(datos[4]),
                            datos[5]
                        ));
                        break;

                    case "SERVICIOS":
                        // SERVICIOS;labor;añoIncorporacion;nombre;apellidos;numeroId;estadoCivil
                        listaPersonas.add(new ServiciosVarios(
                            datos[1],
                            Integer.parseInt(datos[2]),
                            datos[3], datos[4],
                            Long.parseLong(datos[5]),
                            datos[6]
                        ));
                        break;

                    case "ADMINISTRATIVO":
                        // ADMINISTRATIVO;dependencia;añoIncorporacion;nombre;apellidos;numeroId;estadoCivil
                        listaPersonas.add(new PersonalAdministrativo(
                            datos[1],
                            Integer.parseInt(datos[2]),
                            datos[3], datos[4],
                            Long.parseLong(datos[5]),
                            datos[6]
                        ));
                        break;

                    case "EMPLEADO":
                        // Como Empleado es abstracto, no se puede instanciar directamente.
                        // Guardamos como Persona genérica (mantiene la info).
                        listaPersonas.add(new Persona(
                            datos[2], datos[3],
                            Long.parseLong(datos[4]),
                            datos[5]
                        ));
                        break;


                    case "PERSONA":
                        // PERSONA;nombre;apellidos;numeroId;estadoCivil
                        listaPersonas.add(new Persona(
                            datos[1], datos[2],
                            Long.parseLong(datos[3]),
                            datos[4]
                        ));
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println("⚠️ Error al cargar el CSV: " + e.getMessage());
        }
    }

    // Guardar en CSV
    public static void guardar() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO))) {
            for (Persona p : listaPersonas) {
                pw.println(p.toCSV());
            }
        } catch (IOException e) {
            System.err.println("⚠️ Error al guardar CSV: " + e.getMessage());
        }
    }

    // Buscar por identificación
    public static Persona buscarPorId(long id) {
        for (Persona p : listaPersonas) {
            if (p.getNumeroIdentificacion() == id) {
                return p;
            }
        }
        return null;
    }

    // Agg persona 
    public static void agregarPersona(Persona p) {
        listaPersonas.add(p);
        guardar();
    }

    // Cambiar estado civil
    public static boolean cambiarEstadoCivil(long id, String nuevoEstado) {
        Persona p = buscarPorId(id);
        if (p == null) return false;
        p.setEstadoCivil(nuevoEstado);
        guardar();
        return true;
    }

    // Cambiar curso estudiante
    public static boolean cambiarCursoEstudiante(long id, String nuevoCurso) {
        Persona p = buscarPorId(id);
        if (p instanceof Estudiante) {
            ((Estudiante) p).setCurso(nuevoCurso);
            guardar();
            return true;
        }
        return false;
    }

    // Cambiar facultad profesor 
    public static boolean cambiarFacultadProfesor(long id, String nuevaFacultad) {
        Persona p = buscarPorId(id);
        if (p instanceof Profesor) {
            ((Profesor) p).setFacultad(nuevaFacultad);
            guardar();
            return true;
        }
        return false;
    }

    // Cambiar labor oficios varios 
    public static boolean cambiarLaborServicios(long id, String nuevaLabor) {
        Persona p = buscarPorId(id);
        if (p instanceof ServiciosVarios) {
            ((ServiciosVarios) p).setLabor(nuevaLabor);
            guardar();
            return true;
        }
        return false;
    }

    // Cambiar dependencia administrativo 
    public static boolean cambiarDependenciaAdministrativo(long id, String nuevaDependencia) {
        Persona p = buscarPorId(id);
        if (p instanceof PersonalAdministrativo) {
            ((PersonalAdministrativo) p).setDependencia(nuevaDependencia);
            guardar();
            return true;
        }
        return false;
    }
}
