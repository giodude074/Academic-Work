import java.util.Scanner;
import java.util.Random;
public class LabSeven {

	public static void main(String[] args) {
		 double[] myArray = new double[10];
		 double[] copiedArray = new double[myArray.length];
		 returnsArray(myArray);
		
		 System.out.println("");
		 System.out.println("cubed it's" );
		 myArrayCubed(myArray);
		 limitHundred();
		 copyArray(myArray,copiedArray);
		
		 
	}
	//bullet point one -creates an array of ten doubles....	
		public static double[] returnsArray (double [] myArray){
			Scanner input = new Scanner(System.in);
			
			System.out.print("Enter "+ myArray.length + " values: ");
			for(int i = 0; i < myArray.length; i++) 
			myArray[i] = input.nextDouble();
			
			for(int i = 0; i < myArray.length; i++) {
				System.out.print(myArray[i] + " ");
			}
			return myArray;
		} //ends 1st method
		
	// bullet point two, cube all values.
		public static double [] myArrayCubed (double[] myArray){
			
			for (int i = 0; i < myArray.length; i++) {
				myArray[i] = (int) Math.pow(myArray[i], 3);
				System.out.println(myArray[i]);
			}
	
			

			return myArray;
		} // ends 2nd method
		
		
		//3rd bullet point - values exceeding 100
		public static void limitHundred(){
			 Random r = new Random();
			double[] myOtherArray = new double[100];
		    for (int i = 0; i < myOtherArray.length; i++) {
		    	myOtherArray[i] = r.nextInt();
		    	//myOtherArray[i] = Math.random();   rmove random r varable and turn ints to doubles.
		    	
		    	if (myOtherArray[i] > 100)
		    		myOtherArray[i]= 100;
		    	System.out.println(myOtherArray[i]);
		    }
		
			/*for (int i = 0; i < myOtherArray.length; i++) {
				 int index = (int)(Math.random() * myOtherArray.length);
				 */
						//System.out.println(myOtherArray[i]);  COULDNT GET THIS TO WORK
				
			
		}// end of 3rd methos
			

		//4th bullet point()
		public static double [] copyArray (double[] myArray, double[] copiedArray){
			System.out.println ("Copied Reciprocal Array");
			for (int i = 0; i < myArray.length; i++)
			   copiedArray[i] = myArray[i];
			
			for (int i = 0; i < copiedArray.length; i++){	
				copiedArray[i] = (1/(copiedArray[i]));
				System.out.println(copiedArray[i]);
			}
				
			

			return copiedArray;
		} // ends 4th method
		


}// ends main

