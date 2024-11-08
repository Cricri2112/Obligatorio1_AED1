package sistemaAutogestion;

import dominio.Estudiante;
import dominio.Libro;
import dominio.Prestamo;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pesce
 */
public class IObligatorioTest {

    private IObligatorio miSistema;

    public IObligatorioTest() {
    }

    @Before
    public void setUp() {
        miSistema = new Sistema();
    }

    @Test
    public void testCrearSistemaDeGestion() {
        Retorno r = miSistema.crearSistemaDeGestion();
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testAgregarEstudianteOk() {
        //(String nombre, String apellido, int numero)
        Retorno r = miSistema.agregarEstudiante("Marco", "Aurelio", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        Retorno r2 = miSistema.agregarEstudiante("Fernando", "Aurelio", 1);
        assertEquals(Retorno.ok().resultado, r2.resultado);
        Retorno r3 = miSistema.agregarEstudiante("María", "Correa", 500000);
        assertEquals(Retorno.ok().resultado, r3.resultado);
    }

    @Test
    public void testAgregarEstudianteError1() {
        Retorno r4 = miSistema.agregarEstudiante(null, "Fernandez", 50);
        assertEquals(Retorno.error1().resultado, r4.resultado);
        Retorno r5 = miSistema.agregarEstudiante("Pablo", null, 21);
        assertEquals(Retorno.error1().resultado, r5.resultado);
        Retorno r6 = miSistema.agregarEstudiante("", "Fernandez", 38);
        assertEquals(Retorno.error1().resultado, r6.resultado);
        Retorno r7 = miSistema.agregarEstudiante("Pablo", "", 52);
        assertEquals(Retorno.error1().resultado, r7.resultado);
    }

    @Test
    public void testAgregarEstudianteError2() {
        Retorno r8 = miSistema.agregarEstudiante("Marco", "Aurelio", 0);
        assertEquals(Retorno.error2().resultado, r8.resultado);
        Retorno r9 = miSistema.agregarEstudiante("Fernando", "Aurelio", -1);
        assertEquals(Retorno.error2().resultado, r9.resultado);
        Retorno r10 = miSistema.agregarEstudiante("María", "Correa", 500001);
        assertEquals(Retorno.error2().resultado, r10.resultado);
    }

    @Test
    public void testAgregarEstudianteError3() {
        miSistema.agregarEstudiante("Marco2", "Aurelio2", 20);
        Retorno r11 = miSistema.agregarEstudiante("Marco2", "Aurelio2", 20);
        assertEquals(Retorno.error3().resultado, r11.resultado);
    }

    @Test
    public void testObtenerEstudianteOk() {
        miSistema.agregarEstudiante("Marco2", "Aurelio2", 20);
        Retorno r = miSistema.obtenerEstudiante(20);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testObtenerEstudianteError1() {
        Retorno r1 = miSistema.obtenerEstudiante(0);
        assertEquals(Retorno.error1().resultado, r1.resultado);
        Retorno r2 = miSistema.obtenerEstudiante(-1);
        assertEquals(Retorno.error1().resultado, r2.resultado);
        Retorno r3 = miSistema.obtenerEstudiante(500001);
        assertEquals(Retorno.error1().resultado, r3.resultado);
    }

    @Test
    public void testObtenerEstudianteError2() {
        Retorno r4 = miSistema.obtenerEstudiante(256576);
        assertEquals(Retorno.error2().resultado, r4.resultado);
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
        Retorno r4 = miSistema.eliminarEstudiante(256576);
        assertEquals(Retorno.error2().resultado, r4.resultado);
    }

    @Test
    public void testEliminarEstudianteError3() {
        Sistema sistema = new Sistema();
        sistema.agregarEstudiante("Nombre", "Apellido", 1111);
        sistema.agregarLibro("NombreLibro", "ISBN", "Categoria", 150);
        Estudiante estudiante = (Estudiante) sistema.Estudiantes.obtenerElemento(new Estudiante(1111));
        Libro libro = (Libro) sistema.Libros.obtenerElemento(new Libro("ISBN"));
        estudiante.agregarPrestamo(libro);
        Retorno r5 = sistema.eliminarEstudiante(1111);
        assertEquals(Retorno.error3().resultado, r5.resultado);
    }

    @Test
    public void testAgregarLibroOk() {
        Retorno r = miSistema.agregarLibro("Reflexiones", "978-3-16-148410-0", "Filosofía", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    public void testAgregarLibroError1() {
        Retorno r1 = miSistema.agregarLibro(null, "978-3-16-148410-0", "Filosofía", 10);
        assertEquals(Retorno.error1().resultado, r1.resultado);
        Retorno r2 = miSistema.agregarLibro("", "978-3-16-148410-0", "Filosofía", 10);
        assertEquals(Retorno.error1().resultado, r2.resultado);
        Retorno r3 = miSistema.agregarLibro("Reflexiones", null, "Filosofía", 10);
        assertEquals(Retorno.error1().resultado, r3.resultado);
        Retorno r4 = miSistema.agregarLibro("Reflexiones", "", "Filosofía", 10);
        assertEquals(Retorno.error1().resultado, r4.resultado);
        Retorno r5 = miSistema.agregarLibro("Reflexiones", "978-3-16-148410-0", null, 10);
        assertEquals(Retorno.error1().resultado, r5.resultado);
        Retorno r6 = miSistema.agregarLibro("Reflexiones", "978-3-16-148410-0", "", 10);
        assertEquals(Retorno.error1().resultado, r6.resultado);

        // El tipo de dato int no puede ser null
        //    Retorno r7 = miSistema.agregarLibro("Reflexiones", "978-3-16-148410-0", "Filosofía", null);
        //    assertEquals(Retorno.error1().resultado, r7.resultado);
    }

    public void testAgregarLibroError2() {
        Retorno r8 = miSistema.agregarLibro("Reflexiones", "978-3-16-148410-0", "Filosofía", 10);
        assertEquals(Retorno.error2().resultado, r8.resultado);
    }

    public void testAgregarLibroError3() {
        Retorno r9 = miSistema.agregarLibro("Reflexiones", "978-3-16-148410-0", "Filosofía", 0);
        assertEquals(Retorno.error3().resultado, r9.resultado);
        Retorno r10 = miSistema.agregarLibro("Reflexiones", "978-3-16-148410-0", "Filosofía", -1);
        assertEquals(Retorno.error3().resultado, r10.resultado);
    }

    @Test
    public void testListarEstudiantes() {
        Retorno r = miSistema.listarEstudiantes();
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testListarLibros() {
        Retorno r = miSistema.listarLibros();
        assertEquals(Retorno.ok().resultado, r.resultado);
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

    @Test
    public void testPrestarLibroOk() {
        miSistema.agregarEstudiante("NomreEstudiante1", "ApellidoEstudiante1", 1000);
        miSistema.agregarLibro("NombreLibro2", "ISBN2", "Categoria1", 250);
        Retorno ret = miSistema.prestarLibro("ISBN2", 1000);
        assertEquals(Retorno.ok().resultado, ret.resultado);
    }

    //
    @Test
    public void testPrestarLibroError1() {
        miSistema.agregarEstudiante("NomreEstudiante1", "ApellidoEstudiante1", 1000);
        miSistema.agregarLibro("NombreLibro2", "ISBN2", "Categoria1", 250);
        Retorno r1 = miSistema.prestarLibro("", 1000);
        assertEquals(Retorno.error1().resultado, r1.resultado);
        Retorno r2 = miSistema.prestarLibro(null, 1000);
        assertEquals(Retorno.error1().resultado, r2.resultado);
    }

    @Test
    public void testPrestarLibroError2() {
        miSistema.agregarEstudiante("NomreEstudiante1", "ApellidoEstudiante1", 1000);
        miSistema.agregarLibro("NombreLibro2", "ISBN2", "Categoria1", 250);
        Retorno r4 = miSistema.prestarLibro("ISBN1", 1000);
        assertEquals(Retorno.error2().resultado, r4.resultado);
    }

    @Test
    public void testPrestarLibroError3() {
        miSistema.agregarEstudiante("NomreEstudiante1", "ApellidoEstudiante1", 1000);
        miSistema.agregarLibro("NombreLibro2", "ISBN2", "Categoria1", 250);
        Retorno r5 = miSistema.prestarLibro("ISBN2", 100);
        assertEquals(Retorno.error3().resultado, r5.resultado);
    }

    @Test
    public void testPrestarLibroError4() {
        miSistema.agregarEstudiante("NomreEstudiante1", "ApellidoEstudiante1", 1000);
        miSistema.agregarEstudiante("NomreEstudiante2", "ApellidoEstudiante2", 1001);
        miSistema.agregarLibro("NombreLibro2", "ISBN2", "Categoria1", 1);
        miSistema.prestarLibro("ISBN2", 1000);
        Retorno r6 = miSistema.prestarLibro("ISBN2", 1001);
        assertEquals(Retorno.error4().resultado, r6.resultado);
    }

    //5. Si ya existe un préstamo activo de ese libro para ese estudiante o si ya tiene 8 
//préstamos activos. 
    @Test
    public void testPrestarLibroError5() {
        miSistema.agregarEstudiante("NomreEstudiante1", "ApellidoEstudiante1", 1000);
        miSistema.agregarEstudiante("NomreEstudiante2", "ApellidoEstudiante2", 1001);
        miSistema.agregarLibro("NombreLibro2", "ISBN2", "Categoria1", 2);
        miSistema.prestarLibro("ISBN2", 1000);
        Retorno r7 = miSistema.prestarLibro("ISBN2", 1000);
        assertEquals(Retorno.error5().resultado, r7.resultado);

        miSistema.agregarLibro("NombreLibro3", "ISBN3", "Categoria1", 100);
        miSistema.agregarLibro("NombreLibro4", "ISBN4", "Categoria2", 150);
        miSistema.agregarLibro("NombreLibro5", "ISBN5", "Categoria1", 200);
        miSistema.agregarLibro("NombreLibro6", "ISBN6", "Categoria2", 160);
        miSistema.agregarLibro("NombreLibro7", "ISBN7", "Categoria1", 12);
        miSistema.agregarLibro("NombreLibro8", "ISBN8", "Categoria3", 16);
        miSistema.agregarLibro("NombreLibro9", "ISBN9", "Categoria4", 19);
        miSistema.agregarLibro("NombreLibro10", "ISBN10", "Categoria1", 20);
        miSistema.agregarLibro("NombreLibro11", "ISBN11", "Categoria1", 20);
        miSistema.prestarLibro("ISBN3", 1001);
        miSistema.prestarLibro("ISBN4", 1001);
        miSistema.prestarLibro("ISBN5", 1001);
        miSistema.prestarLibro("ISBN6", 1001);
        miSistema.prestarLibro("ISBN7", 1001);
        miSistema.prestarLibro("ISBN8", 1001);
        miSistema.prestarLibro("ISBN9", 1001);
        miSistema.prestarLibro("ISBN10", 1001);
        Retorno r8 = miSistema.prestarLibro("ISBN11", 1001);
        assertEquals(Retorno.error5().resultado, r8.resultado);

    }

}
