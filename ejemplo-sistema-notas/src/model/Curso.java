package model;
import model.Profesor;

public class Curso {
    private String nombreCurso;
    private int creditos;
    private String facultad;
    private Profesor profesor;

    public Curso(String nombreCurso, int creditos, String facultad) {
        this.nombreCurso = nombreCurso;
        this.creditos = creditos;
        this.facultad = facultad;
    }


    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }


    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }


    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }


    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}