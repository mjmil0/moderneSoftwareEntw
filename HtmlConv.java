/** 
 * Diese Programm sucht in einer html-Datei Umlaute und das scharfe S und 
 * ersetzt es durch hierfür vorgesehene Zeichenketten.
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
		//Datei erzeugen für Text nach Umformung der Umlaute und des scharfen S
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
				/*eineZeile = eineZeile.replace("Ä","&Auml;");
				eineZeile = eineZeile.replace("ä","&auml;");
				eineZeile = eineZeile.replace("Ö","&Ouml;");
				eineZeile = eineZeile.replace("ö","&ouml;");
				eineZeile = eineZeile.replace("Ü","&Uuml;");
				eineZeile = eineZeile.replace("ü","&uuml;");
				eineZeile = eineZeile.replace("ß","&szlig;");*/
				
				eineZeile = eineZeile.replace("�", "&auml").replace("�", "&Auml")
				                .replace("�", "&ouml").replace("�", "&Ouml")
				                .replace("�", "&uuml").replace("�", "&Uuml")
				                .replace("�", "&szlig");
				
				System.out.println(eineZeile);
				
				//Text in neue Datei schreiben
				bWriter.write(eineZeile);
	        }
			
	        //Eingabestrom schließen
			bReader.close();
			//Ausgabestrom schließen
			bWriter.close();
			// Eingabestrom schliessen
	        //bReader.close();
		}
	
}