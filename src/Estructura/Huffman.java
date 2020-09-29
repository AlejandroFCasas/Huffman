package Estructura;

import java.util.Enumeration;
import java.util.Hashtable;
import modelo.Caracter;

public class Huffman {

    private static Hashtable<String, Caracter> tabla;
    private static Arbol bosque;
    private static int longMax = 0;
    private static int longMin = 2147483647;
    private String palabraHuff = "";
    private String palabraOrig = "";

    public String getPalabraHuff() {
        return palabraHuff;
    }

    public String getPalabraOrig() {
        return palabraOrig;
    }

    public void setPalabraOrig(String palabraOrig) {
        this.palabraOrig = palabraOrig;
    }

    public void setPalabraHuff(String palabraHuff) {
        this.palabraHuff = palabraHuff;
    }

//////////////////////////////PUNTO UNO/////////////////////////////////////////
    public void cargaSimbolCalculaFrec(String msj) {
        tabla = new java.util.Hashtable<String, Caracter>();
       

       setPalabraOrig(msj);
        for (int i = 0; i < msj.length(); i++) {
            char c = ' ';
            c = msj.charAt(i);
            Caracter s = tabla.get("" + c);
            if (s != null) {
                s.setFrecuencia(s.getFrecuencia() + 1);
                } else { 
                s = new Caracter("" + c, 1);
                tabla.put("" + c, s); 
                }
        }
        
    }
//////////////////////////////////PUNTO DOS/////////////////////////////////////

    public void crearArbolCodif() {
        String aux = "";
        String s = "";
        bosque = new Arbol();
        Enumeration<Caracter> e = tabla.elements();
        while (e.hasMoreElements()) {
            NodoL b = new NodoL(e.nextElement());
            bosque.agregar(b);
        }

        while (bosque.cantidad() > 1) {
            bosque.agregar(reforesta());
        }
        cargarCodificacion((NodoL) bosque.quitarPrimero(), s);
        aux = getPalabraOrig();
        MensajeHuff(aux);
    }

    public NodoL reforesta() {
        NodoL nb1 = (NodoL) bosque.quitarPrimero();
        NodoL nb2 = (NodoL) bosque.quitarPrimero();
        Caracter s = new Caracter("NODO INTERNO", ((Caracter) nb1.getDato()).getFrecuencia() + ((Caracter) nb2.getDato()).getFrecuencia());
        return new NodoL(s, nb1, nb2);
    }

    public void cargarCodificacion(NodoL nodo, String s) {
        if (nodo == null) {
            return;
        }
        if (nodo.getAnterior() == null && nodo.getSiguiente() == null) {
            if (s.isEmpty()) {
                s = "1";
            }

            ((Caracter) nodo.getDato()).setBit(s);
            longMax = Math.max(s.length(), longMax);
            longMin = Math.min(s.length(), longMin);
        } else {
            if (nodo.getDato() != null) {
                cargarCodificacion(nodo.getSiguiente(), s + "0");
                cargarCodificacion(nodo.getAnterior(), s + "1");
            }
        }
    }
//////////////////////////////////PUNTO TRES/////////////////////////////////////

    public void mostrarHuff() {
        Enumeration<Caracter> e = tabla.elements();
        while (e.hasMoreElements()) {
            Caracter s = e.nextElement();
            System.out.println("Caracter: " + s.getCaracter() + " Codificacion Huffman: " + s.getBit() + " frec: " + s.getFrecuencia() + " Costo: " + s.getCosto() + "\n");
        }
        System.out.println(""); // calcular costo en simbolo agruegar variable costo y metodo calcular
    }
//////////////////////////////////PUNTO CUATRO//////////////////////////////////

    public void MensajeHuff(String msj) {

        String aux2 = "";
        for (int i = 0; i < msj.length(); i++) {
            Enumeration<Caracter> e = tabla.elements();
            char c = ' ';
            String aux = "";

            c = msj.charAt(i);
            aux = aux + c;
            while (e.hasMoreElements()) {
                Caracter s = e.nextElement();
                if (aux.equals(s.getCaracter())) {
                    aux2 = aux2 + s.getBit();
                }
            }
        }
        System.out.print("aux2:" + aux2);
        this.setPalabraHuff(aux2);
    }

    public void BuscarPalabraHuff(String msj) {
        if (getPalabraHuff().equals(msj)) {
            System.out.println("el mensaje corresponde a: " + getPalabraOrig());
        } else {
            System.out.println("no se encontro ningun msj con ese codigo");
        }
    }
//////////////////////////////////PUNTO CINCO//////////////////////////////////

    public void mostrarMayorHuff() {
        System.out.println("Codigos mas largos de Huffman para este archivo\n");
        Enumeration<Caracter> e = tabla.elements();
        while (e.hasMoreElements()) {
            Caracter s = e.nextElement();
            if (s.getBit().length() == longMax) {
                System.out.println("  Caracter: " + s.getCaracter() + " Codigo: " + s.getBit());
            }
        }
        System.out.println("");
    }
//////////////////////////////////PUNTO SEIS//////////////////////////////////

    public void mostrarMenorHuff() {
        System.out.println("Codigos mas cortos de Huffman para este archivo\n");
        Enumeration<Caracter> e = tabla.elements();
        while (e.hasMoreElements()) {
            Caracter s = e.nextElement();
            if (s.getBit().length() == longMin) {
                System.out.println("  Caracter: " + s.getCaracter() + " Codigo: " + s.getBit());
            }
        }
        System.out.println("");
    }
//////////////////////////////////PUNTO SIETE//////////////////////////////////

    public void mostrarCostos() {
        double msjHuff = 0, msjOrig = 0;
        double diaHuff = 0, diaOrig = 0;
        double mesHuff = 0, mesOrig = 0;
        int cantCar = 0;
        Enumeration<Caracter> e = tabla.elements();
        while (e.hasMoreElements()) {
            Caracter s = e.nextElement();
            msjHuff = msjHuff + s.getCosto();
            cantCar = cantCar + s.getFrecuencia();
        }
        msjOrig = cantCar * 0.0015625;
        System.out.println("El costo del mjs codificado es:" + msjHuff);
        System.out.println("              no codificado es:" + msjOrig);
        diaHuff = 500 * 3.692307 * 0.0001953125;
        diaOrig = 500 * 8 * 0.0001953125;
        System.out.println("El costo por Dia(500 caracteres) codificado es:" + diaHuff);
        System.out.println("                              no codificado es:" + diaOrig);
        mesHuff = 30 * 500 * 3.692307 * 0.0001953125;
        mesOrig = 30 * 500 * 8 * 0.0001953125;
        System.out.println("El costo mensual (500 caracteres X dia) codificado es:" + mesHuff);
        System.out.println("                                     no codificado es:" + mesOrig);
    }
}
