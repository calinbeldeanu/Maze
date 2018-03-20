import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Clasa ce scrie in fisier datele
 * @author Beldeanu Calin 
 */
public class WriteData {
	/**
	 * Metoda de scriere a datelor in fisier
	 * @throws IoException
	 */
	public static void writeFile1() throws IOException {
		File fileout = new File("maze.out");
		FileOutputStream file = new FileOutputStream(fileout);

		BufferedWriter buffw = new BufferedWriter(new OutputStreamWriter(file));

		for (int i = 0; i < LeeAlgorithm.fpoints.length; i++) {
			if (LeeAlgorithm.fpoints[i] != null) {
				buffw.write(String.valueOf(LeeAlgorithm.MinTime));
				buffw.write(" ");
				buffw.write(String.valueOf(LeeAlgorithm.fpoints[i].lin));
				buffw.write(" ");
				buffw.write(String.valueOf(LeeAlgorithm.fpoints[i].col));
				buffw.newLine();
			}
		}

		buffw.close();
	}
}
