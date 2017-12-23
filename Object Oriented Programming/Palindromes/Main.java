package palindromeMidtermV2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) {
		Palindrome np = new NumericPalindrome();
		Palindrome tp = new TextPalindrome();
		
		File file = new File("images/palindromes.txt");
		
		try(BufferedReader reader = Files.newBufferedReader(Paths.get(file.toURI()))) {
			String line;
			while((line = reader.readLine()) != null) {
				if(np.checkIfPalindrome(line))
					System.out.println(line);
				else if(tp.checkIfPalindrome(line))
					System.out.println(line);
			}
			System.out.println(np.getCount());
			System.out.println(tp.getCount());
			System.out.println(Palindrome.alphanumericCount);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}