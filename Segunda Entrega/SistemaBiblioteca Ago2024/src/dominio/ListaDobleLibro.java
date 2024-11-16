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
    if (esVacia()) {
        this.agregarInicio(libro); 
    } else {
        NodoDoble<Libro> actual = this.getInicio();
        NodoDoble<Libro> agregar = new NodoDoble<>(libro);
        boolean agregado = false;

        while (actual != null && !agregado) {
            if (libro.cantPrestadosHist() > actual.getValor().cantPrestadosHist() ||
                (libro.cantPrestadosHist() == actual.getValor().cantPrestadosHist() &&
                 libro.compareTo(actual.getValor()) < 0)) {

                if (actual.getAnterior() != null) {
                    actual.getAnterior().setSiguiente(agregar);
                } else {
                    this.inicio = agregar;
                }

                agregar.setAnterior(actual.getAnterior());
                agregar.setSiguiente(actual);

                actual.setAnterior(agregar);

                this.setCantidadNodos(this.cantElementos() + 1);
                agregado = true;
            }

            actual = actual.getSiguiente();
        }

        if (!agregado) {
            NodoDoble<Libro> finActual = this.fin;

            finActual.setSiguiente(agregar);
            agregar.setAnterior(finActual);
            this.fin = agregar;

            this.setCantidadNodos(this.cantElementos() + 1);
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
    
     
     public String mostrarPrestados(int n) {
        if(this.esVacia()){
            return "";
        }
        else 
        {
            ListaDoble<Libro> listaRes = new ListaDoble();
            NodoDoble<Libro> actual = getInicio();
            //
            
            while(actual != null && n > 0) {
                listaRes.agregarOrdenado(actual.getValor());
                actual = actual.getSiguiente();
                if(actual != null) {
                    Libro libroActual = actual.getValor();
                    Libro libroAnterior = actual.getAnterior().getValor();
                    if(libroActual.getCantidadPrestHist() != libroAnterior.getCantidadPrestHist()) n--;
                }
            }
            
            String res = listaRes.getInicio().getValor().toStringConPrestHist();
            
            NodoDoble<Libro> actual2 = listaRes.getInicio().getSiguiente();
            while(actual2 != null) {
                res += "|" + actual2.getValor().toStringConPrestHist();
                actual2 = actual2.getSiguiente();
            }
            
            return res;
        }
    }
//    private String mostrarPrestadoRec(NodoDoble<Libro> nodo) {
//        
//        return nodo.getSiguiente() == null 
//                ? nodo.getValor().toStringConPrestHist() 
//                : nodo.getValor().toStringConPrestHist() +"|"+ mostrarPrestadoRec(nodo.getSiguiente());               
//        
//    }
    
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
    
    
    public String obtenerReservadosPorCategoria() {
        ListaDoble<CategoriaReservas> res = new ListaDoble();
        NodoDoble<Libro> aux = getInicio();
        while(aux != null) {
            Libro libroAux = aux.getValor();
            CategoriaReservas nuevo = new CategoriaReservas(libroAux.getCategoria(), libroAux.getCantidadReservas());
            CategoriaReservas contiene = res.obtenerElemento(nuevo);
            if(contiene != null) {
                contiene.reservas = nuevo.reservas;
            }
            else {
                res.agregarOrdenado(nuevo);
            }
            
            aux = aux.getSiguiente();
        }
        
        return res.mostrar();
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