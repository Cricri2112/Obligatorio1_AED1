
package dominio;

public interface IListaDoble<T extends Comparable<T>> {
    public String mostrar();
    
    public boolean esVacia();
    public int cantElementos();
    

    public Boolean agregarInicioSiNoExiste(T n);    
    public Boolean agregarFinalSiNoExiste(T n);
    public Boolean contieneElemento(T n);
    public void agregarOrdenado(T nodo);
    
    public void borrarInicio();
    public void borrarFin();
    public Boolean borrarElemento(T nodo);
    //Busca el nodo y si lo encuentra, lo borra de la lista y lo retorna
    public T borrarElementoYRetObjeto(T nodo);
    public void vaciar();

    //Busca el nodo y si lo encuentra lo devuelve, sino devuelve null
    public T obtenerElemento(T nodo);
        
    
}
