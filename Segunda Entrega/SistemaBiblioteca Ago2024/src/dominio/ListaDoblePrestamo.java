package dominio;

import Tads.ListaDoble;
import Tads.NodoDoble;

public class ListaDoblePrestamo extends ListaDoble<Prestamo> {

    public ListaDoblePrestamo() {
        super();
    }

    public int cantActivos() {
        int res = 0;
        NodoDoble<Prestamo> aux = getInicio();
        while (aux != null) {
            if (aux.getValor().getActivo()) {
                res++;
            }
            aux = aux.getSiguiente();
        }
        return res;
    }

    public boolean tienePrestamoActivo(String ISBN) {
        NodoDoble<Prestamo> aux = getInicio();
        while (aux != null) {
            if (aux.getValor().getLibro().getISBN() == ISBN && aux.getValor().getActivo()) return true;            
            aux = aux.getSiguiente();
        }
        return false;
    }
    
    @Override 
    public void agregarOrdenado(Prestamo prestamo) {
        if(esVacia() || getInicio().getValor().compareTo(prestamo) <= 0) {
            agregarInicio(prestamo);
        }
        else if(getFin().getValor().compareTo(prestamo) >= 0) {
            agregarFinal(prestamo);
        }
        else {
            NodoDoble<Prestamo> aux = getInicio();
            boolean agregado = false;
            while(aux != null && !agregado) {
                if(aux.getValor().compareTo(prestamo) <= 0) {
                    NodoDoble<Prestamo> nuevo = new NodoDoble(prestamo, aux.getAnterior(), aux);
                    aux.getAnterior().setSiguiente(nuevo);
                    aux.setAnterior(nuevo);
                    agregado = true;
                }
                
                aux = aux.getSiguiente();
            }
        }
    }
    
    @Override
    public Prestamo obtenerElemento(Prestamo p) {
        if(this.esVacia()) return null;
        else {
            NodoDoble<Prestamo> actual = this.getInicio();
            
            while(actual!= null){
                if(actual.equals(p)) return actual.getValor();
                
                actual = actual.getSiguiente();
            }

            return null;
        }
    }
    
    public String mostrarPrestados(int n) {
        if(this.esVacia()){
            return "";
        }
        else 
        {
            String res = getInicio().getValor().getLibro().toStringConPrestHist();
            NodoDoble<Prestamo> actual = getInicio().getSiguiente();
            while(actual != null && n > 0) {
                res += "|" + actual.getValor().getLibro().toStringConPrestHist();
                
                actual = actual.getSiguiente();
                if(actual != null) {
                    Libro libroActual = actual.getValor().getLibro();
                    Libro libroAnterior = actual.getAnterior().getValor().getLibro();
                    if(libroActual.getCantidadPrestHist() != libroAnterior.getCantidadPrestHist()) n--;
                }
            }
            return res;
        }
    }
}
