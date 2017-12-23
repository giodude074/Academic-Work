package midtermCodingPart;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {


	public static void main(String[] args) throws FileNotFoundException {
		//E:\CS\cs202\images\milage.csv
		///cs202/images/milage.csv
		
		copyText(new FileCopier());
		copyText(new TSVtoCSV());
		copyText(new CSVtoTSV());
			
	}

	public static void copyText(FileCopier copier) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the original file path");
		String original = input.next();
		System.out.println("Enter file path you want it to be copied to");
		String copied = input.next();
		copier.copy(original, copied);
	}

}