import java.io.FileReader;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * A static class that provides random paragraphs for the user to type out in order to test how fast they are able to type
 *    
 * @author Peter Apazidis
 */
public class ParagraphGenerator {

	private static final int NUM_PARAGRAPHS = 6;
	private static int randNum = (int)((Math.random() + 0.25) * 4);
	
	
	public static String generate_paragraph() {
		String paragraph = "";
		try {
			String cd_abs_path = System.getProperty("user.dir");
			Path paragraphs_dir = Paths.get(cd_abs_path, "/resources/paragraph_files/paragraph" + randNum);
			FileReader paragraph_reader = new FileReader(paragraphs_dir.toString());
			BufferedReader br = new BufferedReader(paragraph_reader);
			String line = br.readLine();
			
			while(line != null) {
				paragraph = paragraph + line;
				line = br.readLine();
			}
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		return paragraph;
	}
	
	
	
}
