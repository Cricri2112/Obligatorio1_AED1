package dominio;

import Tads.ListaDoble;
import Tads.NodoDoble;

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
    
    public void agregarOrdenadoPrestamos(Libro libro) {
        if (this.esVacia() || 
           (this.getInicio().getValor().cantPrestadosHist() <= libro.cantPrestadosHist() &&
            this.getInicio().getValor().compareTo(libro) == 1)
        ) this.agregarInicio(libro);
        
        else {
            if (this.getFin().getValor().cantPrestadosHist() >= libro.cantPrestadosHist() &&
                this.getInicio().getValor().compareTo(libro) == -1
            ) this.agregarFinal(libro);

            else {
                NodoDoble<Libro> actual = this.getInicio();
                NodoDoble<Libro> agregar = new NodoDoble(libro);
                boolean agregado = false;

                while (actual.getSiguiente() != null && !agregado) {
                    // 
                    if (actual.getValor().cantPrestadosHist() <= agregar.getValor().cantPrestadosHist() || 
                        (actual.getValor().cantPrestadosHist() == agregar.getValor().cantPrestadosHist() &&
                         actual.getValor().compareTo(libro) == 1)
                    )
                    {
                        agregar.setSiguiente(actual);
                        agregar.setAnterior(actual.getAnterior());
                        agregar.getAnterior().setSiguiente(agregar);
                        agregar.getSiguiente().setAnterior(agregar);
                        this.setCantidadNodos(this.cantElementos() + 1);
                        agregado = true;
                    }
                    actual = actual.getSiguiente();
                }
            }
        }
    }
    
     public String mostrarPrestados() {
        if(this.esVacia()){
            return "";
        }
        else 
        {
            NodoDoble<Libro> actual = this.getInicio();
            return mostrarPrestadoRec(actual);
        }
    }
    private String mostrarPrestadoRec(NodoDoble<Libro> nodo) {
        
        return nodo.getSiguiente() == null 
                ? nodo.getValor().toStringConPrestHist() 
                : nodo.getValor().toStringConPrestHist() +"|"+ mostrarPrestadoRec(nodo.getSiguiente());               
        
    }
    
    
    
    
//    private void ordernarPorISBN(NodoDoble<Libro> nuevo, NodoDoble<Libro> actual){
//        
//    }
    
//    public String devolverMasPrestados(){
//        if(!esVacia()) {
//            int max = getInicio().getValor().cantPrestadosHist();
//            String res = getInicio().getValor().toString();
//            
//            NodoDoble<Libro> aux = getInicio().getSiguiente();
//            while(aux!=null){
//                
//                if(aux.getValor().cantPrestadosHist() == max){
//                    res += "|" + aux.getValor().toString();
//                }else if(aux.getValor().cantPrestadosHist() > max){
//                    res = aux.getValor().toString();
//                }
//                aux= aux.getSiguiente();
//            }
//            
//            return res;
//        }
//        return "No hay libros en el sistema.";
//    }
}