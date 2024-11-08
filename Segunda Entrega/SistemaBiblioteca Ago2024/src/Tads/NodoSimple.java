package Tads;

public class NodoSimple<T extends Comparable<T>> {

    private T valor;
    private NodoSimple<T> siguiente;

    public NodoSimple(T valor) {
        this.valor = valor;
        this.siguiente = null;
    }
    
    public NodoSimple(T valor, NodoSimple siguiente) {
        this.valor = valor;
        this.siguiente = siguiente;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NodoSimple<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSimple<T> siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getValor().getClass()) {
            return false;
        }
        return this.valor.equals(o);
    }
}
