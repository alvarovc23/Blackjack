package modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartaTest {

    /**
     * Test para verificar la creación de una carta con número y palo.
     */
    @Test
    public void testCreacionCarta() {
        Carta carta = new Carta(5, Carta.Palo.CORAZONES);
        assertNotNull(carta);  // Verifica que la carta no sea null
        assertEquals(5, carta.getNumero());  // Verifica que el número de la carta sea 5
        assertEquals(Carta.Palo.CORAZONES, carta.getPalo());  // Verifica que el palo sea CORAZONES
    }

    /**
     * Test para verificar el valor de una carta según el número.
     */
    @Test
    public void testGetValor() {
        Carta cartaAs = new Carta(1, Carta.Palo.PICAS);
        Carta cartaNumerica = new Carta(7, Carta.Palo.DIAMANTE);
        Carta cartaJ = new Carta(11, Carta.Palo.TREBOl);
        Carta cartaQ = new Carta(12, Carta.Palo.CORAZONES);
        Carta cartaK = new Carta(13, Carta.Palo.PICAS);

        // Verifica que el As tenga un valor de 11
        assertEquals(11, cartaAs.getValor());

        // Verifica que las cartas numéricas tengan su valor (en este caso 7)
        assertEquals(7, cartaNumerica.getValor());

        // Verifica que las figuras (J, Q, K) tengan valor 10
        assertEquals(10, cartaJ.getValor());
        assertEquals(10, cartaQ.getValor());
        assertEquals(10, cartaK.getValor());
    }

    /**
     * Test para verificar la representación del número de la carta como texto.
     */
    @Test
    public void testMostrarNumero() {
        Carta cartaAs = new Carta(1, Carta.Palo.TREBOl);
        Carta cartaJ = new Carta(11, Carta.Palo.DIAMANTE);
        Carta cartaQ = new Carta(12, Carta.Palo.CORAZONES);
        Carta cartaK = new Carta(13, Carta.Palo.PICAS);
        Carta carta7 = new Carta(7, Carta.Palo.CORAZONES);

        // Verifica la representación del número como texto
        assertEquals("AS", cartaAs.mostrarNumero());
        assertEquals("J", cartaJ.mostrarNumero());
        assertEquals("Q", cartaQ.mostrarNumero());
        assertEquals("K", cartaK.mostrarNumero());
        assertEquals("7", carta7.mostrarNumero());
    }
}
