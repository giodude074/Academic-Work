package midtermCodingPart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CSVtoTSV extends FileCopier {

	/*4 pts In CSVtoTSV, override copy.  In this method,
	it will take values that are comma separated and
	convert them to tab separated. */
	
	@Override
	public void copy(String file1, String file2) throws FileNotFoundException{
		File original = new File(file1);
		File copied = new File(file2);
		
		Scanner input = new Scanner(original);
		PrintWriter output = new PrintWriter(copied);//writes new file
		
		while(input.hasNextLine()){
			String next = input.nextLine();
			next = next.replaceAll(",", "\t");
			output.println(next);			
		}
		output.close();
		input.close();
	}
	
	/*2 pts In CSVtoTSV overload the above copy method with another method 
	 * copy(String tsvFilePath) method that converts the csv file to a tsv file
	 *  with the same name. Use the other copy method to do this along with 
	 *  the renaming technique we covered in class. */
	
	/*public File copy(String tsvFilePath)throws FileNotFoundException{
		return copy(tsvFilePath);
	...
		
		System.out.println(origFile.delete());
      	//System.out.println(copiedFile.renameTo(new File("")));
    }*/
}
