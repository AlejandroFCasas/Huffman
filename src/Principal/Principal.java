package Principal;

import Estructura.Huffman;

public class Principal {

    public static void main(String[] args) {


        CargaNumero cn = new CargaNumero();
        CargaString cs = new CargaString();
        Huffman hu = new Huffman();
        do {
            System.out.println(" ");
            System.out.println(" Opciones...");
            System.out.println("1)Ingrese mensaje a codificar");
            System.out.println("2)Mostrar el Codigo de Huffman.");
            System.out.println("3)Mostrar mesnsaje para un codigo cargado.");
            System.out.println("4)Mostrar el mayor Codigo de Huffman.");
            System.out.println("5)Mostrar el menor Codigo de Huffman.");
            System.out.println("6)Mostrar Comparacion de Costos.");
            System.out.println("7)Salir");
            System.out.print("Opcion: ");
            int opcion = cn.CambioInt(cs.IngresoString());
            switch (opcion) {
                case 1: {
                    System.out.println("ingre msj ");
                    String aux = cs.IngresoString();
                    hu.cargaSimbolCalculaFrec(aux);
                    hu.crearArbolCodif();
                    break;
                }
                case 2: {
                    hu.mostrarHuff();
                    break;
                }
                case 3: {
                    System.out.print("Ingrese el Codigo del Mensaje: ");
                    String c = cs.IngresoString();
                    hu.BuscarPalabraHuff(c);
                    break;
                }
                case 4: {
                    hu.mostrarMayorHuff();
                    break;
                }
                case 5: {
                    hu.mostrarMenorHuff();
                    break;
                }
                case 6: {
                    hu.mostrarCostos();
                    break;
                }
                case 7: {
                    System.exit(0);
                    break;
                }
            }
        } while (true);
    }
}
