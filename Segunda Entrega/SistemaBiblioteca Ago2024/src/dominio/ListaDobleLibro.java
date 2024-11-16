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
        
        else {
            NodoDoble<Libro> actual = this.getInicio();
            NodoDoble<Libro> agregar = new NodoDoble(libro);
            boolean agregado = false;

            while (actual != null && !agregado) {
                
                if (libro.cantPrestadosHist() >= actual.getValor().cantPrestadosHist()) {
                    NodoDoble<Libro> nuevoAnterior = actual.getAnterior();
                    NodoDoble<Libro> nuevoSiguiente = actual.getSiguiente();
                    
                    if(libro.cantPrestadosHist() > actual.getValor().cantPrestadosHist() ||
                        (actual.getValor().cantPrestadosHist() == libro.cantPrestadosHist() && 
                         libro.compareTo(actual.getValor()) == -1)
                    ){
                        agregar.setSiguiente(actual);
                        agregar.setAnterior(nuevoAnterior);
                        
                        actual.setAnterior(agregar);
                        actual.setSiguiente(nuevoSiguiente);
                        if(nuevoAnterior == null) inicio = agregar;
                        this.setCantidadNodos(this.cantElementos() + 1);
                        agregado = true;
                    }
                    else {
                        agregar.setAnterior(actual);
                        agregar.setSiguiente(nuevoSiguiente);
                        
                        actual.setSiguiente(agregar);
                        if(nuevoSiguiente == null) fin = agregar;
                        this.setCantidadNodos(this.cantElementos() + 1);
                        agregado = true;
                    }
                    
                    
                }
                actual = actual.getSiguiente();
            }
        }
    }
    
    /*
    
    
            // Evaluo que el libro que ingresa tenga una cantidad mayor igual que el primero
        else if(libro.cantPrestadosHist() >= getInicio().getValor().cantPrestadosHist()) {
            
            // El libro que ingresa tiene mas prestados que el primero
            if(libro.cantPrestadosHist() > getInicio().getValor().cantPrestadosHist()) agregarInicio(libro);
            else {
                // El libro que ingresa tiene ISBN menor que el primero
                if(libro.compareTo(getInicio().getValor()) == -1) agregarInicio(libro);
                // Como tiene ISBN mayor que el primero, se agrega en segundo lugar
                else {
                    NodoDoble<Libro> nuevo = new NodoDoble(libro);
                    
                    if(cantidadNodos == 1) {
                        getInicio().setSiguiente(nuevo);
                        nuevo.setAnterior(getInicio());
                    }
                    else {
                        NodoDoble<Libro> nuevoSiguiente = getInicio().getSiguiente();
                        nuevoSiguiente.setAnterior(nuevo);
                        nuevo.setSiguiente(nuevoSiguiente);
                        nuevo.setAnterior(getInicio());
                        getInicio().setSiguiente(nuevo);
                    }
                    
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
                if(libro.compareTo(getFin().getValor()) == 1) agregarFinal(libro);
                // Como tiene ISBN menor que el ultimo, se agrega en ante-ultimo
                else {
                    NodoDoble<Libro> nuevo = new NodoDoble(libro);
                    
                    getFin().setAnterior(nuevo);
                    nuevo.setSiguiente(getFin());
                    cantidadNodos++;
                }
            }
        }
    */
    
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
            NodoDoble<Libro> actual = this.getInicio();
            
            while (actual != null ) {
                if (actual.getValor().equals(obj)) {
                    NodoDoble<Libro> siguienteDelActual = actual.getSiguiente();
                    NodoDoble<Libro> anteriorDelActual = actual.getAnterior();
                    
                    if(anteriorDelActual != null) {
                        anteriorDelActual.setSiguiente(siguienteDelActual);
                        if(siguienteDelActual != null) siguienteDelActual.setAnterior(anteriorDelActual);
                        else {
                            anteriorDelActual.setSiguiente(null);
                            fin = anteriorDelActual;
                        }
                    }
                    else {
                        siguienteDelActual.setAnterior(null);
                        inicio = siguienteDelActual;
                    }
                    
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