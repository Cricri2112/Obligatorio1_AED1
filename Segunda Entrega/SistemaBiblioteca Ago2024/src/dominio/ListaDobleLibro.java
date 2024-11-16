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
        if(esVacia()) {
            this.agregarInicio(libro);
        }
        
        // Evaluo que el libro que ingresa tenga una cantidad mayor igual que el primero
        else if(getInicio().getValor().cantPrestadosHist() <= libro.cantPrestadosHist()) {
            
            // El libro que ingresa tiene mas prestados que el primero
            if(libro.cantPrestadosHist() > getInicio().getValor().cantPrestadosHist()) agregarInicio(libro);
            else {
                // El libro que ingresa tiene ISBN menor que el primero
                if(getInicio().getValor().compareTo(libro) == 1) agregarInicio(libro);
                // Como tiene ISBN mayor que el primero, se agrega en segundo lugar
                else {
                    NodoDoble<Libro> nuevo = new NodoDoble(libro);
                    
                    getInicio().setSiguiente(nuevo);
                    nuevo.setAnterior(getInicio());
                    cantidadNodos++;
                }
            }
        }
        
        // Evaluo que el libro que ingresa tenga una cantidad menor igual que el ultimo
        else if(libro.cantPrestadosHist() <= getFin().getValor().cantPrestadosHist()) {
            
            // El libro que ingresa tiene menos prestados que el ultimo
            if(libro.cantPrestadosHist() < getFin().getValor().cantPrestadosHist()) agregarFinal(libro);
            else {
                // El libro que ingresa tiene ISBN mayor que el ultimo
                if(getFin().getValor().compareTo(libro) == -1) agregarFinal(libro);
                // Como tiene ISBN menor que el ultimo, se agrega en ante-ultimo
                else {
                    NodoDoble<Libro> nuevo = new NodoDoble(libro);
                    
                    getFin().setAnterior(nuevo);
                    nuevo.setSiguiente(getFin());
                    cantidadNodos++;
                }
            }
        }
        
        // Para todo lo demás, existe el while
        else {
            NodoDoble<Libro> actual = this.getInicio();
            NodoDoble<Libro> agregar = new NodoDoble(libro);
            boolean agregado = false;

            while (actual.getSiguiente() != null && !agregado) {
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
    
    public Boolean borrarElementoCantPrest(Libro obj) {
        if (this.esVacia()) return false;
        
        if (this.cantidadNodos == 1) {
            if (this.getInicio().equals(obj)) {
                this.borrarInicio();
                return true;
            } else {
                return false;
            }
        } 
        else {
            
            if (this.getInicio().equals(obj)) {
                this.borrarInicio();
                return true;
            }
            if (this.getFin().equals(obj)) {
                this.borrarFin();
                return true;
            }
            
            NodoDoble<Libro> actual = this.getInicio().getSiguiente();
            while (actual != null ) {
                if (actual.getValor().equals(obj)) {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                    this.cantidadNodos--;
                    return true;
                }
                
                actual = actual.getSiguiente();
            }
            
            return false;
        }
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