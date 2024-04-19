package model;
import model.Curso;

public class Semestre {
    private String nombrePeriodo;
    private Curso[] cursos;

    public Semestre(String nombrePeriodo) {
        this.nombrePeriodo = nombrePeriodo;
        this.cursos = new Curso[8]; 
    }

    public String getNombrePeriodo() {
        return nombrePeriodo;
    }

    public void setNombrePeriodo(String nombrePeriodo) {
        this.nombrePeriodo = nombrePeriodo;
    }

    // Getter y setter para cursos
    public Curso[] getCursos() {
        return cursos;
    }

    public void setCursos(Curso[] cursos) {
        this.cursos = cursos;
    }

    public void agregarCurso(Curso curso) {
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] == null) {
                cursos[i] = curso;
                break;
            }
        }
    }
	
}