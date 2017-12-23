package application;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.text.Text;

public class Controller {
	private ArrayList<Drink> drinks = new ArrayList<>();
	private ArrayList<Order> orders = new ArrayList<>();

	private int idNum = 1;
	@FXML
	private Button btcSmall,btcMedium,btcLarge,
				   bttSmall,bttMedium,bttLarge,
				   btsSmall,btsMedium,btsLarge,
				   btbSmall,btbMedium,btbLarge;
	@FXML
	private Tab tabMain, tabOrder;
	@FXML
	private ListView<Drink> list;
	@FXML
	private ListView<String> list1;
	@FXML
	private Text txtTotal;


	public Controller(){
		drinks = new ArrayList<>();
	}

	//COFFEE
	public void btcSmall(ActionEvent e){
		addDrink(new Drink(Drink.SMALL, Drink.COFFEE));
	}
	public void btcMedium(ActionEvent e){
		addDrink(new Drink(Drink.MEDIUM, Drink.COFFEE));
	}
	public void btcLarge(ActionEvent e){
		addDrink(new Drink(Drink.LARGE, Drink.COFFEE));
	}

	//TEA
	public void bttSmall(ActionEvent e){
		addDrink(new Drink(Drink.SMALL, Drink.TEA));
	}
	public void bttMedium(ActionEvent e){
		addDrink(new Drink(Drink.MEDIUM, Drink.TEA));
	}
	public void bttLarge(ActionEvent e){
		addDrink(new Drink(Drink.LARGE, Drink.TEA));
	}

	//SODA
	public void btsSmall(ActionEvent e){
		addDrink(new Drink(Drink.SMALL, Drink.SODA));
	}
	public void btsMedium(ActionEvent e){
		addDrink(new Drink(Drink.MEDIUM, Drink.SODA));
	}
	public void btsLarge(ActionEvent e){
		addDrink(new Drink(Drink.LARGE, Drink.SODA));
	}

	//BLENDED
	public void btbSmall(ActionEvent e){
		addDrink(new Drink(Drink.SMALL, Drink.BLENDED));
	}
	public void btbMedium(ActionEvent e){
		addDrink(new Drink(Drink.MEDIUM, Drink.BLENDED));
	}
	public void btbLarge(ActionEvent e){
		addDrink(new Drink(Drink.LARGE, Drink.BLENDED));
	}

	//adds drinks to listView list
	private void addDrink(Drink drink){
		drinks.add(drink);
		ObservableList<Drink> observableItems = FXCollections.observableArrayList(drinks);
		list.setItems(observableItems);

		double cost = 0;
		for(Drink drink1: drinks)
			cost += drink1.calCost();
		txtTotal.setText(String.format("Total: $%.2f", cost));
	}

	@FXML
	private void onChangeSelection(){
		ArrayList<String> list = new ArrayList<>();

		for (Order order: orders)
			list.add(String.format("ID# %d: $%.2f", order.getId(), order.calculateOrderTotal()));
		list1.setItems(FXCollections.observableArrayList(list));

	}

	//when Complete order Button is pressed
	public void onCompleteOrder(ActionEvent e){
		Order order = new Order(idNum++);
		for (Drink drink: drinks)
			order.addDrink(drink);

		try(BufferedWriter output = Files.newBufferedWriter(Paths.get(System.getProperty("user.dir") + "\\ViewOrders.csv"),
			StandardOpenOption.CREATE, StandardOpenOption.APPEND)){
			output.write("ID# " + idNum + ": ");
			output.write(order.toString());
			output.newLine();
		}
		catch (IOException event){
			System.err.printf("IOExcepton: %%n", event);
		}
		drinks.clear();
		list.setItems(FXCollections.observableArrayList(drinks));
		txtTotal.setText("Total:");

		orders.add(order);
	}
}