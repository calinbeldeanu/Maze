/**
 * Clasa in care definesc caracteristicile Personajelor , ei fiind reprezentati 
 * de coordonatele din matricea citita din fisier
 * @author Beldeanu Calin
 */

public class Character {
	/**
	 * Coordonata personajului pe linie
	 */
	public int lin;
	/**
	 * Coordonata personajului pe coloana
	 */
	public int col;

	/**
	 * Constructorul in care setam linia si coloana personajului.Variabilele
	 * definite in clasa pentru comoditate
	 * 
	 * @param lin
	 *            valoarea atribuita liniei
	 * @param col
	 *            valoarea atribuita coloanei Paramentrii au aceeasi denumiri ca
	 */
	public Character(int lin, int col) {
		this.lin = lin;
		this.col = col;
	}

	/**
	 * Constructorul default pentru aceasta clasa
	 */
	public Character() {
		this.lin = 0;
		this.col = 0;
	}
}
