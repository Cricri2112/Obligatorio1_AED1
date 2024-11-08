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
}
