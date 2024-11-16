package sistemaAutogestion;

import Tads.ListaDoble;
import dominio.Estudiante;
import dominio.ListaDobleLibro;


public interface IObligatorio {
    
    /*
    **************** REGISTROS **************************************
    */
    public String mostrarPrestamos();
    public ListaDobleLibro getLibros();
    public ListaDoble<Estudiante> getEstudiantes();
    //pre: No existe un sistema     
    //post: Crea las listas (de Estudiante, Libro) que se van a utilizar en el sistema.
    public Retorno crearSistemaDeGestion();
    
    //pre: Se ingresa los datos del estudiante: su nombre, apellido y número identificador único. 
    //     El número es mayor a cero y menor o igual a 500000.
    //post: El estudiante se da de alta y se agrega a la lista Estudiantes
    public Retorno agregarEstudiante(String nombre, String apellido, int numero);
    
    //pre: Se ingresa un número de un estudiante que ya existe.    
    //post: Se devuelve un String con los datos del estudiante  en el siguiente formato: nombre#apellido#numero. Ejemplo: Ana#Perez#123123
    public Retorno obtenerEstudiante(int numero);
    
    //pre: Se recibe un número de estudiante que existe y nunca realizó préstamos
    //post: Elimina el estudiante que tenga el número indicado. 
    public Retorno eliminarEstudiante(int numero);
    
    //pre: Se recibe Libro donde se conoce: su nombre, ISBN (único), su categoría y la cantidad de libros en stock mayor a 0.     
    //post: Se agrega el libro a la lista de libros.
    public Retorno agregarLibro(String nombre, String ISBN, String categoría, int cantidad);
    
    //pre: Se recibe ISBN (no vacío ni en null) de un libro. El libro no tiene préstamos activos.
    //post: Elimina el libro del sistema. 
    public Retorno eliminarLibro(String ISBN);
   
      /*
    **************** GESTIÓN DE PRESTAMOS **************************************
    */
    
    //pre: Se recibe ISBN (no vacío ni en null) de un libro y número de estudiante (entre 1 y 500000), ambos existentes. Existe disponibilidad del libro para prestar. El Estudiante tiene menos de 8 préstamos activos y no tiene un préstamo activo de ese libro.
    //post: Se decrementa numero de disponibles del libro y se suma en 1 la cantidad de préstamos activos en el estudiante. Se registra un nuevo préstamo activo.
    public Retorno prestarLibro(String ISBN, int numero);
    
    //pre: Se recibe ISBN (no vacío ni en null) de un libro y número de estudiante (entre 1 y 500000), ambos existentes. No existe stock disponible en el momento para realizar el préstamo.
    //post: Registra una reserva de un ejemplar de un libro para un estudiante.
    public Retorno reservarLibro(String ISBN, int numero);
    
    //pre: Se recibe ISBN (no vacío ni en null) de un libro y número de estudiante (entre 1 y 500000), ambos existentes. 
    //  
    //post: Registra la devolución de un libro cambiando el estado de Activo (true) a false e 
    //      incrementando el stock disponible de dicho libro en caso de que corresponda.
    //      Si existen reservas para ese libro: se registra la devolución y se realiza el préstamo al primer estudiante que haya realizo
    //      la reserva de ese libro.
    Retorno devolverLibro(String ISBN, int numero);

     /*
    **************** REPORTES Y CONSULTAS **************************************
    */
    
   //pre: La lista de estudiantes existe.
   //post: Lista los estudiantes ordenados por número en Formato: nombre1#apellido1#numero1
   public Retorno listarEstudiantes();
   
   //pre: La lista de libros existe.
   //post: Lista los libros ordenados por ISBN en Formato: nombre1#ISBN1#categoria1
   public Retorno listarLibros();
   
   //pre: Se ingresa una categoría que no es vacía nu null
   //post: Lista los libros con esa categoría ordenados por ISBN en Formato: nombre1#ISBN1#categoria1
   public Retorno listarLibros(String categoria);
   
   //pre: Se recibe un número de estudiante (entre 1 y 500000) que existe.
   //post: Lista todos los préstamos del estudiante ordenados cronológicamente (primero el más reciente) en Formato: nombreLibro1#ISBN1#categoria1#estado
   public Retorno listarPrestamos(int numero);
   
   //pre: Existe la lista de préstamos
   //post: Se listan los libros más prestados ordenado por ISBN en Formato: nombreLibro1#ISBN1#cantidadReservas1. En caso de existir libros con la misma cantidad “máxima de préstamo”, se deberán mostrar todos.
   public Retorno librosMasPrestados(int n);
   
   //pre: Se reciben las cantidades (> 0) de eliminaciones que se quieren deshacer.
   //post: Si existen menos de n eliminaciones, se deshacen todas las realizadas. Se devuelven los libros recuperados en Formato: nombreLibro1#ISBN1
   public Retorno deshacerEliminaciones(int n);
   
   //pre: Se recibe ISBN (no vacío ni en null) de un libro
   //post: Se retorna la cantidad de préstamos activos para se libro
   public Retorno cantidadPrestamosActivos(String ISBN);
   
   //pre: Existe de la lista de préstamos
   //post: Se listan la cantidad de libros reservados por cada categoría en orden alfabético en Formato: categoria1#cantidad1
   public Retorno prestamosXCategoría();
}
