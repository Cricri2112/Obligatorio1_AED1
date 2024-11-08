package Tads;

public class Cola<T extends Comparable<T>> implements ICola<T> {

    private NodoSimple<T> inicio = null;
    private int cantNodos = 0;

    public Cola() {
    }

    public NodoSimple<T> getInicio() {
        return inicio;
    }

    public void setInicio(NodoSimple<T> inicio) {
        this.inicio = inicio;
    }


    @Override
    public String mostrar() {
        if(esVacia()) return "Cola vacía";
        else {
            NodoSimple aux = inicio;
            return mostrarRec(aux);
        }    
    }
    
     private String mostrarRec(NodoSimple actual) {
        return actual.getSiguiente() == null
                ? "" + actual.getValor()
                : actual.getValor() + " - " + mostrarRec(actual.getSiguiente());
    }

    @Override
    public boolean esVacia() {
        return cantNodos == 0;
    }

    @Override
    public void encolar(T obj) {
        NodoSimple<T> nuevo = new NodoSimple(obj);
                
        if(esVacia()) {
            inicio = nuevo;
        }
        else {
            NodoSimple aux = inicio;
            while(aux.getSiguiente() != null) aux = aux.getSiguiente();
            aux.setSiguiente(nuevo);
        }
        cantNodos++;
    }

    @Override
    public void desencolar() {
        if (!esVacia()) {
            inicio = inicio.getSiguiente();
            cantNodos--;
        }
    }

    @Override
    public int cantElementos() {
        return cantNodos;
    }

    @Override
    public void vaciar() {
        inicio = null;
        cantNodos=0;
    }
}
