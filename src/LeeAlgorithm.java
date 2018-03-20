/**
 * Clasa in care aplicam algoritmul lui Lee si alte metode
 * @author Beldeanu Calin 
 */

public class LeeAlgorithm {
	/**
	 * Matricea in care aplicam algoritmul lui Lee de la Romeo catre Julieta
	 */
	private static int[][] intMatrix;
	/**
	 * Matricea in care aplicam algoritmul lui Lee de la Julieta catre Romeo
	 */
	private static int[][] intMatrix1;
	/**
	 * Vectorul de cautare al vecinilor pe linii
	 */
	private static final int Ml[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	/**
	 * Vectorul de cautare al vecinilor pe coloane
	 */
	private static final int Mc[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
	/**
	 * Variabila pentru numarul total de vecini
	 */
	private static final int vecini = 8;
	/**
	 * Vector de Puncte care se comporta ca o coada
	 */
	private static Point[] coada;
	/**
	 * Punctul in care se extrag coordonatele caracterului
	 */
	private static Point player;
	/**
	 * Punctul extras din coada
	 */
	private static Point extras;
	/**
	 * Punctul vecin al unui punct extras
	 */
	private static Point vecin;
	/**
	 * Variabila in care se retine numarul minim de pasi
	 */
	public static int MinTime;
	/**
	 * Vectorul de puncte gasite marcate cu numarul minim de pasi
	 */
	public static Point[] fpoints;

	/**
	 * Constructor fara parametrii pentru clasa LeeAlgorithm
	 */
	LeeAlgorithm() {
		intMatrix = null;
		intMatrix1 = null;
		coada = null;

	}

	/**
	 * Metoda ce converteste matricile cu intregi pentru comoditate
	 * 
	 * @param game
	 *            Contine datele necesare aplicarii algoritmului
     * @throws IoException
	 */
	public static void convertMatrix(Game game) {
		intMatrix = new int[game.Map.n][game.Map.m];
		intMatrix1 = new int[game.Map.n][game.Map.m];
		for (int i = 0; i < game.Map.n; i++) {
			for (int k = 0; k < game.Map.m; k++) {
				if (game.Map.Map[i][k] == 'X') {
					intMatrix[i][k] = -1;
					intMatrix1[i][k] = -1;
				} else {
					intMatrix[i][k] = 0;
					intMatrix[i][k] = 0;
				}
			}
		}
	}

	/**
	 * Metoda ce gaseste numarul minim de pasi
	 * 
	 * @param game
	 *            Contine datele necesare determinarii numarului minim de pasi
	 */
	public static void minTime(Game game) {
		if (intMatrix[game.Julieta.lin][game.Julieta.col] % 2 != 0) {
			MinTime = (intMatrix[game.Julieta.lin][game.Julieta.col] + 1) / 2;
		} else {
			MinTime = intMatrix[game.Julieta.lin][game.Julieta.col] / 2 + 1;
		}
	}

	/**
	 * Gaseste punctele din matrice ce sunt marcate cu numar minim de pasi
	 * 
	 * @param game 
	 * 			  Parametru ce contine datele necesare
	 */
	public static void findPoints(Game game) {
		fpoints = new Point[5];
		int contor = 0;
		for (int i = 0; i < game.Map.n; i++) {
			for (int j = 0; j < game.Map.m; j++) {
				if (intMatrix[i][j] != -1 && intMatrix[i][j] == MinTime
						&& intMatrix1[i][j] == MinTime) {
					fpoints[contor] = new Point(i, j);
					contor++;

				}
			}
		}
	}

	/**
	 * Metoda ce gaseste numarul de pasi pentru toate punctele matricii
	 * 
	 * @param game
	 *            Parametrul Game ce contine datele necesare
	 * @param nume
	 *            Parametrul ce activeaza una din ramurile deciziei si are 2
	 *            optiuni "Romeo" sau "Julieta"
	 */
	public static void findMinTime(Game game, String nume) {
		coada = new Point[100000];
		player = new Point();
		vecin = new Point();
		extras = new Point();
		int head = 0;
		int tail = 0;
		if (nume == "Romeo") {
			intMatrix[game.Romeo.lin][game.Romeo.col] = 1;
			player.lin = game.Romeo.lin;
			player.col = game.Romeo.col;
			coada[head] = player;
		} else {
			intMatrix1[game.Julieta.lin][game.Julieta.col] = 1;
			player.lin = game.Julieta.lin;
			player.col = game.Julieta.col;
			coada[head] = player;
		}
		if (nume == "Romeo") {
			while (head <= tail && intMatrix[game.Julieta.lin][game.Julieta.col] == 0) {
				extras = coada[head];
				head++;

				for (int k = 0; k < vecini; k++) {
					vecin.lin = extras.lin + Ml[k];
					vecin.col = extras.col + Mc[k];
					if (intMatrix[vecin.lin][vecin.col] == 0) {
						intMatrix[vecin.lin][vecin.col] = intMatrix[extras.lin][extras.col]
								+ 1;
						tail++;
						coada[tail] = new Point(vecin.lin, vecin.col);

					}

				}

			}
		} else {

			while (head <= tail && intMatrix[game.Romeo.lin][game.Romeo.col] == 0) {
				extras = coada[head];
				head++;
				for (int k = 0; k < vecini; k++) {
					vecin.lin = extras.lin + Ml[k];
					vecin.col = extras.col + Mc[k];
					if (intMatrix1[vecin.lin][vecin.col] == 0) {
						intMatrix1[vecin.lin][vecin.col] = intMatrix1[extras.lin][extras.col]
								+ 1;
						tail++;
						coada[tail] = new Point(vecin.lin, vecin.col);
					}
				}
			}

		}

	}

}
