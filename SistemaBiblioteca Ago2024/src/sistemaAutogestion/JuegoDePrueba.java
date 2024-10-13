package sistemaAutogestion;

import dominio.Estudiante;

public class JuegoDePrueba {
    
    public static void main(String[] args){
        
        Sistema sis = new Sistema();
        juegoDePrueba(sis);
    }
    
    public static void juegoDePrueba(Sistema sis){
        //Agrego un estudiante
        sis.agregarEstudiante("Nombre", "Apellido", 1111);
        
        //Muestro listado de estudiantes
        System.out.println(sis.listarEstudiantes().valorString);
        Estudiante e1 = new Estudiante(null, null, 1111);
        System.out.println("Existe: " + sis.Estudiantes.contieneElemento(e1));
        //Busco un estudiante por su número y lo muestro
        System.out.println(sis.obtenerEstudiante(1111).valorString);
        System.out.println("Existe: " + sis.Estudiantes.contieneElemento(e1));
        //Elimino ese estudiante y luego muestro la lista, que se ve vacía
        sis.eliminarEstudiante(1111);
        System.out.println("Lista vacía:" + sis.listarEstudiantes().valorString);
        
        //Agrego 4 estudiantes de forma ordenada
        sis.agregarEstudiante("Nombre1", "Apellido1", 1111);
        sis.agregarEstudiante("Nombre2", "Apellido2", 2222);
        sis.agregarEstudiante("Nombre3", "Apellido3", 3333);
        sis.agregarEstudiante("Nombre4", "Apellido4", 4444);
        //Muestro la lista de estudiantes que se ve ordenado
        System.out.println("Lista agregado ordenado: " + sis.listarEstudiantes().valorString);
        
        //Elimino estos 4 estudiantes
        sis.eliminarEstudiante(1111);
        sis.eliminarEstudiante(2222);
        sis.eliminarEstudiante(3333);
        sis.eliminarEstudiante(4444);
        Estudiante e = new Estudiante(null, null, 2222);
        Estudiante e2 = new Estudiante(null, null, 3333);
        Estudiante e3 = new Estudiante(null, null, 4444);
        //Agrego los 4 estudiantes de forma desordenada
        System.out.println("Existe: " + sis.Estudiantes.contieneElemento(e));
        System.out.println("Existe: " + sis.Estudiantes.contieneElemento(e2));
        System.out.println("Existe: " + sis.Estudiantes.contieneElemento(e3));
        sis.agregarEstudiante("Nombre2", "Apellido2", 2222);
        
        sis.agregarEstudiante("Nombre1", "Apellido1", 1111);
        sis.agregarEstudiante("Nombre4", "Apellido4", 4444);
        sis.agregarEstudiante("Nombre3", "Apellido3", 3333);
        //Muestro la lista de estudiantes y se ve ordenado
        System.out.println("Lista agregado desordenado: " + sis.listarEstudiantes().valorString);
        
        //Listo libros (lista se encuentra vacía)
        System.out.println("Lista de libros vacia: " + sis.listarLibros().valorString);
        
        //Agrego un libro
        sis.agregarLibro("NombreLibro", "ISBN", "Categoria", 150);
        System.out.println("Lista de libros con un elemento: " + sis.listarLibros().valorString);
        
        //Agrego 4 libros        
        sis.agregarLibro("NombreLibro1", "ISBN1", "Categoria", 150);
        sis.agregarLibro("NombreLibro2", "ISBN2", "Categoria2", 250);
        sis.agregarLibro("NombreLibro3", "ISBN3", "Categoria", 350);
        sis.agregarLibro("NombreLibro4", "ISBN4", "Categoria2", 450);
        System.out.println("Lista agregado ordenado: " + sis.listarLibros().valorString);
        sis.Libros.vaciar();
        
        System.out.println("Lista agregado ordenado desp Vaciar: " + sis.listarLibros().valorString);
        //Agrego 4 libros desordenados        
        sis.agregarLibro("NombreLibro2", "ISBN10", "Categoria", 250);
        sis.agregarLibro("NombreLibro1", "ISBN7", "Categoria3", 150);
        sis.agregarLibro("NombreLibro4", "ISBN25", "Categoria", 450);
        sis.agregarLibro("NombreLibro3", "ISBN5", "Categoria4", 350);
        
        System.out.println("Lista agregado desordenado: " + sis.listarLibros().valorString);
        //Libros por categoria
        System.out.println("Libros Categoria" + sis.listarLibros("Categoria").valorString);
        System.out.println("Libros Categoria2" + sis.listarLibros("Categoria2").valorString);
        
    }
}
