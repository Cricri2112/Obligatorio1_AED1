package sistemaAutogestion;

import Tads.ListaDoble;
import dominio.Estudiante;
import dominio.Libro;
import dominio.ListaDobleLibro;
import dominio.Prestamo;

public class Sistema implements IObligatorio {
    public ListaDobleLibro Libros;
    public ListaDoble<Estudiante> Estudiantes;
    public ListaDoble<Prestamo> Prestamos;
    
    public Sistema() {
        crearSistemaDeGestion();
    }
    
    @Override
    public Retorno crearSistemaDeGestion() {
        Libros = new ListaDobleLibro() {};
        Estudiantes = new ListaDoble() {};
        Prestamos = new ListaDoble() {};
        return Retorno.ok();
    }

    @Override
    public Retorno agregarEstudiante(String nombre, String apellido, int numero) {
        if(nombre == null || apellido == null || nombre == "" || apellido == "") return Retorno.error1();
        if(numero <= 0 || numero > 500000) return Retorno.error2();
        
        Estudiante nuevo = new Estudiante(nombre, apellido, numero);
        
        if(Estudiantes.contieneElemento(nuevo)) return Retorno.error3();

        Estudiantes.agregarOrdenado(nuevo);
   
        return Retorno.ok();
    }

    @Override
    public Retorno obtenerEstudiante(int numero) {
        if(numero <=0 || numero > 500000) return Retorno.error1();
        
        Estudiante buscar = (Estudiante) Estudiantes.obtenerElemento(new Estudiante(null, null, numero));
        if(buscar== null) return Retorno.error2();
        
        Retorno res = new Retorno(Retorno.Resultado.OK);        
        res.valorString = buscar.toString();        
        return res;
    }

    @Override
    public Retorno eliminarEstudiante(int numero) {
        if(numero <=0 || numero > 500000) return Retorno.error1();
        
        Estudiante estudiante = (Estudiante) Estudiantes.obtenerElemento(new Estudiante(null, null, numero));
        if(estudiante== null) return Retorno.error2();
        
        if(estudiante.getPrestamos().cantElementos() > 0) return Retorno.error3();
        
        Estudiantes.borrarElemento(estudiante);
        return Retorno.ok();
    }

    @Override
    public Retorno agregarLibro(String nombre, String ISBN, String categoría, int cantidad) {
        if(nombre == null || ISBN == null || categoría == null|| nombre == "" || ISBN == "" || categoría == "") return Retorno.error1();
        
        if(cantidad <=0) return Retorno.error3();
        
        Libro agregar = new Libro(nombre, ISBN, categoría, cantidad);
       
        if(Libros.contieneElemento(agregar)) return Retorno.error2();        
        
        Libros.agregarOrdenado(agregar);
        
        return Retorno.ok();
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
        Retorno res = new Retorno(Retorno.Resultado.OK);
        res.valorString = Estudiantes.mostrar();
        return res;
    }

    @Override
    public Retorno listarLibros() {
        Retorno res = new Retorno(Retorno.Resultado.OK);
        res.valorString = Libros.mostrar();
        return res;
    }

    @Override
    public Retorno listarLibros(String categoria) {
        if(categoria == null || categoria == "") return Retorno.error1();
        Retorno res = new Retorno(Retorno.Resultado.OK);
        res.valorString = Libros.mostrar(categoria);
        return res;
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
