/**
 * Clasa in care definesc caracteristicile hartii
 * @author Beldeanu Calin 
 */
public class CityMap {
	/**
	 * Matricea de tip char in care se introduc datele din fisierul de intrare
	 */
	public char Map[][];
	/**
	 * Numarul de linii al matricii
	 */
	public int n;
	/**
	 * Numarul de coloane al matricii
	 */
	public int m;

	/**
	 * Constructor cu parametrii pentru clasa
	 * 
	 * @param n
	 *            valoarea atribuita numarului de linii
	 * @param m
	 *            valoarea atribuita numarului de coloane
	 * 
	 */
	public CityMap(int n, int m) {
		this.n = n;
		this.m = m;
		this.Map = new char[n][m];
	}

	/**
	 * Constructorul default al clasei
	 */
	public CityMap() {
		this.n = 0;
		this.m = 0;
		this.Map = null;
	}
	
	/**
	 * Metoda ce bordeaza matricea citita din fisier
	 * @param game este de tip Game 
	 */
	public static void fenceMatrix(Game game) {
		for (int i = 0; i < game.Map.m; i++) {
			game.Map.Map[0][i] = 'X';
			game.Map.Map[game.Map.n - 1][i] = 'X';
		}
		for (int j = 0; j < game.Map.n; j++) {
			game.Map.Map[j][0] = 'X';
			game.Map.Map[j][game.Map.m - 1] = 'X';

		}
	}

}
