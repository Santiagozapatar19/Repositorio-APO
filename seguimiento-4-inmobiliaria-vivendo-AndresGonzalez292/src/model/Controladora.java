package model;
import model.*;


public class Controladora {
    private Edificio[] edificios;

    public Controladora() {
        this.edificios = new Edificio[50];
    }

    public Edificio crearEdificio(String nombre, int numApartamentos, String direccion) {
        Edificio edificio = new Edificio(nombre, numApartamentos, direccion);
        return edificio;
    }

    public void agregarEdificio(Edificio edificio) {
        for (int i = 0; i < edificios.length; i++) {
            if (edificios[i] == null) {
                edificios[i] = edificio;
                break;
            }
        }
    }

    public Edificio getEdificio(int indice) {
        if (indice >= 0 && indice < edificios.length) {
            return edificios[indice];
        } else {
            return null;
        }
    }

    public int contarEdificios() {
        int contador = 0;
        for (Edificio edif : edificios) {
            if (edif != null) {
                contador++;
            }
        }
        return contador;
    }

    public double consultarValorTotalArrendamiento(double valorArrendamiento) {
    double valorTotal = 0;

    for (Edificio edificio : edificios) {
        if (edificio != null) {
            for (Apartamento apto : edificio.getApartamentos()) {
                if (apto != null) {
                    apto.setValorMensual(valorArrendamiento);
                    valorTotal += apto.getValorMensual();
                }
            }
        }
    }

    double valorInmobiliaria = valorTotal * 0.10;
    double valorPropietarios = valorTotal * 0.90;

    System.out.println("Valor mensual total de arrendamiento: " + valorTotal);
    System.out.println("La inmobiliaria retiene: " + valorInmobiliaria);
    System.out.println("Valor total para propietarios: " + valorPropietarios);

    return valorTotal;
}


}
