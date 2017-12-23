package exceptionHandeling;
import java.util.Scanner;

public class Main {
	static int size = 0;
	static int[] myArray = new int[5];
	
	
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		
	
		while (true){  //keep going until we break out of it
			System.out.println("Enter a positive integer to be added to the array, or -1 to quit");
			int value = input.nextInt();
			if(value == -1){ break;
			}
			else {
				try {
					addPosInteger(value);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("You can only enter 5 numbers.");
					break;
				}
					for(int i =0; i < myArray.length; i++)
						System.out.print(myArray[i] + ", ");
			}
		} 
	}
	
	
	public static void addPosInteger(int num){
		myArray[size++] = num; // increments by one after we are done executing the statement
		//size++; // this is fine too 
		
		
	}
}