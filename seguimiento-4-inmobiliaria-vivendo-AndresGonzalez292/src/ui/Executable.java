package ui;

import java.util.Scanner;
import model.Controladora;
import model.Edificio;
import model.Apartamento;

public class Executable {
    private Scanner reader;
    private Controladora controladora;

    public Executable() {
        reader = new Scanner(System.in);
        controladora = new Controladora();
    }

    public void run() {
        boolean flag = false;

        while (!flag) {
            System.out.println("\n \n Bienvenido al menú:\n");
            System.out.println("Opciones:\n" + "1. Registrar edificio \n"
                    + "2. Registrar apartamentos de un edificio\n"
                    + "3. Consultar cuántos apartamentos hay disponibles en un edificio \n"
                    + "4. Consultar el valor mensual total de arrendamiento \n" + "5. Salir del programa \n");

            int option = reader.nextInt();
            reader.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    registrarEdificio();
                    break;
                case 2:
                    registrarApartamentos();
                    break;
                case 3:
                    consultarApartamentosDisponibles();
                    break;
                case 4:
                    consultarValorTotalArrendamiento();
                    break;
                case 5:
                    flag = true;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Por favor ingrese una opción válida");
                    break;
            }
        }
    }

    private void registrarEdificio() {
        System.out.println("Ingrese nombre del edificio:");
        String nombreEdificio = reader.nextLine();

        System.out.println("Ingrese el número de apartamentos que tiene el edificio:");
        int numApartamentos = reader.nextInt();
        reader.nextLine(); // Limpiar el buffer

        System.out.println("Ingrese la dirección del edificio:");
        String direccionEdificio = reader.nextLine();

        controladora.agregarEdificio(controladora.crearEdificio(nombreEdificio, numApartamentos, direccionEdificio));
        System.out.println("Edificio registrado exitosamente.");
    }

    private void registrarApartamentos() {
        System.out.println("Ingrese el índice contando desde la posicion 0 del edificio donde desea registrar apartamentos:");
        int indiceEdificio = reader.nextInt();
        reader.nextLine(); // Limpiar el buffer

        Edificio edificio = controladora.getEdificio(indiceEdificio);

        if (edificio != null) {
            System.out.println("Registrando apartamentos para el edificio " + edificio.getNombre() + ":");

            for (int i = 0; i < edificio.getNumApartamentos(); i++) {
                System.out.println("Ingrese el identificador del apartamento " + (i + 1) + ":");
                String aptoIdent = reader.nextLine();

                Apartamento apartamento = new Apartamento(aptoIdent);
                edificio.agregarApartamento(apartamento, i);
            }

            System.out.println("Apartamentos registrados exitosamente.");
        } else {
            System.out.println("El índice del edificio es inválido.");
        }
    }

    private void consultarApartamentosDisponibles() {
        System.out.println("Ingrese el índice contando desde la posicion 0 del edificio para consultar los apartamentos disponibles:");
        int indiceEdificio = reader.nextInt();
        reader.nextLine(); // Limpiar el buffer

        Edificio edificio = controladora.getEdificio(indiceEdificio);

        if (edificio != null) {
            int disponibles = edificio.contarApartamentosDisponibles();
            System.out.println("En el edificio " + edificio.getNombre() + " hay " + disponibles + " apartamentos disponibles.");
        } else {
            System.out.println("El índice del edificio es inválido.");
        }
    }

   private void consultarValorTotalArrendamiento() {
    System.out.println("Ingrese el valor del arrendamiento para un apartamento:");
    double valorArrendamiento = reader.nextDouble();

    double valorTotalArrendamiento = controladora.consultarValorTotalArrendamiento(valorArrendamiento);
}




    public static void main(String[] args) {
        Executable mainApp = new Executable();
        mainApp.run();
    }
}
