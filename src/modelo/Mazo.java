package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import modelo.Carta.Palo;
import excepciones.NoHayMasCartasException;

/**
 * Representa un mazo de cartas estándar, compuesto por 52 cartas (13 valores por 4 palos).
 * Este mazo permite mezclar las cartas, solicitar una carta y mostrar el mazo en formato de texto.
 *
 * @author AlvaroValverde
 * @version 1.0
 */
public class Mazo {

	protected List<Carta> cartas; // Lista de cartas en el mazo

	/**
	 * Constructor que inicializa un nuevo mazo de 52 cartas, una para cada combinación de número y palo.
	 * El mazo se llena con cartas de los 4 palos (Trebol, Diamante, Corazones, Picas) y los números
	 * del 1 al 13 (representando As, 2-10, J, Q, K).
	 */
	public Mazo() {
		this.cartas = new ArrayList<Carta>();  // Inicializa la lista de cartas
		//Rellena el mazop con todas las combinaciones de palos y números
		for(Palo palo: Palo.values()) {
			for (int i = 1; i <= 13; i++) {
				Carta carta = new Carta(i,palo); //Crea una nueva carta
				this.cartas.add(carta); //Añade la carta al mazo
			}
		}
	}

	/**
	 * Mezcla las cartas del mazo de forma aleatoria.
	 */
	public void barajar() {
		Collections.shuffle(cartas); // Mezcla las cartas del mazo de forma aleatoria
	}

	/**
	 * Devuelve una representación en cadena del mazo de cartas, mostrando todas las cartas que lo componen.
	 *
	 * @return Una cadena que representa todas las cartas del mazo.
	 */
	@Override
	public String toString() {
		String res="";
		for (Carta carta : cartas) {
			res=res+carta.toString()+ "\n";
		}
		return res;
	}

	/**
	 * Solicita una carta del mazo. Si no hay más cartas en el mazo lanza una excepcion
	 * Si hay cartas disponibles, devuelve la primera carta de la lista y la elimina del mazo.
	 *
	 * @return La carta solicitada.
	 * @throws NoHayMasCartasException Si no quedan cartas en el mazo para ser solicitadas.
	 */
	public Carta solicitarCarta() throws NoHayMasCartasException {
		if (this.cartas.isEmpty()) {
			throw new NoHayMasCartasException(); //Lanza una excepción si no hay más cartas
		}
		Carta carta = this.cartas.getFirst(); //Obtiene la primera carta en el mazo
		this.cartas.removeFirst(); // Elimina la carta del mazo
		return carta; // Devuelve la carta solicitada
	}


}
