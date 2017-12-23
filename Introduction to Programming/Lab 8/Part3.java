import java.util.Scanner;

public class Part3 {
	
	final static double TOKG = 2.205;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int score = 0;
		do {
			System.out.println("What is your best ever bowling score?");
			while (!(sc.hasNextInt())) {
				sc.nextLine();
				System.out.println("Invalid Input. Enter an integer.");
			}
			score = sc.nextInt();
			if (score < 0 || score > 300)
				System.out.println("No, an integer between 0 and 300");
		} while (score < 0 || score > 300);
		
		if (score < 100)
		System.out.println("Booo. You are a poor bowler.");
		
		 else if (score <= 100 || score < 200)
			System.out.println("Okay, You are a competent bowler.");
		
		 else if (score >= 200)
			System.out.println("Amazing! You are a great bowler!");
		
		
		
		// weight
		Double weight = 0.0;
		do {
			System.out.println("Enter your weight in pounds");

			while (!(sc.hasNextDouble())) {
				sc.nextLine();
				System.out.println("Invalid input. Enter a decimal!");
			}
			weight = sc.nextDouble();
			if (weight < 90.0  || weight > 300.0)
				System.out.println("No, an decimal between 90.0 and 300.0");
		} while (weight < 90.0 || weight > 300.0);
		
		double weightKG = weight/TOKG;
		System.out.println("You are " +weightKG+ " kg.");

		
		
		// true or false
		
		
		Boolean nearby;
		do {
			System.out.println("Do you live within 5 miles of campus? true or false");

			while (!(sc.hasNextBoolean())) {
				sc.nextLine();
				System.out.println("Wrong input. Use a Boolean. True or False.");
			}
			nearby = sc.nextBoolean();
			if (nearby==true)
				System.out.println("True, you live nearby.");
			else
				System.out.println("False, you dont live nearby");
		} while (!(nearby==true || nearby ==false));

		
		
		//tallness
		
		Boolean tall;
		do {
			System.out.println("Are you atleast 5ft 10 inches? true or false");

			while (!(sc.hasNextBoolean())) {
				sc.nextLine();
				System.out.println("Wrong input. Use a Boolean. True or False.");
			}
			tall = sc.nextBoolean();
			if (tall==true)
				System.out.println("True, you are tall.");
			else
				System.out.println("False, you are short");
		} while (!(tall==true || tall ==false));
		
		
		// once you have both answers
		
		if (nearby==false && tall == false )
			System.out.println("You live far away and you are short.");
		else if (nearby==true && tall == true)
			System.out.println("You live close by and you are tall.");
		
		else if (nearby==true || tall == false)
			System.out.println("You live close by or you are short.");
		else if (nearby==false || tall == true)
				System.out.println("You live far away or you are tall.");
		
		if (tall == true && weightKG < 45 )
			System.out.println("You are tall and weigh more than 45kg");
		else
			System.out.println("You are not tall and dont weigh more than 45kg");

	}

}