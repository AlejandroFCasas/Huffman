package Estructura;

public class Arbol {

	NodoL ini = new NodoL();
	NodoL fin = new NodoL();
	int cantE= 0;
	//
	public void agregar(Comparable x) {

		NodoL inserta;
		inserta =  new NodoL(x);
		cantE++;
		if (this.esVacia()){
			ini.setSiguiente(inserta);
			fin.setSiguiente(inserta);
		}else{
			NodoL actual = ini.getSiguiente();
			while (actual != null){
				if (inserta.getDato().compareTo(actual.getDato())<=0){
					if (actual.getAnterior()==null){		
						ini.setSiguiente(inserta);
						inserta.setSiguiente(actual);
						actual.setAnterior(inserta);
						return;
					}
					actual.getAnterior().setSiguiente(inserta);
					inserta.setSiguiente(actual);
					inserta.setAnterior(actual.getAnterior());
					actual.setAnterior(inserta);
					return;
				}else if (actual.getSiguiente()==null){
					actual.setSiguiente(inserta);
					inserta.setAnterior(actual);
					fin.setSiguiente(inserta);
					return;
				}else{
					actual=actual.getSiguiente();
				}
			}
		}
	}

	public Comparable buscar(Comparable x) {
		NodoL tmp;
		if (esVacia()){
			System.out.println ("No se pueden buscar elementos, la Lista esta vacia");
		}else{
			tmp = buscarNodo(x);
			if (tmp != null)
				return tmp.getDato();
		}return null;
	}
	
	public NodoL buscarNodo (Comparable x){
		NodoL actual = ini.getSiguiente();
		while (actual != null && actual.getDato().compareTo(x)<=0){
			if (actual.getDato().compareTo(x)==0){
				return actual;
			}else{
				actual = actual.getSiguiente(); 
			}
		}return null;
	}
	
	public void eliminar(Comparable x) {
		NodoL tmp = buscarNodo(x);
		if (tmp!=null){
			cantE--;
			if (tmp.getAnterior()==null){
				ini.setSiguiente(tmp.getSiguiente());
				tmp.getSiguiente().setAnterior(null);
			}else if (tmp.getSiguiente()==null){
				tmp.getAnterior().setSiguiente(null);
				fin.setSiguiente(tmp.getAnterior());
			}else{
				tmp.getAnterior().setSiguiente(tmp.getSiguiente());
				tmp.getSiguiente().setAnterior(tmp.getAnterior());
			}
		}else{
			System.out.println("No se encuentra el valor que se desea eliminar");
		}		
	}

	public Comparable quitarPrimero(){
		if (esVacia()) return null;
		cantE--;	
		NodoL tmp = ini.getSiguiente();
		ini.setSiguiente(tmp.getSiguiente());
		if (tmp.getSiguiente()!=null)
			tmp.getSiguiente().setAnterior(null);
		return tmp.getDato();
	}
	public boolean esVacia() {
		return ini.getSiguiente()==null;
	}

	public void mostrar() {
		NodoL actual = ini.getSiguiente();
		if (esVacia()){
			System.out.println ("La lista esta vacia...");
			return;
		}else{
			
			while (actual != null){
				System.out.println (actual.getDato());
				actual = actual.getSiguiente();
			}return;
		}
	}

	public void mostrarDes() {
		NodoL actual = fin.getSiguiente();
		if (esVacia()){
			System.out.println ("La lista esta vacia...");
			return;
		}else{
			while (actual != null){
				System.out.println (actual.getDato());
				actual = actual.getAnterior();
			}return;
		}
	}

	public int cantidad() {
		return this.cantE;
	}

}
