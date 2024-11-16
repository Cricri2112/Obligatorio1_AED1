package sistemaAutogestion;

import Tads.ListaDoble;
import Tads.Pila;
import dominio.Estudiante;
import dominio.Libro;
import dominio.ListaDobleLibro;
import dominio.ListaDoblePrestamo;
import dominio.Prestamo;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sistema implements IObligatorio {
    public ListaDobleLibro Libros;
    public ListaDobleLibro LibrosOrdenPrestados;
    public Pila<Libro> LibrosEliminados;
    public ListaDoble<Estudiante> Estudiantes;
    public ListaDoblePrestamo Prestamos;
    
    public Sistema() {
        crearSistemaDeGestion();
    }
    @Override
    public String mostrarPrestamos() {
        return Prestamos.mostrar();
    }

    @Override
    public ListaDobleLibro getLibros() {
        return Libros;
    }

    @Override
    public ListaDoble<Estudiante> getEstudiantes() {
        return Estudiantes;
    }
    
    
    @Override
    public Retorno crearSistemaDeGestion() {
        Libros = new ListaDobleLibro() {};
        Estudiantes = new ListaDoble() {};
        Prestamos = new ListaDoblePrestamo() {};
        LibrosOrdenPrestados = new ListaDobleLibro() {};
        LibrosEliminados = new Pila<Libro>();
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
        LibrosOrdenPrestados.agregarOrdenadoPrestamos(agregar);
        
//        System.out.println(LibrosOrdenPrestados.mostrar());
        return Retorno.ok();
    }
    
//------------------------------------------
// Segunda entrega
    

    @Override
    public Retorno prestarLibro(String ISBN, int numero) {
        if(ISBN == "" || ISBN== null) return Retorno.error1();
        
        Libro existeLibro = Libros.obtenerElemento(new Libro(ISBN));
        if(existeLibro== null)  return Retorno.error2();
        
        if(numero <= 0 || numero >500000) return Retorno.error3();
        
        Estudiante existeEstudiante = Estudiantes.obtenerElemento(new Estudiante(numero));
        if(existeEstudiante==null)return Retorno.error4();
        
        if(existeEstudiante.yaTienePrestamoActivo(ISBN) || existeEstudiante.cantPrestamosActivos() == 8 )return Retorno.error6();
        
        if(existeLibro.getDisponibles() == 0) {
            Prestamo nuevo = new Prestamo(existeEstudiante, existeLibro);
            existeEstudiante.agregarPrestamo(nuevo); 
            return Retorno.error5();
        }
        
        Prestamo nuevo = new Prestamo(existeEstudiante, existeLibro);
        existeEstudiante.agregarPrestamo(nuevo); 
        
        Prestamos.agregarOrdenado(nuevo);
        
        if(LibrosOrdenPrestados.borrarElementoCantPrest(existeLibro)) {
            LibrosOrdenPrestados.agregarOrdenadoPrestamos(existeLibro);
            return Retorno.ok();
        }
        return Retorno.ok();
    }    

    @Override
    public Retorno reservarLibro(String ISBN, int numero) {
        if (ISBN == "" || ISBN == null) return Retorno.error1();

        Libro existeLibro = Libros.obtenerElemento(new Libro(ISBN));
        if (existeLibro == null) return Retorno.error2();
        
        if(numero <=0 || numero >500000) return Retorno.error3();

        Estudiante existeEstudiante = Estudiantes.obtenerElemento(new Estudiante(numero));
        if (existeEstudiante == null) return Retorno.error4();
       
        if(existeLibro.getDisponibles() > 0) return Retorno.error5();
        
        Prestamo nuevoPrestamo = new Prestamo(existeEstudiante, existeLibro);
        existeEstudiante.agregarPrestamo(nuevoPrestamo);
        //System.out.println(existeLibro.getReservas().mostrar());
        return Retorno.ok();        
    }

    @Override
    public Retorno devolverLibro(String ISBN, int numero) {
        if (ISBN == "" || ISBN == null) return Retorno.error1();        

        Libro existeLibro = Libros.obtenerElemento(new Libro(ISBN));
        if (existeLibro == null) return Retorno.error2(); 
        
        if(numero <= 0 || numero > 500000) return Retorno.error3();

        Estudiante existeEstudiante = Estudiantes.obtenerElemento(new Estudiante(numero));
        if (existeEstudiante == null) return Retorno.error4();
        
        return existeEstudiante.devolverPrestamo(existeLibro) ? Retorno.ok() : Retorno.error5();
    }
            
//1.- Si el ISBN es vacío o null.
//2.- Si se realizaron préstamos de dicho libro. 
    @Override
    public Retorno eliminarLibro(String ISBN) {
        if (ISBN == "" || ISBN == null) return Retorno.error1();  
        
        Libro existeLibro = Libros.obtenerElemento(new Libro(ISBN));
        if(existeLibro.getPrestamos().cantElementos() > 0) return Retorno.error2();
        
        LibrosEliminados.apilar(existeLibro);
        Libros.borrarElemento(existeLibro);
        LibrosOrdenPrestados.borrarElemento(existeLibro);        
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
    
//1. Si no existe un estudiante con ese nombre.     
    @Override
    public Retorno listarPrestamos(int numero) {
        Retorno res = new Retorno(Retorno.Resultado.OK);        
        
        if(numero <= 0 || numero > 500000) return Retorno.error1();
        
        Estudiante existeEstudiante = Estudiantes.obtenerElemento(new Estudiante(numero));
        if (existeEstudiante == null) return Retorno.error2();
        
        res.valorString = existeEstudiante.getPrestamos().mostrar();
        return res;
    }

    @Override
    public Retorno librosMasPrestados() {
        Retorno res = new Retorno(Retorno.Resultado.OK);
        res.valorString = LibrosOrdenPrestados.mostrarPrestados();
        return res;
    }

    @Override
    public Retorno deshacerEliminaciones(int n) {
        Retorno res = new Retorno(Retorno.Resultado.OK);
        res.valorString = "";
        
        if (n <= 0) return Retorno.error1();        
        
        if(LibrosEliminados.estaVacia()) res.valorString = "No hay libros eliminados";
        else{
            if(n > LibrosEliminados.cantidadNodos())  n = LibrosEliminados.cantidadNodos();
            Libro libroDevuelto = LibrosEliminados.desapilar();
            Libros.agregarOrdenado(libroDevuelto);
            res.valorString = libroDevuelto.toString();
            for (int i  = 2 ; i<= n ; i++){
                libroDevuelto = LibrosEliminados.desapilar();
                Libros.agregarOrdenado(libroDevuelto);
                res.valorString+= "|" + libroDevuelto.toString();
            }
        }
        
        return res;
    }

    @Override
    public Retorno cantidadPrestamosActivos(String ISBN) {
        
        if(ISBN == null || ISBN == "") return Retorno.error1();
        
        Retorno res = new Retorno(Retorno.Resultado.OK); 
        
        Libro libroBuscado = Libros.obtenerElemento(new Libro(ISBN));
        if(libroBuscado != null) res.valorEntero = libroBuscado.cantPrestamosAct();
        else res.valorEntero = -1;
        return Retorno.ok();
    }

    
    /*
    Se deberán listar la cantidad de libros prestados (activos y finalizados) por cada categoría en orden alfabético, 
    cargando el resultado de los libros en el valor string del retorno.
    */
    @Override
    public Retorno prestamosXCategoría() {
        Retorno res = new Retorno(Retorno.Resultado.OK); 
        res.valorString = Libros.obtenerPrestadosPorCategoria();
        return res;
    }
}
