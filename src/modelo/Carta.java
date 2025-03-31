package modelo;

/**
 * Este código representa una carta del blackjack, con un número y un palo.
 * La carta puede tener un número entre 1 y 13, y uno de ls cuatro palos posibles:
 * Trebol, Diamante, Corazones o Picas.
 *
 * @author AlvaroValverde
 * @version 1.0
 */

public class Carta {

	/**
	 * Enum qe representa los palos de la carta
	 * Pueden ser: Trebol, diamante, corazones o picas
	 */
	public enum Palo {
			TREBOl, DIAMANTE ,CORAZONES, PICAS
	}
	
	private int numero; // Número de la carta
	private Palo palo; // Palo de la carta

	/**
	 *  Constructor para crear una carta con un número y un palo
	 *
	 * @param numero El número de la carta
	 * @param palo El palo de la carta
	 */

	public Carta(int numero, Palo palo) {
		if (numero>=1 && numero<=13) {
			this.numero = numero;
			this.palo = palo;
		}
	}

	/**
	 * Obtiene el número de la carta
	 *
	 * @return el número de la carta
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Obtiene el palo de la carta.
	 *
	 * @return El palo de la carta.
	 */
	public Palo getPalo() {
		return palo;
	}

	/**
	 * Calcula el valor de la carta en base a su número.
	 * Las cartas de 2 a 10 tienen su valor igual a su número.
	 * El 1 tiene valor 11, y las cartas 11, 12, 13 tienen valor 10.
	 *
	 * @return El valor de la carta (dependiendo del número).
	 */
	public int getValor() {
		int valor;
		
		if (this.numero>=2 && this.numero<=10) {
			valor=this.numero; // El valor es igual al número de la carta
		} else if (this.numero==1){
			valor=11; //El 1 tiene valor de 11
		} else {
			valor=10; //11, 12 y 13 tienen valor 10
		}

		return valor;
	}

	/**
	 * Muestra el número de la carta en formato de texto.
	 * El 1 se representa como "AS", el 11 como "J", el 12 como "Q" y el 13 como "K".
	 * Los demás números se muestran como están (por ejemplo, "2", "3", etc.).
	 *
	 * @return El número de la carta en formato de texto.
	 */
	public String mostrarNumero() {
        if (this.numero == 1) {
            return "AS"; //El 1 es mostrado como AS
        } else if (this.numero == 11) {
            return "J"; //El 11 es mostrado como "J"
        } else if (this.numero == 12) {
            return "Q"; //El 12 es mostrado como "Q"
        } else if (this.numero == 13) {
            return "K"; //EL 13 es mostrado como "K"
        }
        return "" + this.numero; //Si no es AS, J, Q ni K devuelve el número
    }

	/**
	 * Devuelve una representación en cadena de la carta, mostrando su número y su palo.
	 * Por ejemplo, para el K de Picas podría devolver "[K - PICAS]".
	 *
	 * @return Una cadena que representa la carta en formato [número - palo].
	 */
	@Override
	public String toString() {
		return "["+ mostrarNumero() + " - " + palo + "]"; //Representación en formato [número - palo]
	}

}
