package Principal;

import java.util.Scanner;

public class CargaString {

    Scanner en = new Scanner(System.in);

    public String IngresoString() {
        String Auxstring;
        Auxstring = en.nextLine();
        return Auxstring;
    }
    
    public char IngresoChar() {
        String Auxstring = en.nextLine();
        if (Auxstring.length()!=1){
			System.out.println ("Ingreso Mas de un caracter, reingrese: ");
			Auxstring = ""+IngresoChar();
		}
        return Auxstring.charAt(0);
    }

}