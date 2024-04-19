package model;
import model.Apartamento;



public class Edificio {
    private String nombre;
    private int numApartamentos;
    private String direccion;
    private Apartamento[] apartamentos;

    public Edificio(String nombre, int numApartamentos, String direccion) {
        this.nombre = nombre;
        this.numApartamentos = numApartamentos;
        this.direccion = direccion;
        this.apartamentos = new Apartamento[numApartamentos];
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumApartamentos() {
        return numApartamentos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void agregarApartamento(Apartamento apartamento, int indice) {
        if (indice >= 0 && indice < numApartamentos) {
            apartamentos[indice] = apartamento;
        } else {
            System.out.println("El índice está fuera de rango.");
        }
    }

    public int contarApartamentosDisponibles() {
        int contador = 0;
        for (Apartamento apto : apartamentos) {
            if (apto == null) {
                contador++;
            }
        }
        return contador;
    }

    public Apartamento[] getApartamentos() {
        return apartamentos;
    }
}
