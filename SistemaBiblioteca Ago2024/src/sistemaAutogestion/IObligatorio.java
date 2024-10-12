package sistemaAutogestion;


public interface IObligatorio {
    
    /*
    **************** REGISTROS **************************************
    */
    
    //pre: No existe un sistema     post: Crea las listas (de Estudiante, Libro) que se van a utilizar en el sistema.
    public Retorno crearSistemaDeGestion();
    
     //pre: Se ingresa los datos del estudiante: su nombre, apellido y número identificador único. 
     //     El número es mayor a cero y menor o igual a 500000.
     //post: El estudiante se da de alta y se agrega a la lista Estudiantes
    public Retorno agregarEstudiante(String nombre, String apellido, int numero);
    
     //pre:      post:
    public Retorno obtenerEstudiante(int numero);
     //pre:      post:
    public Retorno eliminarEstudiante(int numero);
    //pre:      post:
    public Retorno agregarLibro(String nombre, String ISBN, String categoría, int cantidad);
    //pre:      post:
    public Retorno eliminarLibro(String ISBN);
   
      /*
    **************** GESTIÓN DE PRESTAMOS **************************************
    */
    
     //pre:      post:
    public Retorno prestarLibro(String ISBN, int numero);
     //pre:      post:
    public Retorno reservarLibro(String ISBN, int numero);
    //pre:      post:
    Retorno devolverLibro(String ISBN, int numero);

     /*
    **************** REPORTES Y CONSULTAS **************************************
    */
    
   //pre:      post:
   public Retorno listarEstudiantes();
   //pre:      post: 
   public Retorno listarLibros();
   //pre:      post: 
   public Retorno listarLibros(String categoria);
   //pre:      post: 
   public Retorno listarPrestamos(int numero);
    //pre:      post: 
   public Retorno librosMasPrestados();
    //pre:      post: 
   public Retorno deshacerEliminaciones(int n);
   //pre:      post:
   public Retorno cantidadPrestamosActivos(String ISBN);
    //pre:      post:
   public Retorno prestamosXCategoría();
}
