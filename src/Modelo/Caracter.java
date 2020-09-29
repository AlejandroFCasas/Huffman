package modelo;

public class Caracter implements Comparable {

    private String caracter;
    private int frecuencia;
    private String bit;
    private double costo;

    public double getCosto() {
        this.costo = this.setCosto();
        return costo;
    }

    public double setCosto() {
        this.costo = this.getBit().length() * (double) this.getFrecuencia() * 0.0001953125;
        return costo;
    }

    public Caracter() {
        super();
    }

    public Caracter(String caracter, int frecuencia) {
        super();
        this.caracter = caracter;
        this.frecuencia = frecuencia;
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getBit() {
        return bit;
    }

    public void setBit(String bit) {
        this.bit = bit;
    }

    public int compareTo(Object arg) {
        Caracter a = (Caracter) arg;
        if (this.getFrecuencia() < a.getFrecuencia()) {
            return -1;
        } else if (this.getFrecuencia() > a.getFrecuencia()) {
            return 1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return this.caracter;
    }
}
