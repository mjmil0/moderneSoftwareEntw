/** 
 * Diese Programm sucht in einer html-Datei Umlaute und das scharfe S und 
 * ersetzt es durch hierfÃ¼r vorgesehene Zeichenketten.
 * @author Anna Symanek
 * @version 1.0, 29.10.2021
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileOutputStream;


public class HtmlConv{
	public static void main (String[] args) throws IOException {
		
		//Dateiname der einzulesenden Datei
		String dateiName = ("datei1702_vor.html");
		//Datei erzeugen fÃ¼r Text nach Umformung der Umlaute und des scharfen S
		File neueDatei = dateiErzeugen("datei1702_nach.html");
		//Text in neue Datei schreiben
		//schreibeTextInDatei(neueDatei);
		schreibeTextInDatei("datei1702_vor.html", "datei1702_nach.html");

	}
	
	private static File dateiErzeugen(String dateiName) throws IOException {
		File neueDatei = new File (dateiName);
		neueDatei.createNewFile();
		neueDatei.setWritable(true);
		return neueDatei;
	}
	
	public static void schreibeTextInDatei(String quellDatei, String zielDatei) throws IOException {
	        // Drei Eingabestroeme erzeugen und mit der Datei verbinden:
	        FileInputStream fiStream = new FileInputStream(quellDatei);
	        InputStreamReader isReader = new InputStreamReader(fiStream);
	        BufferedReader bReader = new BufferedReader(isReader);
			BufferedWriter bWriter = new BufferedWriter (new FileWriter (zielDatei));
	      
	        // Alle Zeilen aus der Datei lesen, umformen und in neue Datei schreiben
			String eineZeile;
	        while (bReader.ready()) {
	            eineZeile = bReader.readLine();
				/*eineZeile = eineZeile.replace("Ã„","&Auml;");
				eineZeile = eineZeile.replace("Ã¤","&auml;");
				eineZeile = eineZeile.replace("Ã–","&Ouml;");
				eineZeile = eineZeile.replace("Ã¶","&ouml;");
				eineZeile = eineZeile.replace("Ãœ","&Uuml;");
				eineZeile = eineZeile.replace("Ã¼","&uuml;");
				eineZeile = eineZeile.replace("ÃŸ","&szlig;");*/
				
				eineZeile = eineZeile.replace("ä", "&auml").replace("Ä", "&Auml")
				                .replace("ö", "&ouml").replace("Ö", "&Ouml")
				                .replace("ü", "&uuml").replace("Ü", "&Uuml")
				                .replace("ß", "&szlig");
				
				System.out.println(eineZeile);
				
				//Text in neue Datei schreiben
				bWriter.write(eineZeile);
	        }
			
	        //Eingabestrom schlieÃŸen
			bReader.close();
			//Ausgabestrom schlieÃŸen
			bWriter.close();
			// Eingabestrom schliessen
	        //bReader.close();
		}
	
}