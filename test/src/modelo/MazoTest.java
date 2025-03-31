package modelo;

import excepciones.NoHayMasCartasException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class MazoTest {

    /**
     * Test para verificar la correcta creación del mazo.
     */
    @Test
    public void testCreacionMazo() {
        Mazo mazo = new Mazo();
        assertNotNull(mazo);  // Verifica que el mazo no sea null
        assertEquals(52, mazo.cartas.size());  // Verifica que el mazo contenga 52 cartas
    }

    /**
     * Test para verificar el barajado de las cartas.
     */
    @Test
    public void testBarajar() {
        Mazo mazo = new Mazo();
        // Hacemos una copia del mazo antes de barajar
        List<Carta> cartasOriginales = new ArrayList<>(mazo.cartas);

        mazo.barajar();

        // Verificamos que el mazo haya cambiado (aunque no necesariamente de forma predecible)
        // Si las cartas siguen en el mismo orden, la prueba fallará
        assertNotEquals(cartasOriginales, mazo.cartas);  // Verifica que el mazo ha cambiado tras barajar
    }

    /**
     * Test para verificar que se puede solicitar una carta del mazo.
     */
    @Test
    public void testSolicitarCarta() throws NoHayMasCartasException {
        Mazo mazo = new Mazo();

        // Verifica que el mazo tenga 52 cartas al principio
        assertEquals(52, mazo.cartas.size());

        // Solicita una carta
        Carta carta = mazo.solicitarCarta();
        assertNotNull(carta);  // Verifica que la carta solicitada no sea null

        // Verifica que el mazo ahora tenga 51 cartas
        assertEquals(51, mazo.cartas.size());

        // Verifica que la carta solicitada fue la primera en la lista (según cómo está implementado solicitarCarta)
        // Dado que las cartas no están barajadas en este test, podemos verificar que la carta solicitada
        // sea la primera en la lista, es decir, el As de Trebol.
        assertEquals("AS", carta.mostrarNumero());
        assertEquals(Carta.Palo.TREBOl, carta.getPalo());
    }

    /**
     * Test para verificar que se lanza la excepción NoHayMasCartasException cuando no hay más cartas en el mazo.
     */
    @Test
    public void testSolicitarCartaSinCartas() {
        Mazo mazo = new Mazo();

        // Vaciamos el mazo solicitando todas las cartas
        try {
            while (mazo.cartas.size() > 0) {
                mazo.solicitarCarta();
            }
        } catch (NoHayMasCartasException e) {
            fail("No debería haberse lanzado la excepción mientras se solicitan cartas.");
        }

        // Ahora el mazo está vacío, así que solicitar una carta debe lanzar una excepción
        assertThrows(NoHayMasCartasException.class, () -> {
            mazo.solicitarCarta();
        });
    }
}
