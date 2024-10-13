package sistemaAutogestion;

import dominio.Estudiante;
import dominio.Libro;
import dominio.Prestamo;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IObligatorioTest2 {

    private IObligatorio miSistema;

    public IObligatorioTest2() {
        miSistema = new Sistema();
    }

    @Before
    public void setUp() {
        miSistema = new Sistema();
        miSistema.crearSistemaDeGestion();
    }
    
    @Test
    public void testCrearSistemaDeGestion() {
        Retorno r = miSistema.crearSistemaDeGestion();
        assertEquals(Retorno.ok().resultado, r.resultado);
    }
    

    @Test
    public void testAgregarEstudianteOk() {
        Retorno ret = miSistema.agregarEstudiante("Nombre", "Apellido", 1111);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
    }

    @Test
    public void testAgregarEstudianteError1() {
        Retorno ret = miSistema.agregarEstudiante("", "Apellido", 1111);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarEstudiante(null, "Apellido", 1111);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarEstudiante("Nombre", "", 1111);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarEstudiante("Nombre", null, 1111);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarEstudiante("", "", 1111);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarEstudiante(null, null, 1111);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);
    }

    @Test
    public void testAgregarEstudianteError2() {
        Retorno ret = miSistema.agregarEstudiante("Nombre", "Apellido", 0);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);

        ret = miSistema.agregarEstudiante("Nombre", "Apellido", -5);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);

        ret = miSistema.agregarEstudiante("Nombre", "Apellido", 500001);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);

        ret = miSistema.agregarEstudiante("Nombre", "Apellido", 500050);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);
    }

    @Test
    public void testAgregarEstudianteError3() {
        miSistema.agregarEstudiante("Nombre", "Apellido", 1111);
        Retorno ret = miSistema.agregarEstudiante("Nombre", "Apellido", 1111);
        assertEquals(Retorno.Resultado.ERROR_3, ret.resultado);
    }

    @Test
    public void testObtenerEstudianteOk() {
        miSistema.agregarEstudiante("Nombre", "Apellido", 1111);
        Retorno ret = miSistema.obtenerEstudiante(1111);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("Nombre#Apellido#1111", ret.valorString);
    }

    @Test
    public void testObtenerEstudianteError1() {
        Retorno ret = miSistema.obtenerEstudiante(-2);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.obtenerEstudiante(0);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.obtenerEstudiante(500001);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.obtenerEstudiante(500500);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);
    }

    @Test
    public void testObtenerEstudianteError2() {
        Retorno ret = miSistema.obtenerEstudiante(1111);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);

        ret = miSistema.obtenerEstudiante(1);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);

        ret = miSistema.obtenerEstudiante(500000);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);
    }
    
    @Test
    public void testEliminarEstudianteOk() {
        miSistema.agregarEstudiante("Nombre", "Apellido", 1111);
        Retorno r = miSistema.eliminarEstudiante(1111);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }
    @Test
    public void testEliminarEstudianteError1() {
        Retorno r1 = miSistema.eliminarEstudiante(0);
        assertEquals(Retorno.error1().resultado, r1.resultado);
        Retorno r2 = miSistema.eliminarEstudiante(-1);
        assertEquals(Retorno.error1().resultado, r2.resultado);
        Retorno r3 = miSistema.eliminarEstudiante(500001);
        assertEquals(Retorno.error1().resultado, r3.resultado);
    }
    @Test
    public void testEliminarEstudianteError2() {
        miSistema.agregarEstudiante("Nombre", "Apellido", 1110);
        miSistema.agregarEstudiante("Nombre2", "Apellido2", 256575);
        miSistema.agregarEstudiante("Nombre3", "Apellido3", 256577);
        Retorno r4 = miSistema.eliminarEstudiante(256576);
        assertEquals(Retorno.error2().resultado, r4.resultado);
    }
    @Test
    public void testEliminarEstudianteError3() {       
        Sistema sistema = new Sistema();
        sistema.agregarEstudiante("Nombre", "Apellido", 1111);
        sistema.agregarLibro("NombreLibro", "ISBN", "Categoria", 150);
        Estudiante estudiante = (Estudiante) sistema.Estudiantes.obtenerElemento(new Estudiante(null, null, 1111));
        Libro libro = (Libro) sistema.Libros.obtenerElemento(new Libro(null, "ISBN1", null, 0));
        estudiante.agregarPrestamo(new Prestamo(estudiante, libro));
        Retorno r5 = sistema.eliminarEstudiante(1111);
        assertEquals(Retorno.error3().resultado, r5.resultado);
    }

  
    @Test
    public void testListarEstudiantesVacio() {
        Retorno ret = miSistema.listarEstudiantes();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("", ret.valorString);
    }

    @Test
    public void testListarEstudiantesUnElemento() {
        miSistema.agregarEstudiante("Nombre", "Apellido", 1111);
        Retorno ret = miSistema.listarEstudiantes();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("Nombre#Apellido#1111", ret.valorString);
    }

    @Test
    public void testListarEstudiantesIngresoOrdenado() {
        miSistema.agregarEstudiante("Nombre1", "Apellido1", 1111);
        miSistema.agregarEstudiante("Nombre2", "Apellido2", 2222);
        miSistema.agregarEstudiante("Nombre3", "Apellido3", 3333);
        miSistema.agregarEstudiante("Nombre4", "Apellido4", 4444);
        Retorno ret = miSistema.listarEstudiantes();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("Nombre1#Apellido1#1111|Nombre2#Apellido2#2222|Nombre3#Apellido3#3333|Nombre4#Apellido4#4444", ret.valorString);
    }

    @Test
    public void testListarEstudiantesIngresoNoOrdenado() {
        miSistema.agregarEstudiante("Nombre2", "Apellido2", 2222);
        miSistema.agregarEstudiante("Nombre1", "Apellido1", 1111);
        miSistema.agregarEstudiante("Nombre4", "Apellido4", 4444);
        miSistema.agregarEstudiante("Nombre3", "Apellido3", 3333);
        Retorno ret = miSistema.listarEstudiantes();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("Nombre1#Apellido1#1111|Nombre2#Apellido2#2222|Nombre3#Apellido3#3333|Nombre4#Apellido4#4444", ret.valorString);
    }


    @Test
    public void testListarLibrosVacio() {
        Retorno ret = miSistema.listarLibros();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals(ret.valorString, "");
    }

    @Test
    public void testListarLibrosUnElemento() {
        miSistema.agregarLibro("NombreLibro", "ISBN", "Categoria", 150);
        Retorno ret = miSistema.listarLibros();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("NombreLibro#ISBN#Categoria", ret.valorString);
    }

    @Test
    public void testListarLibrosIngresoOrdenado() {
        miSistema.agregarLibro("NombreLibro1", "ISBN1", "Categoria", 150);
        miSistema.agregarLibro("NombreLibro2", "ISBN2", "Categoria", 250);
        miSistema.agregarLibro("NombreLibro3", "ISBN3", "Categoria", 350);
        miSistema.agregarLibro("NombreLibro4", "ISBN4", "Categoria", 450);
        Retorno ret = miSistema.listarLibros();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("NombreLibro1#ISBN1#Categoria|NombreLibro2#ISBN2#Categoria|NombreLibro3#ISBN3#Categoria|NombreLibro4#ISBN4#Categoria", ret.valorString);
    }

    @Test
    public void testListarLibrosIngresoNoOrdenado() {
        miSistema.agregarLibro("NombreLibro2", "ISBN2", "Categoria", 250);
        miSistema.agregarLibro("NombreLibro1", "ISBN1", "Categoria", 150);
        miSistema.agregarLibro("NombreLibro4", "ISBN4", "Categoria", 450);
        miSistema.agregarLibro("NombreLibro3", "ISBN3", "Categoria", 350);
        Retorno ret = miSistema.listarLibros();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("NombreLibro1#ISBN1#Categoria|NombreLibro2#ISBN2#Categoria|NombreLibro3#ISBN3#Categoria|NombreLibro4#ISBN4#Categoria", ret.valorString);
    }
    
    @Test
    public void testListarLibrosXCategoriaOk() {
        miSistema.agregarLibro("NombreLibro2", "ISBN2", "Categoria1", 250);
        miSistema.agregarLibro("NombreLibro1", "ISBN1", "Categoria2", 150);
        miSistema.agregarLibro("NombreLibro4", "ISBN4", "Categoria1", 450);
        miSistema.agregarLibro("NombreLibro3", "ISBN3", "Categoria3", 350);
        Retorno ret = miSistema.listarLibros("Categoria1");
        assertEquals(Retorno.ok().resultado, ret.resultado);
        assertEquals("NombreLibro2#ISBN2#Categoria1|NombreLibro4#ISBN4#Categoria1", ret.valorString);
    }
    @Test
    public void testListarLibrosXCategoriaError1() {
        Retorno r1 = miSistema.listarLibros("");
        assertEquals(Retorno.error1().resultado, r1.resultado);
        Retorno r2 = miSistema.listarLibros(null);
        assertEquals(Retorno.error1().resultado, r2.resultado);
    }    
    

}