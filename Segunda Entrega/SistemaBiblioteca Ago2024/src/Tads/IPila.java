package Tads;

public interface IPila<T> {
    public boolean estaVacia();
    public void apilar (T dato);
    public T desapilar();
    public void vaciar ();
    public int cantidadNodos(); 
}
