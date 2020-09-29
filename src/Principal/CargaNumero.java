package Principal;

public class CargaNumero {

    CargaString cd = new CargaString();

    public int CambioInt(String datoString) {
        int aux = 0;
        try {
            aux = Integer.parseInt(datoString);
        } catch (Exception e) {
            System.err.println("error al Numero");
            System.out.println("Cargue de nuevo el valor: ");
            aux = CambioInt(cd.IngresoString());
        }
        return aux;
    }

    public long CambioLong(String datoString) {
        long aux = 0;
        try {
            aux = Long.parseLong(datoString);
        } catch (Exception e) {
            System.err.println("error al Numero");
            System.out.println("Cargue de nuevo el valor: ");
            aux = CambioLong(cd.IngresoString());
        }
        return aux;
    }

    public float CambioFloat(String datoString) {
        float aux = 0;
        try {
            aux = Float.parseFloat(datoString);
        } catch (Exception e) {
            System.err.println("error al cargar Numero");
            System.err.println("Cargue de nuevo el valor");
            aux = CambioFloat(cd.IngresoString());
        }
        return aux;
    }

    public double CambioDouble(String datoString) {
        double aux = 0.0;
        try {
            aux = Double.parseDouble(datoString);
        } catch (Exception e) {
            System.err.println("error al Numero");
            System.err.println("Cargue de nuevo el valor");
            aux = CambioDouble(cd.IngresoString());
        }
        return aux;
    }
}