
package dominio;

public interface IListaDoble<T extends Comparable<T>> {
    public String mostrar();
    
    public boolean esVacia();
    public int cantElementos();
    

    public Boolean agregarInicioSiNoExiste(T obj);    
    public Boolean agregarFinalSiNoExiste(T obj);
    public Boolean contieneElemento(T obj);
    public void agregarOrdenado(T obj);
    
    public void borrarInicio();
    public void borrarFin();
    public Boolean borrarElemento(T obj);
    //Busca el nodo y si lo encuentra, lo borra de la lista y lo retorna
    public T borrarElementoYRetObjeto(T obj);
    public void vaciar();

    //Busca el nodo y si lo encuentra lo devuelve, sino devuelve null
    public T obtenerElemento(T obj);
        
    
}