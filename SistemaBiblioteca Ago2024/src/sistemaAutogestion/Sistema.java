package sistemaAutogestion;

public class Sistema implements IObligatorio {

    @Override
    public Retorno crearSistemaDeGestion() {
        // Crear listas
        return Retorno.ok();
    }

    @Override
    public Retorno agregarEstudiante(String nombre, String apellido, int numero) {
        return Retorno.noImplementada();
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
