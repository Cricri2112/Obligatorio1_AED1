package dominio;

public class Estudiante implements Comparable<Estudiante> {
    
    private String nombre;
    private String apellido;
    private int numero;
    private ListaDoble<Libro> prestamosActivos = new ListaDoble<Libro>();
    
    public Estudiante(String nombre, String apellido, int numero) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setNumero(numero);
    }
    
    public Boolean agregarPrestamo(Libro libro) {
        if(this.prestamosActivos.cantElementos() > 8) {
            return false;
        }
        if(this.prestamosActivos.contieneElemento(libro)) {
            return false;
        }
        
        this.prestamosActivos.agregarOrdenado(libro);
        return true;
    }
    
    public Boolean eliminarPrestamo(Libro libro) {
        if(!this.prestamosActivos.contieneElemento(libro)) {
            return false;
        }
        
        this.prestamosActivos.borrarElemento(libro);
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
