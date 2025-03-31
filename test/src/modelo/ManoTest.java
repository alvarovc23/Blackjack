package modelo;

import excepciones.NoHayMasCartasException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManoTest {

    private Mano mano;
    private Mazo mazo;

    /**
     * Test para verificar el valor de la mano.
     */
    @Test
    public void testValorMano() throws NoHayMasCartasException {
        // Añadimos algunas cartas a la mano
        mano.pedirCarta(mazo); // Asume que el As de Trebol es la primera carta
        mano.pedirCarta(mazo); // Segunda carta

        // Verifica que el valor de la mano esté calculado correctamente.
        // El valor del As es 11 y la segunda carta es 2, por lo que la mano debe tener un valor de 13.
        assertEquals(13, mano.valorMano(), "El valor de la mano no es correcto.");
    }

    /**
     * Test para verificar que finDeJuego devuelve true cuando el valor de la mano es 21 o mayor.
     */
    @Test
    public void testFinDeJuegoConValorMayorOIgual21() throws NoHayMasCartasException {
        // Añadimos cartas para que el valor total sea 21
        mano.pedirCarta(mazo); // Asume que el As de Trebol es la primera carta, que tiene valor 11
        mano.pedirCarta(mazo); // Segunda carta (se asume que es un 10)

        // Verifica que el fin de juego se activa cuando el valor de la mano es 21.
        assertTrue(mano.finDeJuego(), "El juego debería acabar cuando el valor de la mano es 21 o mayor.");
    }

    /**
     * Test para verificar que finDeJuego devuelve false cuando el valor de la mano es menor que 21.
     */
    @Test
    public void testFinDeJuegoConValorMenorQue21() throws NoHayMasCartasException {
        // Añadimos cartas para que el valor total sea menor que 21
        mano.pedirCarta(mazo); // Asume que el As de Trebol es la primera carta, que tiene valor 11
        mano.pedirCarta(mazo); // Segunda carta (se asume que es un 5)

        // Verifica que el fin de juego no se activa cuando el valor de la mano es menor que 21.
        assertFalse(mano.finDeJuego(), "El fin de juego debería ser falso cuando el valor de la mano es menor que 21.");
    }

    /**
     * Test para verificar que se lanza la excepción NoHayMasCartasException cuando no hay más cartas en el mazo.
     */
    @Test
    public void testPedirCartaSinCartas() {
        // Vaciamos el mazo solicitando todas las cartas
        try {
            while (mazo.cartas.size() > 0) {
                mazo.solicitarCarta();
            }
        } catch (NoHayMasCartasException e) {
            fail("No debería haberse lanzado la excepción mientras se solicitaban cartas.");
        }

        // Ahora el mazo está vacío, así que pedir una carta debe lanzar una excepción
        assertThrows(NoHayMasCartasException.class, () -> {
            mano.pedirCarta(mazo);
        }, "Debería lanzar una excepción cuando no hay más cartas en el mazo.");
    }
}