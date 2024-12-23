
package Tads;

import Tads.NodoDoble;
import Tads.IListaDoble;

public class ListaDoble<T extends Comparable<T>> implements IListaDoble<T> {
    
    protected NodoDoble<T> inicio = null;
    protected NodoDoble<T> fin = null;
    protected int cantidadNodos = 0;

    public ListaDoble() {}

    public NodoDoble<T> getInicio() {
        return inicio;
    }

    private void setInicio(NodoDoble<T> inicio) {
        this.inicio = inicio;
    }

    public NodoDoble<T> getFin() {
        return fin;
    }

    private void setFin(NodoDoble<T> fin) {
        this.fin = fin;
    }

    public int getCantidadNodos() {
        return cantidadNodos;
    }

    public void setCantidadNodos(int cantidadNodos) {
        this.cantidadNodos = cantidadNodos;
    }
    
    //Implementar interfaz
    
    @Override
    public boolean esVacia() {
        return this.cantidadNodos==0;
    }
    
    @Override
    public String mostrar() {
        if (this.esVacia()) {
            return "";
        } else {
            NodoDoble<T> actual = this.getInicio();
            return mostrarRec(actual);
        }
    }

    private String mostrarRec(NodoDoble<T> nodo) {
        String res = "";

        if (nodo.getSiguiente() == null) {
            return res += nodo.getValor().toString();
        } else {
            return res = nodo.getValor().toString() + "|" + mostrarRec(nodo.getSiguiente());
        }
    }
    
    @Override
    public int cantElementos() {
        return this.getCantidadNodos();
    }

    public void agregarInicio(T obj) {
        NodoDoble<T> nuevo = new NodoDoble(obj);
        if (this.esVacia()) {
            this.setInicio(nuevo);
            this.setFin(nuevo);
        } else {
            nuevo.setSiguiente(this.getInicio());
            this.getInicio().setAnterior(nuevo);
            this.setInicio(nuevo);
        }
        this.cantidadNodos++;
    }

    public void agregarFinal(T obj) {
        NodoDoble<T> nuevo = new NodoDoble<T>(obj);
        if (this.esVacia()) {
            this.setInicio(nuevo);
            this.setFin(nuevo);
        } else {
            this.getFin().setSiguiente(nuevo);
            nuevo.setAnterior(this.getFin());
            this.setFin(nuevo);
        }
        this.cantidadNodos++;
    }


    @Override
    public void agregarOrdenado(T obj) {
        if (this.esVacia() || this.getInicio().getValor().compareTo(obj) == 1) {
            this.agregarInicio(obj);
        } else {

            if (this.getFin().getValor().compareTo(obj) == -1) {
                this.agregarFinal(obj);
            } else {
                NodoDoble<T> actual = this.getInicio();
                NodoDoble<T> agregar = new NodoDoble<T>(obj);
                boolean agregado = false;

                while (actual != null && !agregado) {
                    // actual < agregar
                    if (actual.getValor().compareTo(agregar.getValor()) == 1) {
                        agregar.setSiguiente(actual);
                        agregar.setAnterior(actual.getAnterior());
                        agregar.getAnterior().setSiguiente(agregar);
                        agregar.getSiguiente().setAnterior(agregar);
                        this.cantidadNodos++;
                        agregado = true;
                    }
                    actual = actual.getSiguiente();
                }
            }
        }
    }

    protected Boolean menorPrimerMayorUltimo(T obj) {
        return (this.getInicio().getValor().compareTo(obj) == 1
                || this.getFin().getValor().compareTo(obj) == -1);
    }
    
    @Override
    public Boolean contieneElemento(T obj) {
        if(this.esVacia()) {
            return false;
        }
        
        NodoDoble<T> actual = this.getInicio();
        NodoDoble<T> buscar = new NodoDoble<T>(obj);
        
        if(this.menorPrimerMayorUltimo(obj)) {
            return false;
        }
        else {
            boolean sigue = true;
            while(actual != null && sigue) {
                if(
                    actual.getValor().compareTo(buscar.getValor()) == 0 || 
                    actual.getValor().compareTo(buscar.getValor()) == 1
                ) {
                    sigue = false;
                }
                else {
                    actual = actual.getSiguiente();
                }
            }
            
            return actual.equals(obj);
        }
    }
    
    @Override
    public T obtenerElemento(T obj) {
        if(this.esVacia()) return null;
        
        if(this.menorPrimerMayorUltimo(obj)) {
            return null;
        }
        else {
            NodoDoble<T> actual = this.getInicio();
            NodoDoble<T> res = null;
            while(actual!= null){
                if(actual.getValor().equals(obj)) {
                    return actual.getValor();
                }
                //Si se pasa corta, lista ordenada.
                else if (actual.getValor().compareTo(obj) == 1) return null; 
                else actual = actual.getSiguiente();
            }
            return null;
        }
    }

    @Override
    public void borrarInicio() {
        if (!this.esVacia()) {
            if (this.cantidadNodos == 1) {
                this.setInicio(null);
                this.setFin(null);
            } else {
                this.setInicio(this.getInicio().getSiguiente());
                this.getInicio().setAnterior(null);
            }
            this.cantidadNodos--;
        } else {
            System.out.println("No hay elementos para eliminar, la lista está vacía.");
        }
    }

    @Override
    public void borrarFin() {
        if (!this.esVacia()) {
            if (this.cantidadNodos == 1) {
                this.setInicio(null);
                this.setFin(null);
            } else {
                this.setFin(this.getFin().getAnterior());
                this.getFin().setSiguiente(null);
            }
            this.cantidadNodos--;
        } else {
            System.out.println("No hay elementos para eliminar, la lista está vacía.");
        }
    }

    @Override
    public Boolean borrarElemento(T obj) {
        if (this.esVacia()) return false;
        
        if (this.menorPrimerMayorUltimo(obj)) {
            return false;
        }
        
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
            
            NodoDoble<T> actual = this.getInicio().getSiguiente();
            while (actual != null ) {
                if (actual.getValor().equals(obj) || actual.getValor().compareTo(obj) == 1) {
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

    @Override
    public void vaciar() {
        this.setInicio(null);
        this.setFin(null);
        this.cantidadNodos = 0;
    }
}
