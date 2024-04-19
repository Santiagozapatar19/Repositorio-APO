package model;
import model.*;

public class Controladora {
    private Estudiante[] estudiantes;
	private Profesor[] profesores;
	private Curso[] cursos;
	
	
    public Controladora() {
        this.estudiantes = new Estudiante[29];
		this.profesores = new Profesor[29];
		this.curso = new Curso[8];
    }

    public Profesor crearProfesor(String nombre, int edad, String cedula) {
    	Profesor profesor = new Profesor(nombre, edad, cedula);
    	return profesor;
    }
	
	public void agregarProfesor(Profesor profesor){
		for (int i = 0; i < profesores.lenght; i++){
			if (profesores[i] == null){
				profesores[i] = profesor;
				break;
			}	
		}	
	}	

    public Curso crearCurso(String nombreCurso, int creditos, String facultad) {
    	Curso curso = new Curso(nombreCurso, creditos, facultad);
    	return curso;
    }
	
	public void agregarCurso(Curso curso) {
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] == null) {
                cursos[i] = curso;
                break;
            }
        }
    }

    public Semestre crearSemestre(String nombrePeriodo) {
    	Semestre semestre = new Semestre(nombrePeriodo);
    	return semestre;
    }

    public void asociarCursoConSemestre(Curso curso, Semestre semestre) {
    	semestre.agregarCurso(curso);
    }

    public Estudiante crearEstudiante(String nombre, int edad, String codigoEstudiante, Barrio barrioEstudiante) {
    	Estudiante estudiante = new Estudiante(nombre, edad, codigoEstudiante, barrioEstudiante);
    	return estudiante;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] == null) {
                estudiantes[i] = estudiante;
                break;
            }
        }
    }

    public void asociarSemestreConEstudiante(Estudiante estudiante, Semestre semestre) {
    	estudiante.agregarSemestre(semestre);
    }

    public void asociarCursoConProfesor(Curso curso, Profesor profesor) {
        curso.setProfesor(profesor);
    }

    public String listarEstudiante(int indice) {
        if (indice >= 0 && indice < estudiantes.length && estudiantes[indice] != null) {
            Estudiante estudiante = estudiantes[indice];
            return "Nombre: " + estudiante.getNombre() + "\n" +
                   "Edad: " + estudiante.getEdad() + "\n" +
                   "Código de Estudiante: " + estudiante.getCodigoEstudiante() + "\n" +
				   "Zona: " + estudiante.getBarrio().toString();
        } else {
            return "";
        }
    }

    public int obtenerCantidadEstudiantes() {
        return estudiantes.length;
    }

    public Estudiante buscarEstudiantePorCodigo(String codigo) {
        for (Estudiante estudiante : estudiantes) { // Recorrido de objetos, "objeto por objeto"
            if (estudiante != null && estudiante.getCodigoEstudiante().equals(codigo)) {
                return estudiante;
            }
        }
        return null;
    }

    public String listarSemestre(int indice, Estudiante estudiante) {
        Semestre[] semestresEstudiante = estudiante.getSemestres();
        if (indice >= 0 && indice < estudiante.getSemestres().length && semestresEstudiante[indice] != null) {
            Semestre semestre = semestresEstudiante[indice];
            return "Nombre del periodo: " + semestre.getNombrePeriodo();
        } else {
            return "";
        }
    }
	
	public Barrio retornaTipoDeBarrio(int decision) {
		Barrio barrioEnum = Barrio.NORTE;
		switch (decision) {
					case 1:
						barrioEnum = Barrio.NORTE;
						break;
					case 2:
						barrioEnum = Barrio.SUR;
						break;
					case 3:
						barrioEnum = Barrio.ORIENTE;
						break;
					case 4:
						barrioEnum = Barrio.OCCIDENTE;
						break;
					case 5:
						barrioEnum = Barrio.FUERA_DE_CALI;
						break;
					default:
						System.out.print("Por favor ingrese una opcion valida");
			}
		return barrioEnum;
	}
	
	
}