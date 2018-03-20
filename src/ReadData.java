
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clasa in care citesc datele din fisierul de intrare
 * @author Beldeanu Calin 
 */
public class ReadData {
	/**
	 * Variabila in care o sa retin numarul de linii citite din fisier
	 */
	public static int n;
	/**
	 * Numarul de coloane in care o sa retin numarul de coloane citite din
	 * fisier
	 */
	public static int m;
	/**
	 * Vectorul in care o sa retinem liniile citite din fisier
	 */
	String[] vectorLinii = new String[n];

	/**
	 * Citeste datele din fisier
	 * 
	 * @param game
	 *            Variabila de tip Game in care o sa retinem datele din fisier
	 */
	public static void Read(Game game) {
		try (BufferedReader reader = new BufferedReader(
				new FileReader("maze.in"))) {

			char[] b;
			int i = 0;
			String CurrentLine = reader.readLine();
			String a = CurrentLine;
			String[] aux = a.split(" ");
			n = Integer.parseInt(aux[0]);
			m = Integer.parseInt(aux[1]);
			game.Map = new CityMap(n + 2, m + 2);
			String[] vectorLinii = new String[n];

			while ((CurrentLine = reader.readLine()) != null) {
				vectorLinii[i] = CurrentLine;
				i++;
			}
			for (int j = 1; j <= n; j++) {
				b = vectorLinii[j - 1].toCharArray();
				for (int k = 1; k <= m; k++) {
					game.Map.Map[j][k] = b[k - 1];
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Cauta in matrice si gaseste coordonatele personajelor
	 * 
	 * @param game
	 *            Variabila de tip Game in care retinem datele campurilor
	 *            personajelor
	 */
	public static void CharacterData(Game game) {
		game.Romeo = new Character();
		game.Julieta = new Character();
		for (int i = 1; i < game.Map.n; i++) {
			for (int k = 1; k < game.Map.m; k++) {
				if (game.Map.Map[i][k] == 'R') {
					game.Romeo.lin = i;
					game.Romeo.col = k;
				}
				if (game.Map.Map[i][k] == 'J') {
					game.Julieta.lin = i;
					game.Julieta.col = k;
				}
			}
		}
	}

}
