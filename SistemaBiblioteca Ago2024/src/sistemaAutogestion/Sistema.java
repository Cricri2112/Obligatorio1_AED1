package sistemaAutogestion;

import dominio.ListaDoble;
import dominio.Estudiante;

public class Sistema implements IObligatorio {
    private ListaDoble Libros = new ListaDoble();
    private ListaDoble Estudiantes = new ListaDoble();
    
    @Override
    public Retorno crearSistemaDeGestion() {
        
        return Retorno.ok();
    }

    @Override
    public Retorno agregarEstudiante(String nombre, String apellido, int numero) {
        if(nombre == null || apellido == null || nombre == "" || apellido == "") return Retorno.error1();
        if(numero <= 0 || numero > 500000) return Retorno.error2();
        
        Estudiante nuevo = new Estudiante(nombre, apellido, numero);
        
        if(Estudiantes.contieneElemento(nuevo)) return Retorno.error3();
        
        Estudiantes.agregarInicio(nuevo);
        return Retorno.ok();
    }

    @Override
    public Retorno obtenerEstudiante(int numero) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno eliminarEstudiante(int numero) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno agregarLibro(String nombre, String ISBN, String categoría, int cantidad) {
           return Retorno.noImplementada();
    }
    
        @Override
    public Retorno eliminarLibro(String ISBN) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno prestarLibro(String ISBN, int numero) {
         return Retorno.noImplementada();
    }

   @Override
    public Retorno reservarLibro(String ISBN, int numero) {
         return Retorno.noImplementada();
    }
    
    @Override
    public Retorno devolverLibro(String ISBN, int numero) {
         return Retorno.noImplementada();
    }

    @Override
    public Retorno listarEstudiantes() {
          return Retorno.noImplementada();
    }

    @Override
    public Retorno listarLibros() {
          return Retorno.noImplementada();
    }

    @Override
    public Retorno listarLibros(String categoria) {
           return Retorno.noImplementada();
    }

    @Override
    public Retorno listarPrestamos(int numero) {
           return Retorno.noImplementada();
    }

    @Override
    public Retorno librosMasPrestados() {
             return Retorno.noImplementada();
    }

    @Override
    public Retorno deshacerEliminaciones(int n) {
             return Retorno.noImplementada();
    }

    @Override
    public Retorno cantidadPrestamosActivos(String ISBN) {
           return Retorno.noImplementada();
    }

    @Override
    public Retorno prestamosXCategoría() {
           return Retorno.noImplementada();
    }

   



}
