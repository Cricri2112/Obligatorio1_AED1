
package Tads;

public interface IListaDoble<T extends Comparable<T>> {
    public String mostrar();
    
    public boolean esVacia();
    public int cantElementos();
    
    public Boolean contieneElemento(T obj);
    public void agregarOrdenado(T obj);
    
    public void borrarInicio();
    public void borrarFin();
    public Boolean borrarElemento(T obj);
    
    public void vaciar();

    public T obtenerElemento(T obj);
}
