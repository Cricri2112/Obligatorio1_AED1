package dominio;

public class ListaDobleLibro extends ListaDoble  {
    public ListaDobleLibro(){
        
    }
    
    public mostrarPorCategoria(String categoria){
       public String mostrar() {
        if(this.esVacia()){  
            return "";
        }else {
            NodoDoble actual = this.getInicio();
            return mostrarRec(actual);
        }
    }
    private String mostrarPorCategoriaRec(NodoDoble nodo) {
        String res = "";
        
        if(nodo.getSiguiente() == null) {
            if(nodo.getValor().getC)
                return res += nodo.getValor().toString();
        }
        else {
            return res = nodo.getValor().toString() + "|" + mostrarRec(nodo.getSiguiente());
        }
    } 
    }
    
    
    
}
