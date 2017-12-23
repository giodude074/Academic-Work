package main;

import java.util.Date;
import java.util.Scanner;//Auto import: ctr shift O

import model.*; //imports all classes in model package


public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Order order = null;
		int counter = 1;
		while (true) {
			System.out.println("Choose one: ");
			System.out.println("Order Drink (1)");
			System.out.println("Exit (0)");
			int choice = input.nextInt();

			if (choice == 0) {
				if (order != null) {
					order.toString();
					System.out.println("Order # " + order.getId());
				}
				break;
			}

			else if (choice == 1) {
				while (true) {
					if (order == null) {
						order = new Order(counter++);
					}

					System.out.println("Choose one: ");
					System.out.println("Coffee (1)");
					System.out.println("Tea (2)");
					System.out.println("Blended (3)");
					System.out.println("Soda (4)");
					System.out.println("Previous menu (0)");
					int drinkChoice = input.nextInt();

					if (drinkChoice == 0)
						break;
					else if (drinkChoice <= 4) {
						System.out.println("Choose one: ");
						System.out.println("Small (1)");
						System.out.println("Medium (2)");
						System.out.println("Large (3)");
						System.out.println("Previous menu (0)");
						int drinkSize = input.nextInt();

						if (drinkSize == 0)
							break;
						else if (drinkChoice == 1) {
							Drink co = new Coffee(drinkSize);
							order.addDrink(co);
							System.out.println(co.toString() + " added to order.");

						} 
						else if (drinkChoice == 2) {
							Drink t = new Tea(drinkSize);
							order.addDrink(t);
							System.out.println(t.toString() + " added to order.");

						} 
						else if (drinkChoice == 3) {
							Drink bl = new Blended(drinkSize);
							order.addDrink(bl);
							System.out.println(bl.toString() + " added to order.");
						} 
						else if (drinkChoice == 4) {
							Drink so = new Soda(drinkSize);
							order.addDrink(so);
							System.out.println(so.toString() + " added to order.");

						} 
						
						
						else {
							System.out.println("Enter 1, 2, 3 or 0");
							continue;
						}
					} else {
						System.out.println("Enter 1, 2, 3, 4 or 0");
						continue;
					}

				}
			} else {
				System.out.println("Enter 1 or 0");
				continue;
			}

		}
	}
}
