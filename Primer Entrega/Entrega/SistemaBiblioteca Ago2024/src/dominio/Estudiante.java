package dominio;

public class Estudiante implements Comparable<Estudiante> {
    
    private String nombre;
    private String apellido;
    private int numero;
    private ListaDoble<Prestamo> prestamos = new ListaDoble<Prestamo>() {};
    
    public Estudiante(String nombre, String apellido, int numero) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setNumero(numero);
    }

    public ListaDoble<Prestamo> getPrestamos() {
        return prestamos;
    }
    
    public Boolean agregarPrestamo(Libro libro) {
        if(this.prestamos.cantElementos() > 7) {
            return false;
        }
        
        Prestamo nuevoPrestamo = new Prestamo(this, libro);
        
        // Chequeo si ya tiene un préstamo activo de ese libro
        Prestamo buscar = this.prestamos.obtenerElemento(nuevoPrestamo);
        if(buscar != null) {
            return false;
        }
        
        this.prestamos.agregarInicio(nuevoPrestamo);
        return true;
    }
    
    public Boolean devolverPrestamo(Prestamo prestamo) {
        Prestamo buscar = this.prestamos.obtenerElemento(prestamo);
        
        if( buscar == null || !buscar.getActivo()) {
            return false;
        }
        
        buscar.setActivo(false);
        this.prestamos.borrarElemento(buscar);
        return true;
    }

    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
     public String getApellido() {
        return this.apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
     public int getNumero() {
        return this.numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public int compareTo(Estudiante o) {
        return this.numero < o.numero
                ? -1
                : this.numero == o.numero
                    ? 0
                    : 1;
    }
    
    public String toString(){
        return this.getNombre() + "#" + this.getApellido() + "#" + this.getNumero();
    }
    
    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if(o.getClass() != this.getClass()) return false;
        Estudiante comparar = (Estudiante) o;
        return  this.numero == comparar.numero;
                   
    }
    
    
}
