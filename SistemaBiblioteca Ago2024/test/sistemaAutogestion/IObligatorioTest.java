package sistemaAutogestion;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pesce
 */
public class IObligatorioTest {
    
    private Sistema miSistema;
    
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
        Retorno r = miSistema.obtenerEstudiante(20);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }
    public void testObtenerEstudianteError1() {
        Retorno r1 = miSistema.obtenerEstudiante(0);
        assertEquals(Retorno.error1().resultado, r1.resultado);
        Retorno r2 = miSistema.obtenerEstudiante(-1);
        assertEquals(Retorno.error1().resultado, r2.resultado);
        Retorno r3 = miSistema.obtenerEstudiante(500001);
        assertEquals(Retorno.error1().resultado, r3.resultado);
    }
    public void testObtenerEstudianteError2() {
        Retorno r4 = miSistema.obtenerEstudiante(256576);
        assertEquals(Retorno.error2().resultado, r4.resultado);
    }

    @Test
    public void testEliminarEstudianteOk() {
        Retorno r = miSistema.eliminarEstudiante(20);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }
    public void testEliminarEstudianteError1() {
        Retorno r1 = miSistema.eliminarEstudiante(0);
        assertEquals(Retorno.error1().resultado, r1.resultado);
        Retorno r2 = miSistema.eliminarEstudiante(-1);
        assertEquals(Retorno.error1().resultado, r2.resultado);
        Retorno r3 = miSistema.eliminarEstudiante(500001);
        assertEquals(Retorno.error1().resultado, r3.resultado);
    }
    public void testEliminarEstudianteError2() {
        Retorno r4 = miSistema.eliminarEstudiante(256576);
        assertEquals(Retorno.error2().resultado, r4.resultado);
    }
    public void testEliminarEstudianteError3() {
        // Estudiante con prestamos activos
        Retorno r5 = miSistema.eliminarEstudiante(2);
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
        Retorno r = miSistema.listarLibros("Filosofía");
        assertEquals(Retorno.ok().resultado, r.resultado);
    }
    public void testListarLibrosXCategoriaError1() {
        Retorno r1 = miSistema.listarLibros("");
        assertEquals(Retorno.error1().resultado, r1.resultado);
        Retorno r2 = miSistema.listarLibros(null);
        assertEquals(Retorno.error1().resultado, r2.resultado);
    }
}
