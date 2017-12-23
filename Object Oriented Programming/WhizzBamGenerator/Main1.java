package beginingDemos;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Write any sentence:\n");
		String sentence = input.nextLine();
		reverseString(sentence);
		System.out.println("\n");
		whizzBamGenerator();

	}// ends main

	public static String reverseString(String x) {
		char[] rev = x.toCharArray();
		for (int i = rev.length - 1; i >= 0; i--) {
			System.out.print(rev[i]);

		}
		String newSent = new String(rev);
		return newSent;
	}

	public static void whizzBamGenerator() {
		int nums = 100;
		for (int i = 0; i <= nums; i++) {
			boolean printNum = true;
			if ((i % 4) == 0)
				System.out.print("Whizz ");
			if ((i % 6) == 0)
				System.out.print("Bam ");
			else if (((i % 6) == 0) && ((i % 4) == 0))
				System.out.print("Whizz Bam ");

			printNum = false;
			if (printNum == false)
				System.out.println(i);
		}
	}

}
