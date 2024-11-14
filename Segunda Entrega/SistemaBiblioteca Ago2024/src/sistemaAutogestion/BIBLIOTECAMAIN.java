package sistemaAutogestion;

import dominio.Estudiante;
import dominio.Libro;

public class BIBLIOTECAMAIN {

    public static void main(String[] args) {
        // TODO code application logic here
        Sistema s = new Sistema();
        Prueba p = new Prueba();
        juegodeprueba(s, p);
    }

    public static void juegodeprueba(Sistema s, Prueba p) {

        //2.1. Crear Sistema de Gestión
        p.ver(s.crearSistemaDeGestion().resultado, Retorno.Resultado.OK, "se crea sistema");

        //2.2.Agregar Estudiante
        p.ver(s.agregarEstudiante("Luis", "Suarez", 1).resultado, Retorno.Resultado.OK, "OK: Se agrego a Luis Suarez");
        p.ver(s.agregarEstudiante("Edi", "Cavani", 2).resultado, Retorno.Resultado.OK, "OK: Se agrego a Edi Cavani");
        p.ver(s.agregarEstudiante("AndrES", "lIMA", 3).resultado, Retorno.Resultado.OK, "OK: Andres Lima ");
        p.ver(s.agregarEstudiante("Darwin", "Nuñez", 4).resultado, Retorno.Resultado.OK, "OK: Se agrego a Darwin Nuñez");
        p.ver(s.agregarEstudiante("Hugo", "Olivera", 5).resultado, Retorno.Resultado.OK, "OK: Se agrego a Hugo Olivera");
        p.ver(s.agregarEstudiante("Carlos", "Soca", 6).resultado, Retorno.Resultado.OK, "OK: Se agrego a Carlos Soca");
        p.ver(s.agregarEstudiante("Diego", "Maradona", 7).resultado, Retorno.Resultado.OK, "OK: Se agrego a Diego Maradona");
        p.ver(s.agregarEstudiante("Leo", "Messi", 8).resultado, Retorno.Resultado.OK, "OK: Se agrego a Leo Messi");
        p.ver(s.agregarEstudiante("Roberto", "Carlos", 9).resultado, Retorno.Resultado.OK, "OK: Se agrego a Roberto Carlos");
        p.ver(s.agregarEstudiante("Diego", "Polenta", 10).resultado, Retorno.Resultado.OK, "OK: se agrego a Diego Polenta");

        p.ver(s.agregarEstudiante("", "Polenta", 11).resultado, Retorno.Resultado.ERROR_1, "ERROR 1 : Faltan parametros");
        p.ver(s.agregarEstudiante("Carlos", "", 12).resultado, Retorno.Resultado.ERROR_1, "ERROR 1 : Faltan parametros");
        p.ver(s.agregarEstudiante("", "", 12).resultado, Retorno.Resultado.ERROR_1, "ERROR 1 : Faltan parametros");
        p.ver(s.agregarEstudiante("Diego", "Aguirre", -1).resultado, Retorno.Resultado.ERROR_2, "ERROR 2 : Numero fuera de rango");
        p.ver(s.agregarEstudiante("Luis", "Suarez", 1).resultado, Retorno.Resultado.ERROR_3, "Error 3: Se intento agregar un estudiante existente");

//2.3.Obtener Estudiante
        p.ver(s.obtenerEstudiante(1).resultado, Retorno.Resultado.OK, "OK: se obtuvo estudiante");
        p.ver(s.obtenerEstudiante(-1).resultado, Retorno.Resultado.ERROR_1, "Error 1: numero fuera de rango");
        p.ver(s.obtenerEstudiante(20).resultado, Retorno.Resultado.ERROR_2, "Error 2 - el estudiante 20 no existe");

//2.4. Eliminar Estudiante
        p.ver(s.eliminarEstudiante(10).resultado, Retorno.Resultado.OK, "OK: Se elimina estudiante 10");
        p.ver(s.eliminarEstudiante(-10).resultado, Retorno.Resultado.ERROR_1, "Error 1: Se intenta eliminar estudiante con nro fuera de rango)");
        p.ver(s.eliminarEstudiante(20).resultado, Retorno.Resultado.ERROR_2, "Error 2 - no existe ese estudiante");

        p.ver(s.agregarLibro("Libro 0", "0", "categoria 0", 3).resultado, Retorno.Resultado.OK, "Ok se agrega libro 0");
        p.ver(s.agregarLibro("Libro 1", "1", "categoria 1", 1).resultado, Retorno.Resultado.OK, "Ok se agrega libro 1");
        p.ver(s.prestarLibro("1", 1).resultado, Retorno.Resultado.OK, "OK se agrega prestamo a estudiante 1");

        p.ver(s.eliminarEstudiante(1).resultado, Retorno.Resultado.ERROR_3, "Error 3 - Se intenta eliminar estudiante con prestamos");

// 2.5.Agregar Libro
        p.ver(s.agregarLibro("Libro 15", "15", "categoria 1", 1).resultado, Retorno.Resultado.OK, "ok : se agrega libro 15 con 1 ejemplar");
        p.ver(s.agregarLibro("Libro 2", "2", "ategoria 1", 5).resultado, Retorno.Resultado.OK, "ok : se agrega libro 2 con 5 ejemplares");
        p.ver(s.agregarLibro("Libro 3", "3", "ategoria 1", 2).resultado, Retorno.Resultado.OK, "ok : se agrega libro 3 con 2 ejemplares");
        p.ver(s.agregarLibro("Libro 4", "4", "ategoria 2", 2).resultado, Retorno.Resultado.OK, "ok : se agrega libro 4 con 2 ejemplares");
        p.ver(s.agregarLibro("Libro 5", "5", "ategoria 2", 2).resultado, Retorno.Resultado.OK, "ok : se agrega libro 5 con 2 ejemplares");
        p.ver(s.agregarLibro("Libro 6", "6", "ategoria 3", 1).resultado, Retorno.Resultado.OK, "ok : se agrega libro 6 con 1 ejemplares");
        p.ver(s.agregarLibro("Libro 7", "7", "ategoria 3", 1).resultado, Retorno.Resultado.OK, "ok : se agrega libro 7 con 1 ejemplares");
        p.ver(s.agregarLibro("Libro 8", "8", "ategoria 3", 1).resultado, Retorno.Resultado.OK, "ok : se agrega libro 8 con 1 ejemplares");
        p.ver(s.agregarLibro("Libro 9", "9", "ategoria 3", 1).resultado, Retorno.Resultado.OK, "ok : se agrega libro 9 con 1 ejemplares");
        p.ver(s.agregarLibro("Libro 10", "10", "ategoria 3", 1).resultado, Retorno.Resultado.OK, "ok : se agrega libro 10 con 1 ejemplares");

        p.ver(s.agregarLibro("", "11", "ategoria 3", 1).resultado, Retorno.Resultado.ERROR_1, "Error 1 : se intenta agretgar libro con falta de parametros");
        p.ver(s.agregarLibro("Libro 12", "10", "ategoria 3", 1).resultado, Retorno.Resultado.ERROR_2, "Error 2 : Se intenta agregar libro existente");
        p.ver(s.agregarLibro("Libro 13", "20", "ategoria 3", -1).resultado, Retorno.Resultado.ERROR_3, "ok : se intenta agregar libro con cantidad de ejemplares incorrecta");

        //2.6. Prestar Libro
        p.ver(s.prestarLibro("3", 1).resultado, Retorno.Resultado.OK, "OK se presto Libro 1 ejemplar 1 libro 3");
        p.ver(s.prestarLibro("4", 2).resultado, Retorno.Resultado.OK, "OK se presto ejemplar 2 libro 3");
        p.ver(s.prestarLibro("", 1).resultado, Retorno.Resultado.ERROR_1, "Error 1 Isbn vacio");
        p.ver(s.prestarLibro("25", 1).resultado, Retorno.Resultado.ERROR_2, "Error 2 no existe libro con ese isbn");
        p.ver(s.prestarLibro("3", -1).resultado, Retorno.Resultado.ERROR_3, "Error 3 numero de estudiante fuera de rango");
        p.ver(s.prestarLibro("3", 31).resultado, Retorno.Resultado.ERROR_4, "Error 4 no Existe ese estudiante");
        p.ver(s.prestarLibro("10", 2).resultado, Retorno.Resultado.OK, "OK se presto Libro 10 ejemplar 1");

        p.ver(s.prestarLibro("10", 1).resultado, Retorno.Resultado.ERROR_5, "Error 5 Libro sin stock");
        p.ver(s.prestarLibro("3", 1).resultado, Retorno.Resultado.ERROR_6, "Error 6 ya existe ese prestamo para ese estudiante libro");

        p.ver(s.prestarLibro("15", 1).resultado, Retorno.Resultado.OK, "OK se presto Libro 1 ejemplar 1 libro 1");
        p.ver(s.prestarLibro("2", 1).resultado, Retorno.Resultado.OK, "OK se presto Libro 2 ejemplar 1 libro 2");
        p.ver(s.prestarLibro("4", 1).resultado, Retorno.Resultado.OK, "OK se presto Libro 4 ejemplar 1 libro 4");
        p.ver(s.prestarLibro("5", 1).resultado, Retorno.Resultado.OK, "OK se presto Libro 5 ejemplar 1 libro 5");
        p.ver(s.prestarLibro("5", 1).resultado, Retorno.Resultado.ERROR_6, "Error 6 el estudiante ya tiene el libro 5 en prestamo activo");

        p.ver(s.prestarLibro("6", 1).resultado, Retorno.Resultado.OK, "OK se presto Libro 6 ejemplar 1 libro 6");
        p.ver(s.prestarLibro("8", 1).resultado, Retorno.Resultado.OK, "OK se presto Libro 8 ejemplar 1 libro 8");

        p.ver(s.prestarLibro("9", 1).resultado, Retorno.Resultado.ERROR_6, "Error 6 ya tient 8 prestamos activos");

        //2.7. Reservar Libro
        p.ver(s.reservarLibro("15", 2).resultado, Retorno.Resultado.OK, "OK Se reserva libro 15");

        p.ver(s.reservarLibro("", 1).resultado, Retorno.Resultado.ERROR_1, "Error 1 isbn null");
        p.ver(s.reservarLibro("34", 1).resultado, Retorno.Resultado.ERROR_2, "Error 2 no existe ese libro");

        p.ver(s.reservarLibro("3", -1).resultado, Retorno.Resultado.ERROR_3, "Error 3 numero fuera de rango");
        p.ver(s.reservarLibro("3", 22).resultado, Retorno.Resultado.ERROR_4, "Error 4 no existe ese estudiante");

        //2.8.Devolver Libro
        
        p.ver(s.devolverLibro("1", 1).resultado, Retorno.Resultado.OK, "Ok se devuelve el libro 1, estudiante 1");
        p.ver(s.devolverLibro("", 1).resultado, Retorno.Resultado.ERROR_1, "Error 1 ISBN vacío");
        p.ver(s.devolverLibro(null, 1).resultado, Retorno.Resultado.ERROR_1, "Error 1 ISBN nulo");
        p.ver(s.devolverLibro("100", 1).resultado, Retorno.Resultado.ERROR_2, "Error 2 no existe libro con ese ISBN");
        p.ver(s.devolverLibro("1", 0).resultado, Retorno.Resultado.ERROR_3, "Error 3 número de estudiante menor o igual a 0");
        p.ver(s.devolverLibro("1", 500001).resultado, Retorno.Resultado.ERROR_3, "Error 3 número de estudiante mayor a 500000");
        p.ver(s.devolverLibro("1", 150).resultado, Retorno.Resultado.ERROR_4, "Error 4 no existe estudiante con ese número");
        p.ver(s.devolverLibro("7", 1).resultado, Retorno.Resultado.ERROR_5, "Error 5 no existe un prestamo activo de ese libro para ese estudiante");
        
        //2.9 Eliminar Libro






// listados de control
        System.out.println(s.listarEstudiantes().valorString);
        System.out.println(s.listarLibros().valorString);
        System.out.println(s.listarLibros("Categoria 1").valorString);

        p.imprimirResultadosPrueba();
    }
}
