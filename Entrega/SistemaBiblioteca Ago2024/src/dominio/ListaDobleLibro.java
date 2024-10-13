package dominio;

public class ListaDobleLibro extends ListaDoble<Libro>  {
    public ListaDobleLibro(){
        super();
    }
    
    public String mostrar(String categoria) {
        if(this.esVacia()){
            return "";
        }
        else 
        {
            NodoDoble<Libro> actual = this.getInicio();
            return mostrarPorCategoriaRec(actual, categoria);
        }
    }
    private String mostrarPorCategoriaRec(NodoDoble<Libro> nodo,String categoria) {
        String res = "";
        if(nodo.getSiguiente() == null) {            
            return nodo.getValor().getCategoria()==categoria ? res += nodo.getValor().toString() : res;   
        }
        else 
        {
            if(nodo.getValor().getCategoria()==categoria) {
                return res = nodo.getValor().toString() + "|" + mostrarPorCategoriaRec(nodo.getSiguiente(), categoria);
            }
            else {
                return res = mostrarPorCategoriaRec(nodo.getSiguiente(), categoria);
            }
        }
    }
}