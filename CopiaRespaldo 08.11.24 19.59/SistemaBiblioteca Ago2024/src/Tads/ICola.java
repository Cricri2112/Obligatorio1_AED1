package Tads;

public interface ICola<T extends Comparable<T>> {

    public String mostrar();    
    public boolean esVacia();
    public void encolar(T obj);
    public void desencolar();
    public int cantElementos();
    public void vaciar();
}
