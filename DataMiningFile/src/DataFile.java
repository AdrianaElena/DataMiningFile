import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DataFile {
	
	private List<String> data = new ArrayList<String>();
	private List<String> lista = new ArrayList<String>();
	private int nrTranzactii;
	private String inFilename;
	private String outFilename;

	public DataFile(String inFilename, String outFilename) {
		
		this.inFilename = inFilename;
		this.outFilename = outFilename;
		nrTranzactii = 0;
	}

	public void createListAttributes() {

		String[] words;
		String line;
		Scanner in;
		try {
			in = new Scanner(new File(inFilename));

			while (in.hasNextLine()) {
				
				line = in.nextLine();
				data.add(line);
				
				words = line.split(", ");
				for(String word: words) {
					if(!lista.contains(word)) {
						lista.add(word);
					}
				}
				nrTranzactii++;
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void showListAttributes() {
		
		Iterator<String> it = lista.iterator();

		System.out.println("nr tranzactii: " + nrTranzactii);
		System.out.println("Lista atribute: ");
		while (it.hasNext()) {
			System.out.print(it.next()+", ");
		}
		System.out.println("\n");
	}

	

	public void writeFile() {
		try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFilename), "utf-8"))) {

			Iterator<String> it = lista.iterator();
			Iterator<String> itData = data.iterator();
			String[] words;
			String line;

			while (it.hasNext()) {
				line = "@attribute '" + it.next() + "' { t}";
				out.write(line);
				out.write("\n");
			}

			out.write("@data");
			out.write("\n");
			
			while(itData.hasNext()) {
				words = itData.next().split(", ");
				
				int j = 0; // contor words
				for (int i = 0; i < lista.size(); i++) {

					if (j < words.length && words[j].equals(lista.get(i))) {

						out.write("t, ");
						j++;
					} else {

						out.write("?, ");
					}
				}
				out.write("\n");
			}

			

			out.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getInFilename() {
		return inFilename;
	}

	public void setInFilename(String inFilename) {
		this.inFilename = inFilename;
	}

	public String getOutFilename() {
		return outFilename;
	}

	public void setOutFilename(String outFilename) {
		this.outFilename = outFilename;
	}

}
