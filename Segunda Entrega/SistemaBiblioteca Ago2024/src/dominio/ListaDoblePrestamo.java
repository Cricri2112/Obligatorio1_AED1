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
    public Prestamo obtenerElemento(Prestamo prestamo) {
        if(this.esVacia()) return null;
        
        else {
            NodoDoble<Prestamo> actual = this.getInicio();
            Boolean sigue = true;
            NodoDoble<Prestamo> res = null;
            while(actual!= null && sigue){
                if(actual.getValor().equals(prestamo)) {
                    res = actual;
                    sigue = false;
                }
                else {
                    actual = actual.getSiguiente();
                }
            }
            // Nunca debería ser null porque ya se pregunta si: 
            // this.menorPrimerMayorUltimo(nodo)
            return res != null
                ? res.getValor()
                : null;
        }
    }
    
//    @Override 
//    public void agregarOrdenado(Prestamo prestamo) {
//        if (this.esVacia() || this.getInicio().getValor().compareTo(prestamo) >= 1) {
//            this.agregarInicio(prestamo);
//        } else {
//
//            if (this.getFin().getValor().compareTo(prestamo) <= 0) {
//                this.agregarFinal(prestamo);
//            } else {
//                NodoDoble<Prestamo> actual = this.getInicio();
//                NodoDoble<Prestamo> agregar = new NodoDoble(prestamo);
//                boolean agregado = false;
//
//                while (actual != null && !agregado) {
//                    // actual < agregar
//                    if (actual.getValor().compareTo(agregar.getValor()) == -1) {
//                        agregar.setSiguiente(actual);
//                        agregar.setAnterior(actual.getAnterior());
//                        agregar.getAnterior().setSiguiente(agregar);
//                        agregar.getSiguiente().setAnterior(agregar);
//                        this.setCantidadNodos(this.cantElementos()+1);
//                        agregado = true;
//                    }
//                    actual = actual.getSiguiente();
//                }
//            }
//        }
//    }  
}
