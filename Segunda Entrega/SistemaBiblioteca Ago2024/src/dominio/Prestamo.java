
package dominio;

import java.time.LocalDateTime;


public class Prestamo implements Comparable<Prestamo> {
    private Estudiante estudiante;
    private Libro libro;
    private LocalDateTime fecha;
    private boolean activo;

    public Prestamo(Estudiante estudiante, Libro libro) {
        this.estudiante = estudiante;
        this.libro = libro;
        this.fecha = LocalDateTime.now();
        this.activo = true;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Libro getLibro() {
        return libro;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    @Override
    public int compareTo(Prestamo o) {

        return this.fecha.compareTo(o.getFecha()) == 1
            ? 1
            : this.fecha.compareTo(o.getFecha()) == 0
                ? 0
                : -1;
                    
    }
    
    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if(o.getClass() != this.getClass()) return false;
        Prestamo comparar = (Prestamo) o;
        return
        (
            this.libro.equals(comparar.getLibro()) &&
            this.estudiante.equals(comparar.getEstudiante())           
        );
    }
    
    @Override
    public String toString(){
        
        return libro.getNombre() + "#" + libro.getISBN()+ "#"+libro.getCategoria() + "#" + activo;
    }        
    
}
