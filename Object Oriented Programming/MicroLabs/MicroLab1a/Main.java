package exceptionHandeling;
import java.util.Scanner;

public class Main {
	int size = 0;
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a positive integer to be added to the array, or -1 to quit");
		int num = input.nextInt();
	
		while (num > 0){
			addPosInteger(num);
		if (num < 0) {
			//quit
			}
		} 
	}
	int[] myArray = new int[5];
	
	public void addPosInteger(int num){
		myArray[size] = num;
		size++;
		
		
		
	}
}