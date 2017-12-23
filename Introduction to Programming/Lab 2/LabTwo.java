public class LabTwo {
	final static double PI = 3.1416;
	final static double INCHESTOCM = 2.54;
		public static void main(String[] args){

		//#1
		int a = 42;
		double a2 = (int) a;
		System.out.println(a2);
		
		//#2
		int b = (int) 49.9;
		System.out.println(b);
		
		//#3		
		int c = -2147483647;
		System.out.println (c);
		System.out.println(c - 1);
		
		//#4		
		long d = -2147483648;
		System.out.println (d);
		d = d - 1;
		System.out.println (d);
		d--;
		System.out.println (d);
				
		//#5	
		int radius = 5;
		double volume = ( (radius*radius*radius)  *   (4*PI/3) );
		System.out.print ("The Volume is ");
		System.out.printf ("%.3f", volume);
		
		
		// #6 
		
		double inches = 5;
		double cm = (inches * INCHESTOCM);
		System.out.println (" ");
		System.out.println ("Your height in centimetres.");
		System.out.println (inches + " inch(es) = "+ cm + " cm");
		
		//#7
		double f = -40;
		double cel = ((f - 32) * 5/9);
		System.out.println ("From Fahrenheit to Celsius.");
		System.out.println (f + " F = "+ cel + " C");
		 f = 0; 
		 cel = ((f - 32) * 5/9);
		System.out.println (f + " F = "+ cel + " C");
		 f = 212;
		 cel = ((f - 32) * 5/9);
		System.out.println (f + " F = "+ cel + " C");
		
		
		//#8
		int j = 111%7;
		System.out.println (j);
		j = 112%7;
		System.out.println (j);
		System.out.println ("112 is evenly distributed by 7. 111 is not.");
		
		//#9
		
		int i = 1+ 2;
		System.out.println(i < 10);
		System.out.println(5 > 7);
		
		//#10
		int age = 21;
		double gpa = 3.897;
		boolean y =((age > 25) || (gpa > 3.0 ));
		boolean z = ((age > 25) && (gpa > 3.0 ));
		System.out.println(y);
		System.out.println(z);
		} 
	}