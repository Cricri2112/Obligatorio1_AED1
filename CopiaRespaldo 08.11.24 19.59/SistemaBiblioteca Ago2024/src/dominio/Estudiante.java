package dominio;

import Tads.ListaDoble;

public class Estudiante implements Comparable<Estudiante> {
    
    private String nombre;
    private String apellido;
    private int numero;
    private ListaDoblePrestamo prestamos = new ListaDoblePrestamo() {};
    
    public Estudiante(String nombre, String apellido, int numero) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setNumero(numero);
    }
    
   public Estudiante( int numero) {
        this.setNombre(null);
        this.setApellido(null);
        this.setNumero(numero);
    }

    public ListaDoblePrestamo getPrestamos() {
        return prestamos;
    }
    
    public int cantPrestamosActivos() {
        return prestamos.cantActivos();
    }
    
    public Boolean agregarPrestamo(Prestamo prestamo) {
        if(this.prestamos.cantActivos()> 7) {
            return false;
        }
        
        Libro libroActual = prestamo.getLibro();
        if(libroActual.tieneDisponibles()) {
            
            if(yaTienePrestamoActivo(prestamo.getLibro().getISBN())) return false;
            
            else {
                libroActual.agregarPrestamo(prestamo);
                prestamos.agregarOrdenado(prestamo);
                return true;
            }
        }
        else {
            libroActual.agregarColaEspera(this);
            return false;
        }
    }
    
    public boolean yaTienePrestamoActivo (String ISBN) {
        return prestamos.tienePrestamoActivo(ISBN);
    }
    
    public boolean devolverPrestamo(Libro libro) {
        Prestamo buscar = prestamos.obtenerElemento(new Prestamo(this, libro));
        
        if( buscar == null || !buscar.getActivo()) {
            return false;
        }
        
        libro.devolver();
        buscar.setActivo(false);
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
