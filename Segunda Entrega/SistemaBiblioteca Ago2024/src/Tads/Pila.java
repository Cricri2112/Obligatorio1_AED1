package Tads;


public class Pila<T extends Comparable<T>> implements IPila<T> {
    private NodoSimple<T> ultimo = null;
    private int elementos = 0;
    
    public Pila() {}

    @Override
    public boolean estaVacia() {
        return elementos == 0;
    }

    @Override
    public void apilar(T dato) {
        if(estaVacia()) {
            ultimo = new NodoSimple(dato);
        }
        else {
            NodoSimple nuevo = new NodoSimple(dato, ultimo);
            ultimo = nuevo;
        }
        elementos++;
    }

    @Override
    public T desapilar() {
        NodoSimple<T> res = null;
        if(!estaVacia()) {
            res = ultimo;
            ultimo = ultimo.getSiguiente();
            elementos--;
        }
        
        return res != null ? res.getValor() : null;
    }

    @Override
    public void vaciar() {
        ultimo = null;
    }

    @Override
    public int cantidadNodos() {
        return elementos;
    }

}
