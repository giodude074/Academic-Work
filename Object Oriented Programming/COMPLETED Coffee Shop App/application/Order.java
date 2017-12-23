package application;

import java.util.Date;

//Create an Order class with three fields:
//id (int), drinks (Drink array), and time (Date).
//Initialize the Drink array with 20 empty indices
//and the time with the current time in the constructor,
//and enter a unique integer in the id field.
//Encapsulate the first two fields with both read and write access,
//and the time with read access only.
public class Order {
	private int id;
	private Drink[] drinks;
	private Date time;
	private int size;

	public Order(int id) {
		this.id = id;
		time = new Date();
		this.drinks = new Drink[20];
	}

	// 2pts Implement a calculateOrderTotal method in the Order
	// class that computes the total cost of all the drinks in its
	// Drink array.

	public double calculateOrderTotal() {
		double cost = 0;
		for (int i = 0; i < size; i++) {
			Drink currentDrink = drinks[i];
			cost += currentDrink.calCost();
		}

		return cost;
	}

	// In the Order class, implement a toString method that:
	// prints out all the drinks with their prices in order (each on
	// their own line), the total cost, and the time the order was
	// created (in human readable format).
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(Drink drink: this.drinks)
			if(drink != null)
				builder.append(drink.toString() + ", ");
		builder.append(String.format("Total cost: $%.2f, ", calculateOrderTotal()));
			return builder.toString();
	}

	public void addDrink(Drink drink){
		drinks[size++] = drink;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Drink[] getDrinks() {
		return drinks;
	}

	public void setDrinks(Drink[] drinks) {
		this.drinks = drinks;
	}

	public Date getTime() {
		return time;
	}

}