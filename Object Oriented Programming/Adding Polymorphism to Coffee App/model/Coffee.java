package model;

public class Coffee extends Drink {
	public Coffee(int size) {
		super(size, COFFEE);
		this.setType(this.getType()+1); //get current value of coffee, adds 1 because of the "--size" in drink class
	}
	
	@Override
	public double calCost(){
		if(this.getSize() == SMALL){
			return 0.9;
		} else if(this.getSize() == MEDIUM){
			return 1.6;
		} else if(this.getSize() == LARGE){
			return 2;
		}
		else return 0;
	}
	
	@Override
	public String toString(){
		return String.format("%s, Coffee $%.2f", this.getSizes()[this.getSize()], calCost());		
	}

}
