
package dominio;


public class ListaDoble<T extends Comparable<T>> implements IListaDoble<T> {
    
    private NodoDoble inicio = null;
    private NodoDoble fin = null;
    private int cantidadNodos = 0;

    public ListaDoble() {}

    private NodoDoble getInicio() {
        return inicio;
    }

    private void setInicio(NodoDoble inicio) {
        this.inicio = inicio;
    }

    private NodoDoble getFin() {
        return fin;
    }

    private void setFin(NodoDoble fin) {
        this.fin = fin;
    }

    private int getCantidadNodos() {
        return cantidadNodos;
    }

    private void setCantidadNodos(int cantidadNodos) {
        this.cantidadNodos = cantidadNodos;
    }
    
    //Implementar interfaz
    
    @Override
    public boolean esVacia() {
        return this.cantidadNodos==0;
    }
    
    @Override
    public String mostrar() {
        if(this.esVacia()){  
            return "Lista vacía";
        }else {
            String res = "";
            NodoDoble actual = this.getInicio();
            while(actual!=null){
                res += (actual.toString() + " - ");                
                actual = actual.getSiguiente();
            }
            return res;
        }
    }
    
    @Override
    public int cantElementos() {
        return this.getCantidadNodos();
    }

    @Override
    public void agregarInicio(T nodo) {
        NodoDoble nuevo = new NodoDoble(nodo);
        if(this.esVacia()){
            this.setInicio(nuevo);
            this.setFin(nuevo);
        }else {
            nuevo.setSiguiente(this.getInicio());
            this.getInicio().setAnterior(nuevo);
            this.setInicio(nuevo);
        }
        this.cantidadNodos++;        
    }

    @Override
    public void agregarFinal(Comparable nodo) {
        NodoDoble nuevo = new NodoDoble(nodo);
        if(this.esVacia()){
            this.setInicio(nuevo);
            this.setFin(nuevo);
        }else {
            this.getFin().setSiguiente(nuevo);
            nuevo.setAnterior(this.getFin());
            this.setFin(nuevo);
        }
        this.cantidadNodos++;
    }

    @Override
    public Boolean agregarInicioSiNoExiste(Comparable n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean agregarFinalSiNoExiste(Comparable n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarOrdenado(Comparable nodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Boolean contieneElemento(Comparable nodo) {
        NodoDoble actual = this.getInicio();
        NodoDoble buscado = new NodoDoble(nodo);
        while(actual != null) {
            if(buscado.getValor().compareTo(actual.getValor()) == 0) return true; 
                
            actual = actual.getSiguiente();
        }
        return false;
    }
    
    @Override
    public Comparable obtenerElemento(Comparable nodo) {
        NodoDoble buscar = new NodoDoble(nodo);
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void borrarInicio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void borrarFin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean borrarElemento(Comparable nodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Comparable borrarElementoYRetObjeto(Comparable nodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void vaciar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
