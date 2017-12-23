package midtermCodingPart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileCopier {

	/*In FileCopier, create a copy(String file1, String file2) 
	method. This method takes the contents of the first 
	file and copies it into the second file.*/
	
	public void copy(String file1, String file2) throws FileNotFoundException{
		File original = new File(file1);
		File copied = new File(file2);
		
		Scanner input = new Scanner(original);
		PrintWriter output = new PrintWriter(copied);//writes new file
		
		while(input.hasNextLine()){
			String next = input.nextLine();
			output.println(next);			
		}
		output.close();
		input.close();
	}
}