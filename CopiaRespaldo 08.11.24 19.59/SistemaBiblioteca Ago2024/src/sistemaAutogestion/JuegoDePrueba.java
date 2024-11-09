package sistemaAutogestion;

import dominio.Estudiante;
import dominio.Libro;
import dominio.Prestamo;

public class JuegoDePrueba {
    
    public static void main(String[] args){
        
        Sistema sis = new Sistema();
        juegoDePrueba(sis);
    }
    
    public static void juegoDePrueba(Sistema sis){
        //Agrego un estudiante
        sis.agregarEstudiante("Nombre", "Apellido", 1111);
        sis.agregarEstudiante("Nombre", "Apellido", 1112);
        //Muestro listado de estudiantes
        System.out.println("Lista de estudiantes: " + sis.listarEstudiantes().valorString);
        System.out.println("-----------------------------------------------------------\n");
        
        //Pregunto si existe un estudiante
        Estudiante e1 = new Estudiante(null, null, 1111);
        System.out.println("Existe estudiante 1111: " + sis.Estudiantes.contieneElemento(e1));      
        //Busco un estudiante por su número y lo muestro
        System.out.println("Obtengo estudiante 1111:" + sis.obtenerEstudiante(1111).valorString);
        System.out.println("-----------------------------------------------------------\n");
        
        //Elimino ese estudiante y luego muestro la lista, que se ve vacía
        sis.eliminarEstudiante(1111);
        System.out.println("Elimino el estudiante 1111 muestro la lista: " + sis.listarEstudiantes().valorString);
        System.out.println("-----------------------------------------------------------\n");
        
        //Agrego 3 estudiantes de forma ordenada
        sis.agregarEstudiante("Nombre2", "Apellido2", 2222);
        sis.agregarEstudiante("Nombre3", "Apellido3", 3333);
        sis.agregarEstudiante("Nombre4", "Apellido4", 4444);
        //Muestro la lista de estudiantes que se ve ordenado
        System.out.println("Agrego 3 estudiantes ordenados y muestro lista: " + sis.listarEstudiantes().valorString);
        System.out.println("-----------------------------------------------------------\n");
        
        //Vaciamos la lista
        sis.Estudiantes.vaciar();
        System.out.println("Vaciamos la lista: " + sis.listarEstudiantes().valorString);
        System.out.println("-----------------------------------------------------------\n");
        
        //Agrego 4 estudiantes de forma desordenada
        sis.agregarEstudiante("Nombre7", "Apellido7", 7777);        
        sis.agregarEstudiante("Nombre1", "Apellido1", 1111);
        sis.agregarEstudiante("Nombre4", "Apellido4", 4444);
        sis.agregarEstudiante("Nombre3", "Apellido3", 3333);
        //Muestro la lista de estudiantes y se ve ordenado
        System.out.println("Agrego 4 estudiantes desordenados y muestro lista: " + sis.listarEstudiantes().valorString);
        System.out.println("-----------------------------------------------------------\n");
        
        //Listo libros (lista se encuentra vacía)
        System.out.println("Lista de libros vacia: " + sis.listarLibros().valorString);
        System.out.println("-----------------------------------------------------------\n");
        
        //Agrego un libro
        sis.agregarLibro("NombreLibro", "ISBN", "Categoria", 150);
        System.out.println("Agrego un libro y muestro la lista: " + sis.listarLibros().valorString);
        System.out.println("-----------------------------------------------------------\n");
        
        //Agrego 4 libros        
        sis.agregarLibro("NombreLibro1", "ISBN1", "Filosofia", 150);
        sis.agregarLibro("NombreLibro2", "ISBN2", "Matematica", 250);
        sis.agregarLibro("NombreLibro3", "ISBN3", "Filosofia", 350);
        sis.agregarLibro("NombreLibro4", "ISBN4", "Matematica", 450);
        System.out.println("Agrego 4 libros ordenados y muestro la lista: " + sis.listarLibros().valorString);
        System.out.println("-----------------------------------------------------------\n");
        
        //Vaciamos la lista de libros
        sis.Libros.vaciar();
        System.out.println("Vaciamos la lista: " + sis.listarLibros().valorString);
        System.out.println("-----------------------------------------------------------\n");
        
        
        //Agrego 4 libros desordenados        
        sis.agregarLibro("NombreLibro8", "ISBN8", "Filosofia", 250);
        sis.agregarLibro("NombreLibro7", "ISBN7", "Matematica", 150);
        sis.agregarLibro("NombreLibro2", "ISBN2", "Filosofia", 450);
        sis.agregarLibro("NombreLibro5", "ISBN5", "Arquitectura", 350);
        
        System.out.println("Agrego 4 libros desordenados y muestro la lista: " + sis.listarLibros().valorString);
        System.out.println("-----------------------------------------------------------\n");
        
        //Libros por categoria
        System.out.println("Libros de Filosofia: " + sis.listarLibros("Filosofia").valorString);       
        System.out.println("-----------------------------------------------------------\n");
        
        //Manejar caso de estudiante con préstamo activo
        Libro libro = sis.Libros.obtenerElemento(new Libro(null, "ISBN10", null, 0));
        Estudiante estudiante = sis.Estudiantes.obtenerElemento(e1);
        estudiante.agregarPrestamo(new Prestamo(estudiante, libro));
        System.out.println("Intentar eliminar estudiante con préstamo activo: " + sis.eliminarEstudiante(1111).resultado);
    }
}
