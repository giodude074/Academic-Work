package application;

public class Drink {
	//Create a Drink class with the following fields:
	//size (int), type (int).
	private int size;
	private int type;
	//Create the following static int constants for size: SMALL, MEDIUM, LARGE,  (0, 1, 2 respectively) and for type: COFFEE, TEA, SODA, BLENDED (0, 1, 2, 3 respectively). Do not use getters and setters for these; make them public.
	//Whenever you create a new Drink, use these to enter the information --- do not enter integers directly in to the Drink constructor!
	public static final int SMALL = 0;
	public static final int MEDIUM = 1;
	public static final int LARGE = 2;

	public static final int COFFEE = 0;
	public static final int TEA = 1;
	public static final int BLENDED = 2;
	public static final int SODA = 3;


	private String[] sizes = {"Small", "Medium", "Large"};
	private String[] types = {"Coffee", "Tea", "Blended", "Soda" };

	//2pts Create a Drink constructor that takes two ints (one for size and type)
	//that sets the fields to these values.

	public Drink(int size, int type){
		this.size = size;
		this.type = type;
	}

	//2pts In the Drink class, create a calcCost method that returns the cost of the drink according to the following table:
	//
	//	 			Coffee	Tea	    Soda	Blended
	//		Small	.90		1.25	1.25	2.50
	//		Medium	1.60	2.00	2.00	3.00
	//		Large	2.00	2.50	2.50	3.50


	public double calCost(){
		if(size == SMALL && type == COFFEE){
			return 0.9;
		} else if(size == SMALL && type == TEA){
			return 1.25;
		} else if(size == SMALL && type == SODA){
			return 1.25;
		} else if(size == SMALL && type == BLENDED){
			return 2.5;
		} else if(size == MEDIUM && type == COFFEE){
			return 1.6;
		} else if(size == MEDIUM && type == TEA){
			return 2;
		} else if(size == MEDIUM && type == SODA){
			return 2;
		} else if(size == MEDIUM && type == BLENDED){
			return 3;
		} else if(size == LARGE  && type == COFFEE){
			return 2;
		} else if(size == LARGE  && type == TEA){
			return 2.5;
		} else if(size == LARGE  && type == SODA){
			return 2.5;
		} else if(size == LARGE  && type == BLENDED){
			return 3.5;
		} else return 0;
	}

	//2pts In the Drink class, create a toString method that returns
	//a formatted string representing the drink in the following format:
	//"Small coffee, $0.90." The money and type formats must be exactly
	//as above (e.g., $1.60, not 1.6).

	public String toString(){
		return String.format("%s %s, $%.2f", sizes[size], types[type], calCost());
	}
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String[] getSizes() {
		return sizes;
	}

	public String[] getTypes() {
		return types;
	}

}
