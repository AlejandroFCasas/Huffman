package Estructura;



public class NodoL implements Comparable{
	
	private Comparable dato;
	private NodoL siguiente;
	private NodoL anterior;
	
	public NodoL() {
		super();
	}

	public NodoL(Comparable dato) {
		this.dato = dato;
	}

        public NodoL(Comparable Dato, NodoL rs, NodoL ra) {
        this.dato = Dato;
        this.siguiente = rs;
        this.anterior = ra;
        }

	public Comparable getDato() {
		return dato;
	}

	public void setDato(Comparable dato) {
		this.dato = dato;
	}

	public NodoL getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoL siguiente) {
		this.siguiente = siguiente;
	}

	public NodoL getAnterior() {
		return anterior;
	}

	public void setAnterior(NodoL anterior) {
		this.anterior = anterior;
	}

        public int compareTo(Object o) {
        return this.dato.compareTo(((NodoL) o).getDato());
    }
	
	
}
