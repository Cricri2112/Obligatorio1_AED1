package sistemaAutogestion;

import Tads.ListaDoble;
import dominio.Estudiante;
import dominio.Libro;
import dominio.ListaDobleLibro;
import dominio.ListaDoblePrestamo;
import dominio.Prestamo;

public class Sistema implements IObligatorio {
    public ListaDobleLibro Libros;
    public ListaDoble<Estudiante> Estudiantes;
    public ListaDoblePrestamo Prestamos;
    
    public Sistema() {
        crearSistemaDeGestion();
    }
     @Override
    public String getPrestamos() {
        return Prestamos.mostrar();
    }
      @Override
    public ListaDobleLibro getLibros() {
        return Libros;
    }
    
    @Override
    public Retorno crearSistemaDeGestion() {
        Libros = new ListaDobleLibro() {};
        Estudiantes = new ListaDoble() {};
        Prestamos = new ListaDoblePrestamo() {};
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
        
        Estudiante estudiante = (Estudiante) Estudiantes.obtenerElemento(new Estudiante(numero));
        if(estudiante== null) return Retorno.error2();
        
        if(estudiante.cantPrestamosActivos() > 0) return Retorno.error3();
        
        Estudiantes.borrarElemento(estudiante);
        return Retorno.ok();
    }

    @Override
    public Retorno agregarLibro(String nombre, String ISBN, String categoría, int cantidad) {
        if(nombre == null || ISBN == null || categoría == null|| nombre == "" || ISBN == "" || categoría == "") return Retorno.error1();
        
        if (cantidad <= 0) return Retorno.error3();
        
        Libro agregar = new Libro(nombre, ISBN, categoría, cantidad);
       
        if(Libros.contieneElemento(agregar)) return Retorno.error2();        
        
        Libros.agregarOrdenado(agregar);
        
        return Retorno.ok();
    }
    
//------------------------------------------
// Segunda entrega
    

    @Override
    public Retorno prestarLibro(String ISBN, int numero) {
        if(ISBN == "" || ISBN== null) return Retorno.error1();
        
        Libro existeLibro = Libros.obtenerElemento(new Libro(ISBN));
        if(existeLibro== null)  return Retorno.error2();
        
        Estudiante existeEstudiante = Estudiantes.obtenerElemento(new Estudiante(numero));
        if(existeEstudiante==null)return Retorno.error3();
        
        if(existeLibro.getDisponibles() == 0) return Retorno.error4();
        
        if(existeEstudiante.yaTienePrestamoActivo(ISBN) || existeEstudiante.cantPrestamosActivos() == 8 )return Retorno.error5();
        
        existeEstudiante.agregarPrestamo(existeLibro); 
        Prestamos.agregarOrdenado(new Prestamo(existeEstudiante, existeLibro));
        return Retorno.ok();
    }

    

    @Override
    public Retorno reservarLibro(String ISBN, int numero) {
        if (ISBN == "" || ISBN == null) return Retorno.error1();

        Libro existeLibro = Libros.obtenerElemento(new Libro(ISBN));
        if (existeLibro == null) return Retorno.error2();

        Estudiante existeEstudiante = Estudiantes.obtenerElemento(new Estudiante(numero));
        if (existeEstudiante == null) return Retorno.error3();
       
        if(existeLibro.getDisponibles() > 0) return Retorno.error4();
        
        existeEstudiante.agregarPrestamo(existeLibro);
        return Retorno.ok();        
    }

    @Override
    public Retorno devolverLibro(String ISBN, int numero) {
        if (ISBN == "" || ISBN == null) return Retorno.error1();        

        Libro existeLibro = Libros.obtenerElemento(new Libro(ISBN));
        if (existeLibro == null) return Retorno.error2();        

        Estudiante existeEstudiante = Estudiantes.obtenerElemento(new Estudiante(numero));
        if (existeEstudiante == null) return Retorno.error3();

        return existeEstudiante.devolverPrestamo(existeLibro) ? Retorno.ok() : Retorno.error4();
    }
            
//1.- Si el ISBN es vacío o null.
//2.- Si se realizaron préstamos de dicho libro. 
    @Override
    public Retorno eliminarLibro(String ISBN) {
        if (ISBN == "" || ISBN == null) return Retorno.error1();  
        
        Libro existeLibro = Libros.obtenerElemento(new Libro(ISBN));
        if(existeLibro.getPrestamos().cantElementos() > 0) return Retorno.error2();
        
        Libros.borrarElemento(existeLibro);
        return Retorno.ok();
    }
//-----------------------------------------------
    
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

//------------------------------------------------------
// Segunda entrega
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
