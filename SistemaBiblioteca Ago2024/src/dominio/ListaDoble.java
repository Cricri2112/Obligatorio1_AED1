
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

    private void agregarInicio(T nodo) {
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

    private void agregarFinal(T nodo) {
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
    public void agregarOrdenado(T nodo) {
        if(this.esVacia()){
            this.agregarInicio(nodo);
        }else {
            NodoDoble actual = this.getInicio();
            NodoDoble agregar = new  NodoDoble(nodo);
            
            if(this.getFin().getValor().compareTo(agregar.getValor())==-1){
                this.agregarFinal(nodo);
            }else {
                boolean agregado = false;
                while(actual!=null && !agregado){
                    if(actual.getValor().compareTo(agregar.getValor()) == 1){
                        agregar.setAnterior(actual.getAnterior());
                        actual.getAnterior().setSiguiente(agregar);
                        agregar.setSiguiente(actual);
                        actual.setAnterior(agregar);
                        this.cantidadNodos++; 
                        agregado = true;
                    }
                    actual = actual.getSiguiente();
                }
            }
        }
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
    public Boolean contieneElemento(Comparable nodo) {
        if(this.esVacia()) return false;
        NodoDoble actual = this.getInicio();
        boolean encontrado = false;
        while(actual != null && !encontrado) {
            
            if(actual.equals(nodo)) return true; 
                
            actual = actual.getSiguiente();
        }
        return false;
    }
    
    @Override
    public Comparable obtenerElemento(Comparable nodo) {
        if(this.esVacia()) return null;
        NodoDoble actual = this.getInicio();
        while(actual!= null){
            if(actual.equals(nodo)) return actual.getValor(); 
            
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public void borrarInicio() {
        if(!this.esVacia()){
            if(this.cantidadNodos == 1){
                this.setInicio(null);
                this.setFin(null);
            }else {
                this.setInicio(this.getInicio().getSiguiente());
                this.getInicio().setAnterior(null);
            }
            this.cantidadNodos--;
        }else {
           System.out.println("No hay elementos para eliminar, la lista está vacía.");
        }
        
    }

    @Override
    public void borrarFin() {
        if(!this.esVacia()){
            if(this.cantidadNodos == 1){
                this.setInicio(null);
                this.setFin(null);
            }else {
                this.setFin(this.getFin().getAnterior());
                this.getFin().setSiguiente(null);
            }
            this.cantidadNodos--;
        }else {
           System.out.println("No hay elementos para eliminar, la lista está vacía.");
        }   
    }

    @Override
    public Boolean borrarElemento(Comparable nodo) {
        if(!this.esVacia()){
            NodoDoble actual = this.getInicio();
            if(this.cantidadNodos==1 ){
                if(actual.equals(nodo)) {
                    this.borrarInicio();
                    return true;
                } else {
                    return false;
                }
                
            }else {
                
            }
        }
        
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
