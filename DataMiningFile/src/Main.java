import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {

		DataFile file = new DataFile("magazin", "data");
		
		file.createListAttributes();
		file.showListAttributes();
		

		file.writeFile();
		
//		Set attrs = new TreeSet();
//		
//		attrs.add("b");
//		attrs.add("a");
//		attrs.add("x");
//		attrs.add("a");
//		System.out.println(attrs);		
	}
}
