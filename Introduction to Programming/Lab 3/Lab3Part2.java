

import java.util.Scanner;

public class Lab3Part2 {

		public static void main(String[] args) {		
			Scanner input = new Scanner(System.in);
			String hand = null;

			System.out.println("Are you left-handed? yes or no");
			hand = input.next();
			if (hand.equals("yes"))
				System.out.println("You are left-handed.");
			else if (hand.equals("no"))
				System.out.println("You are not left-handed.");
			
			String height = null;

			System.out.println("Is your dad less than 5 ft 8 inches tall?");
			height = input.next();
			if (height.equals("yes"))
				System.out.println("Your dad is less than 5 ft 8 inches tall.");
			else if (height.equals("no"))
				System.out.println("Your dad is not less than 5 ft 8 inches tall.");
			
			
			

			if (((height.equals("yes")) && (hand.equals("no"))) || ((height.equals("no")) && (hand.equals("yes"))) || ((height.equals("yes")) && (hand.equals("yes"))))
				System.out.println("At least one of the values is TRUE.");
			else
				System.out.println("FALSE, none of the values are true.");
			
			
			if (((height.equals("yes")) && (hand.equals("yes"))) && ((height.equals("no")) && (hand.equals("no"))))
				System.out.println("TRUE, both values are true.");
			else
				System.out.println("FALSE, atleast one value is false.");
			
			
			// user's age in months
			
			int age;
			
				System.out.println("How old are you?");
				age = input.nextInt();	
			
				int toMonths = (age*12);
			
				System.out.println("You are about "  + toMonths + " months old.");
				
			//nmae of sibling or friend
				
			String fname = null;

				System.out.println("what is the name of your friend or sibling?");
				fname = input.next();
		
				System.out.println(fname);
			// their age
				
				int fAge;
				
				System.out.println("How old are they?");
				fAge = input.nextInt();	
			
				toMonths = (fAge*12);
			
					System.out.println(fname + " is about "  + toMonths + " months old.");
				
				if (fAge > age)
					System.out.println(fname + " is older than you!");
				else if (fAge < age)
					System.out.println("You are older than " + fname);
				
				//within 18 months of your friend/sibling
				
				       
				int diff = age - fAge;
				int add = age + fAge;
				
				
				if ((Math.abs(diff) <= 18) || (Math.abs(add) <= 18))
					System.out.println(fname + " is within 18 months of your age.");
				else 
					System.out.println(fname + " is not within 18 months of your age.");
				
				
				// evenly divisible
				
				int divisibility= toMonths%6; 

				if (divisibility == 0)
					System.out.println("Your age in months is divisible by 6");
				else 
					System.out.println("Your age in months is not divisible by 6");
					
			// gpa
				double gpa;
			
				System.out.println("What is your GPA?");
				gpa = input.nextDouble();	
			
				System.out.println("Your GPA is "  + gpa);
				
			//displacement of liters
				double displacement;
				
				System.out.println("What the displacement in liters of your car engine?");
				displacement = input.nextDouble();	
			
				System.out.println("The displacement in liters of your car engine is "  + displacement);
				
				
			// gpa = to displacement?
				
				if (gpa == displacement)
					System.out.println("Your gpa is equal to the displacement in liters of your car engine.");
				else
					System.out.println("Your gpa is NOT equal to the displacement in liters of your car engine.");
			
		} 
		
	}
