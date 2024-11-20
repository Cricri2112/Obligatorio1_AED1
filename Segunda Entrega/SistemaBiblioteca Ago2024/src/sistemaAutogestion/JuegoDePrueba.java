package sistemaAutogestion;

public class JuegoDePrueba {

    public static void main(String[] args) {
        // TODO code application logic here
        Sistema s = new Sistema();
        Prueba p = new Prueba();
        juegodeprueba(s, p);
    }

    public static void juegodeprueba(Sistema s, Prueba p) {

        //2.1. Crear Sistema de Gestión
        p.ver(s.crearSistemaDeGestion().resultado, Retorno.Resultado.OK, "OK: se crea sistema");

        //2.2.Agregar Estudiante
        p.ver(s.agregarEstudiante("Luis", "Suarez", 1).resultado, Retorno.Resultado.OK, "OK: Se agrego a Luis Suarez");
        p.ver(s.agregarEstudiante("Edi", "Cavani", 2).resultado, Retorno.Resultado.OK, "OK: Se agrego a Edi Cavani");
        p.ver(s.agregarEstudiante("Andres", "Lima", 3).resultado, Retorno.Resultado.OK, "OK: Andres Lima ");
        p.ver(s.agregarEstudiante("Darwin", "Nuñez", 4).resultado, Retorno.Resultado.OK, "OK: Se agrego a Darwin Nuñez");
        p.ver(s.agregarEstudiante("Hugo", "Olivera", 5).resultado, Retorno.Resultado.OK, "OK: Se agrego a Hugo Olivera");
        p.ver(s.agregarEstudiante("Carlos", "Soca", 6).resultado, Retorno.Resultado.OK, "OK: Se agrego a Carlos Soca");
        p.ver(s.agregarEstudiante("Diego", "Maradona", 7).resultado, Retorno.Resultado.OK, "OK: Se agrego a Diego Maradona");
        p.ver(s.agregarEstudiante("Leo", "Messi", 8).resultado, Retorno.Resultado.OK, "OK: Se agrego a Leo Messi");
        p.ver(s.agregarEstudiante("Roberto", "Carlos", 9).resultado, Retorno.Resultado.OK, "OK: Se agrego a Roberto Carlos");
        p.ver(s.agregarEstudiante("Diego", "Polenta", 10).resultado, Retorno.Resultado.OK, "OK: se agrego a Diego Polenta");

        p.ver(s.agregarEstudiante("", "Polenta", 11).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: Faltan parametros");
        p.ver(s.agregarEstudiante("Carlos", "", 12).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: Faltan parametros");
        p.ver(s.agregarEstudiante("", "", 12).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: Faltan parametros");
        p.ver(s.agregarEstudiante("Diego", "Aguirre", -1).resultado, Retorno.Resultado.ERROR_2, "ERROR 2: Numero fuera de rango");
        p.ver(s.agregarEstudiante("Luis", "Suarez", 1).resultado, Retorno.Resultado.ERROR_3, "Error 3: Se intento agregar un estudiante existente");

        //2.3.Obtener Estudiante
        p.ver(s.obtenerEstudiante(1).resultado, Retorno.Resultado.OK, "OK: se obtuvo estudiante");
        
        p.ver(s.obtenerEstudiante(-1).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: numero fuera de rango");
        p.ver(s.obtenerEstudiante(0).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: numero fuera de rango");
        p.ver(s.obtenerEstudiante(500001).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: numero fuera de rango");
        p.ver(s.obtenerEstudiante(20).resultado, Retorno.Resultado.ERROR_2, "ERROR 2: el estudiante 20 no existe");

        //2.4. Eliminar Estudiante
        p.ver(s.eliminarEstudiante(10).resultado, Retorno.Resultado.OK, "OK: Se elimina estudiante 10");
        p.ver(s.agregarLibro("Libro 0", "0", "categoria 0", 3).resultado, Retorno.Resultado.OK, "OK: se agrega libro 0");
        p.ver(s.agregarLibro("Libro 1", "1", "categoria 1", 1).resultado, Retorno.Resultado.OK, "OK: se agrega libro 1");
        p.ver(s.prestarLibro("1", 1).resultado, Retorno.Resultado.OK, "OK: se agrega prestamo a estudiante 1");
        
        p.ver(s.eliminarEstudiante(-10).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: Se intenta eliminar estudiante con nro fuera de rango");
        p.ver(s.eliminarEstudiante(0).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: Se intenta eliminar estudiante con nro fuera de rango");
        p.ver(s.eliminarEstudiante(500001).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: Se intenta eliminar estudiante con nro fuera de rango");
        p.ver(s.eliminarEstudiante(20).resultado, Retorno.Resultado.ERROR_2, "ERROR 2: no existe ese estudiante");
        p.ver(s.eliminarEstudiante(1).resultado, Retorno.Resultado.ERROR_3, "ERROR 3: Se intenta eliminar estudiante con prestamos");

        //2.5.Agregar Libro
        p.ver(s.agregarLibro("Libro 15", "15", "categoria 1", 1).resultado, Retorno.Resultado.OK, "OK: se agrega libro 15 con 1 ejemplar");
        p.ver(s.agregarLibro("Libro 2", "2", "categoria 1", 5).resultado, Retorno.Resultado.OK, "OK: se agrega libro 2 con 5 ejemplares");
        p.ver(s.agregarLibro("Libro 3", "3", "categoria 1", 2).resultado, Retorno.Resultado.OK, "OK: se agrega libro 3 con 2 ejemplares");
        p.ver(s.agregarLibro("Libro 4", "4", "categoria 2", 2).resultado, Retorno.Resultado.OK, "OK: se agrega libro 4 con 2 ejemplares");
        p.ver(s.agregarLibro("Libro 5", "5", "categoria 2", 2).resultado, Retorno.Resultado.OK, "OK: se agrega libro 5 con 2 ejemplares");
        p.ver(s.agregarLibro("Libro 6", "6", "categoria 3", 1).resultado, Retorno.Resultado.OK, "OK: se agrega libro 6 con 1 ejemplares");
        p.ver(s.agregarLibro("Libro 7", "7", "categoria 3", 1).resultado, Retorno.Resultado.OK, "OK: se agrega libro 7 con 1 ejemplares");
        p.ver(s.agregarLibro("Libro 8", "8", "categoria 3", 1).resultado, Retorno.Resultado.OK, "OK: se agrega libro 8 con 1 ejemplares");
        p.ver(s.agregarLibro("Libro 9", "9", "categoria 3", 1).resultado, Retorno.Resultado.OK, "OK: se agrega libro 9 con 1 ejemplares");
        p.ver(s.agregarLibro("Libro 10", "10", "categoria 3", 1).resultado, Retorno.Resultado.OK, "OK: se agrega libro 10 con 1 ejemplares");
        p.ver(s.agregarLibro("Libro 200", "ISBN2", "categoria 3", 1).resultado, Retorno.Resultado.OK, "OK: se agrega libro 200 con 1 ejemplares");

        p.ver(s.agregarLibro("", "11", "categoria 3", 1).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: se intenta agregar libro con falta de parametros");
        p.ver(s.agregarLibro(null, "11", "categoria 3", 1).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: se intenta agregar libro con falta de parametros");
        p.ver(s.agregarLibro("Libro11", "", "categoria 3", 1).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: se intenta agregar libro con falta de parametros");
        p.ver(s.agregarLibro("Libro11", null, "categoria 3", 1).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: se intenta agregar libro con falta de parametros");
        p.ver(s.agregarLibro("Libro11", "11", "", 1).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: se intenta agregar libro con falta de parametros");
        p.ver(s.agregarLibro("Libro11", "11", null, 1).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: se intenta agregar libro con falta de parametros");
        p.ver(s.agregarLibro("Libro 10", "10", "categoria 3", 1).resultado, Retorno.Resultado.ERROR_2, "ERROR 2: Se intenta agregar libro existente");
        p.ver(s.agregarLibro("Libro 13", "20", "ategoria 3", -1).resultado, Retorno.Resultado.ERROR_3, "ERROR 3: se intenta agregar libro con cantidad de ejemplares incorrecta");

        //2.6. Prestar Libro
        p.ver(s.prestarLibro("3", 1).resultado, Retorno.Resultado.OK, "OK: se presto Libro 1 ejemplar 1 libro 3");
        p.ver(s.prestarLibro("4", 2).resultado, Retorno.Resultado.OK, "OK: se presto ejemplar 2 libro 3");        
        p.ver(s.prestarLibro("10", 2).resultado, Retorno.Resultado.OK, "OK: se presto Libro 10 ejemplar 1");
        p.ver(s.prestarLibro("15", 1).resultado, Retorno.Resultado.OK, "OK: se presto Libro 1 ejemplar 1 libro 1");
        p.ver(s.prestarLibro("2", 1).resultado, Retorno.Resultado.OK, "OK: se presto Libro 2 ejemplar 1 libro 2");
        p.ver(s.prestarLibro("4", 1).resultado, Retorno.Resultado.OK, "OK: se presto Libro 4 ejemplar 1 libro 4");
        p.ver(s.prestarLibro("5", 1).resultado, Retorno.Resultado.OK, "OK: se presto Libro 5 ejemplar 1 libro 5");
        p.ver(s.prestarLibro("6", 1).resultado, Retorno.Resultado.OK, "OK: se presto Libro 6 ejemplar 1 libro 6");
        p.ver(s.prestarLibro("8", 1).resultado, Retorno.Resultado.OK, "OK: se presto Libro 8 ejemplar 1 libro 8");
        
        p.ver(s.prestarLibro("", 1).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: ISBN vacio");
        p.ver(s.prestarLibro(null, 1).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: ISBN null");
        p.ver(s.prestarLibro("25", 1).resultado, Retorno.Resultado.ERROR_2, "ERROR 2: no existe libro con ese ISBN");
        p.ver(s.prestarLibro("3", -1).resultado, Retorno.Resultado.ERROR_3, "ERROR 3: numero de estudiante fuera de rango");
        p.ver(s.prestarLibro("3", 0).resultado, Retorno.Resultado.ERROR_3, "ERROR 3: numero de estudiante fuera de rango");
        p.ver(s.prestarLibro("3", 500001).resultado, Retorno.Resultado.ERROR_3, "ERROR 3: numero de estudiante fuera de rango");
        p.ver(s.prestarLibro("3", 31).resultado, Retorno.Resultado.ERROR_4, "ERROR 4: no Existe ese estudiante");
        p.ver(s.prestarLibro("10", 6).resultado, Retorno.Resultado.ERROR_5, "ERROR 5: Libro sin stock");
        p.ver(s.prestarLibro("3", 1).resultado, Retorno.Resultado.ERROR_6, "ERROR 6: ya existe ese prestamo para ese estudiante libro");
        p.ver(s.prestarLibro("9", 1).resultado, Retorno.Resultado.ERROR_6, "ERROR 6: ya tient 8 prestamos activos");

        //2.7. Reservar Libro
        p.ver(s.reservarLibro("15", 2).resultado, Retorno.Resultado.OK, "OK: Se reserva libro 15");

        p.ver(s.reservarLibro("", 1).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: ISBN null");
        p.ver(s.reservarLibro(null, 1).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: ISBN null");        
        p.ver(s.reservarLibro("34", 1).resultado, Retorno.Resultado.ERROR_2, "ERROR 2: no existe ese libro");
        p.ver(s.reservarLibro("3", -1).resultado, Retorno.Resultado.ERROR_3, "ERROR 3: numero fuera de rango");
        p.ver(s.reservarLibro("3", 0).resultado, Retorno.Resultado.ERROR_3, "ERROR 3: numero fuera de rango");
        p.ver(s.reservarLibro("3", 500001).resultado, Retorno.Resultado.ERROR_3, "ERROR 3: numero fuera de rango");        
        p.ver(s.reservarLibro("3", 22).resultado, Retorno.Resultado.ERROR_4, "ERROR 4: no existe ese estudiante");        
        p.ver(s.reservarLibro("2", 5).resultado, Retorno.Resultado.ERROR_5, "ERROR 5: ese libro aún tiene stock");

        //2.8.Devolver Libro
        p.ver(s.devolverLibro("1", 1).resultado, Retorno.Resultado.OK, "OK: se devuelve el libro 1, estudiante 1");
        
        p.ver(s.devolverLibro("", 1).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: ISBN vacío");
        p.ver(s.devolverLibro(null, 1).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: ISBN nulo");
        p.ver(s.devolverLibro("100", 1).resultado, Retorno.Resultado.ERROR_2, "ERROR 2: no existe libro con ese ISBN");
        p.ver(s.devolverLibro("1", -1).resultado, Retorno.Resultado.ERROR_3, "ERROR 3: número fuera de rango");
        p.ver(s.devolverLibro("1", 0).resultado, Retorno.Resultado.ERROR_3, "ERROR 3: número fuera de rango");
        p.ver(s.devolverLibro("1", 500001).resultado, Retorno.Resultado.ERROR_3, "ERROR 3: número fuera de rango");
        p.ver(s.devolverLibro("1", 150).resultado, Retorno.Resultado.ERROR_4, "ERROR 4: no existe estudiante con ese número");
        p.ver(s.devolverLibro("7", 1).resultado, Retorno.Resultado.ERROR_5, "ERROR 5: no existe un prestamo activo de ese libro para ese estudiante");

        //2.9 Eliminar Libro
        p.ver(s.eliminarLibro("ISBN2").resultado, Retorno.Resultado.OK, "OK: se elimina el libro ISBN2");
        
        p.ver(s.eliminarLibro("").resultado, Retorno.Resultado.ERROR_1, "ERROR 1: el ISBN es vacío a null");
        p.ver(s.eliminarLibro(null).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: el ISBN es vacío a null");
        p.ver(s.eliminarLibro("1").resultado, Retorno.Resultado.ERROR_2, "ERROR 2: el libro tiene préstamos");

        //3.1 Listar estudiantes
        p.ver(s.listarEstudiantes().resultado, Retorno.Resultado.OK, "OK: se listan los estudiantes");
        System.out.println(s.listarEstudiantes().valorString + "\n");

        //3.2 Listar libros
        p.ver(s.listarLibros().resultado, Retorno.Resultado.OK, "OK: se listan los libros");
        System.out.println(s.listarLibros().valorString + "\n");

        //3.3 Listar libros por categoria
        p.ver(s.listarLibros("categoria 1").resultado, Retorno.Resultado.OK, "OK: se listan los libros de la categoria 1");
        System.out.println(s.listarLibros("categoria 1").valorString + "\n");

        p.ver(s.listarLibros("").resultado, Retorno.Resultado.ERROR_1, "ERROR 1: la categoria es vacia o null");
        p.ver(s.listarLibros(null).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: la categoria es vacia o null");

        //3.4 Listar prestamos de un estudiante
        p.ver(s.listarPrestamos(1).resultado, Retorno.Resultado.OK, "OK: se listan los prestamos del estudiante 1");
        System.out.println(s.listarPrestamos(1).valorString + "\n");

        p.ver(s.listarPrestamos(0).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: el número de estudiante está fuera de rango");
        p.ver(s.listarPrestamos(-1).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: el número de estudiante está fuera de rango");
        p.ver(s.listarPrestamos(500001).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: el número de estudiante está fuera de rango");
        p.ver(s.listarPrestamos(2505).resultado, Retorno.Resultado.ERROR_2, "ERROR 2: no existe un estudiante con ese número");

        //3.5 Libros más prestados
        p.ver(s.librosMasPrestados().resultado, Retorno.Resultado.OK, "OK: se listan el/los libro/s más prestado/s");
        System.out.println(s.librosMasPrestados().valorString + "\n");

        //3.6 Deshacer n eliminaciones
        p.ver(s.deshacerEliminaciones(2).resultado, Retorno.Resultado.OK, "OK: se deshacen las ultimas 2 eliminaciones de libros");
        p.ver(s.deshacerEliminaciones(0).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: n es menor o igual a 0");
        p.ver(s.deshacerEliminaciones(-1).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: n es menor o igual a 0");

        //3.7 Cantidad de préstamos activos
        p.ver(s.cantidadPrestamosActivos("1").resultado, Retorno.Resultado.OK, "OK: se muestra la cantidad de préstamos del libro 1");
        
        p.ver(s.cantidadPrestamosActivos("").resultado, Retorno.Resultado.ERROR_1, "ERROR 1: el IBSN es vacío o null");
        p.ver(s.cantidadPrestamosActivos(null).resultado, Retorno.Resultado.ERROR_1, "ERROR 1: el IBSN es vacío o null");

        //3.8 Ranking de categorías
        p.ver(s.prestamosXCategoría().resultado, Retorno.Resultado.OK, "OK: se muestra el ranking de prestamos por categoria");
        
        p.imprimirResultadosPrueba();
    }
}
