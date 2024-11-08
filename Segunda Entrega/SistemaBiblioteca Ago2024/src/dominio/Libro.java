package dominio;

import Tads.ListaDoble;
import Tads.Cola;
import Tads.NodoSimple;

public class Libro implements Comparable<Libro> {
    
    private String nombre;
    private String ISBN;
    private String categoria;
    private ListaDoble<Prestamo> prestamos = new ListaDoble<Prestamo>() {};
    private Cola<Estudiante> reservas = new Cola(){};
    private int cantidad;
    private int disponibles;
    
    public Libro(String nombre, String ISBN, String categoria, int cantidad){
        this.setNombre(nombre);
        this.setISBN(ISBN);
        this.setCategoria(categoria);
        this.setCantidad(cantidad);
        this.disponibles = cantidad;
    }
    
    public Libro(String ISBN){
        this.setISBN(ISBN);
        this.setNombre(null);
        this.setCategoria(null);
        this.setCantidad(0);
        this.disponibles = 0;
    }

    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }    
        public String getISBN(){
        return this.ISBN;
    }
    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }
        public String getCategoria(){
        return this.categoria;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
        public int getCantidad(){
        return this.cantidad;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    public int getDisponibles() {
        return disponibles;
    }

    public void restarDisponibles() {
        if(disponibles >0) this.disponibles--;
    }

    public ListaDoble<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        this.prestamos.agregarOrdenado(prestamo);
    }
    

    public boolean prestar(Estudiante estudiante) {
        //Se da por asumido que el estudiante tiene menos de 8 préstamos activos.
        //La clase estudiante tiene un metodo que controla la cantidad de préstamos activos.

        if (disponibles > 0) {
            disponibles--;
            return true;
        } else reservas.encolar(estudiante);      
        return false;

    }
    
    public void devolver () {
        disponibles++;
        
        NodoSimple<Estudiante> aux = reservas.getInicio();
        if(aux!= null) {
            aux.getValor().agregarPrestamo(this);
            reservas.desencolar();
        }
    }

    @Override
    public int compareTo(Libro o) {
        return this.ISBN.compareTo(o.ISBN) < 0
                ? -1
                : this.ISBN.compareTo(o.ISBN) == 0
                    ? 0
                    : 1;
    }
    
    public String toString(){
        return this.getNombre() + "#" + this.getISBN()+ "#" + this.getCategoria();
    }
    
    public String mostrarReservas() {
        return reservas.mostrar();
    }
    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if(o.getClass() != this.getClass()) return false;
        Libro comparar = (Libro) o;
        return  this.ISBN.compareTo(comparar.ISBN)==0;                   
    }
    
    
}
