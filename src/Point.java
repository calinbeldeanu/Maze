/**
 * Clasa ajutatoare pentru coada formata in LeeAlgorithm
 * @author Beldeanu Calin 
 */
public class Point {
	/**
	 * Variabila ce retine linia
	 */
	public int lin;
	/**
	 * Variabila ce retine coloana
	 */
	public int col;

	/**
	 * Constructor fara parametrii
	 */
	Point() {
		lin = 0;
		col = 0;
	}

	/**
	 * Constructor ce initializeaza parametrii clasei
	 * 
	 * @param lin
	 *            Parametrul ce initializeaza linia
	 * @param col
	 *            Parametrul ce initializeaza coloana
	 */
	public Point(int lin, int col) {
		this.lin = lin;
		this.col = col;
	}
}
