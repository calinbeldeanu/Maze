import java.io.IOException;

/**
 * Clasa in care se desfasoara jocul
 * @author Beldeanu Calin 
 */
public class Game {
	/**
	 * Variabila de tip CityMap
	 */
	public CityMap Map;
	/**
	 * Variabila de tip Character
	 */
	public Character Romeo;
	/**
	 * Variabila de tip Character
	 */
	public Character Julieta;

	/**
	 * Constructor fara parametrii
	 */
	public Game() {
		this.Map = null;
		this.Romeo = null;
		this.Julieta = null;
	}

	/**
	 * Metoda ce implementeaza toate metodele descrise in celelalte clase
	 * @param game Este parametrul de tip Game care este dat ca parametru metodelor
	 * @throws IoException
	 */
	public static void play(Game game) throws IOException {
		ReadData.Read(game);
		CityMap.fenceMatrix(game);
		ReadData.CharacterData(game);
		LeeAlgorithm.convertMatrix(game);
		LeeAlgorithm.findMinTime(game, "Julieta");
		LeeAlgorithm.findMinTime(game, "Romeo");
		LeeAlgorithm.minTime(game);
		LeeAlgorithm.findPoints(game);
		WriteData.writeFile1();
	}

	/**
	 * 
	 * Implementeaza metoda "play" main
     * @throws IoException
	 */

	public static void main(String[] args) throws IOException {
		Game game=new Game();
		play(game);

	}
}