package midtermCodingPart;

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TSVtoCSV extends FileCopier {
	/*In TSVtoCSV, override copy. In this method, it will 
	take values that are tab separated and convert them 
	to comma separated.*/ 
	
	/*private File convert(File inputFile, char from, char to) { 
		outputFile = new File("convertedCsv.csv");
	}*/
	@Override
	public void copy(String file1, String file2) throws FileNotFoundException{
		File original = new File(file1);
		File copied = new File(file2);
		
		Scanner input = new Scanner(original);
		PrintWriter output = new PrintWriter(copied);//writes new file
		
		while(input.hasNextLine()){
			String next = input.nextLine();
			next = next.replaceAll("\t", ", ");
			output.println(next);			
		}
		output.close();
		input.close();
	}
	
/*	2 pts In TSVtoCSV overload the above copy method with 
 * another method copy(String csvFilePath) method that converts 
 * the tsv file to a csv file with the same name. 
 * 
 * Use the other
 *  copy method to do this along with the renaming technique we
 *   covered in class.  */
	
	/*public File copy(String csvFilePath)throws FileNotFoundException{ 
		return copy(csvFilePath);
		...
		
		System.out.println(origFile.delete());
      	//System.out.println(copiedFile.renameTo(new File("")));
    }*/
	
}
