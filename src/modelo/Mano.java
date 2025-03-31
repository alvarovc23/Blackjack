package modelo;

import java.util.ArrayList;

import excepciones.NoHayMasCartasException;

/**
 * Representa una mano de cartas, que es una extensión de la clase Mazo.
 * Esta clase permite gestionar las cartas de una mano, calcular su valor,
 * y verificar si se ha alcanzado o superado el valor máximo (21) del blackjack.
 *
 * @author AlvaroValverde
 * @version 1.0
 */

public class Mano extends Mazo {

	/**
	 * Constructor que inicializa una nueva mano con una lista vacía de cartas.
	 * Al heredar de la clase Mazo, se puede gestionar el conjunto de cartas
	 * de la mano a través de la lista "cartas".
	 */
	public Mano() {
		this.cartas = new ArrayList<Carta>(); // Inicializa una lista vacía de cartas
	}

	/**
	 * Calcula el valor total de la mano sumando los valores de todas las cartas.
	 *
	 * @return El valor total de la mano.
	 */
	public int valorMano() {
		int valor=0;

		// Suma el valor de cada carta en la mano
		for (Carta carta : this.cartas) {
			valor=valor+carta.getValor();
		}
		return valor;
	}

	/**
	 * Verifica si la mano ha alcanzado o superado el valor de 21.
	 * Si el valor total de la mano es mayor o igual a 21, se considera
	 * que se ha alcanzado el fin del juego.
	 *
	 * @return true si el valor de la mano es mayor o igual a 21, de lo contrario false.
	 */
	public boolean finDeJuego() {
		if (this.valorMano()>=21) {
			return true; // Si el valor es 21 o más, fin de juego
		}
		return false;
	}

	/**
	 * Devuelve una representación en cadena de la mano, incluyendo el valor total
	 * de la mano y las cartas que la componen.
	 *
	 * @return Una cadena que representa la mano con su valor y cartas.
	 */
	@Override
	public String toString() {
		String res="Valor de la Mano: "+this.valorMano()+"\n"; //Valor total de la mano
		res=res+super.toString(); // Añade la representación de las cartas de la mano
		return res;
	}

	/**
	 * Solicita una carta del mazo y la añade a la mano. Si no hay más cartas en el mazo,
	 * se lanzará una excepción.
	 *
	 * @param m El mazo del cual se solicitará la carta.
	 * @throws NoHayMasCartasException Si no hay más cartas en el mazo para repartir.
	 */
	public void pedirCarta(Mazo m) throws NoHayMasCartasException {
		Carta c = m.solicitarCarta(); //Solicita una carta al mazo
		this.cartas.add(c); //Añade la carta solicitada al mazo
	}
	
	
	
}
