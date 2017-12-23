package model;

public class Tea extends Drink{
	public Tea(int size) {
		super(size,TEA);
		this.setType(this.getType()+1); //get current value of coffee, adds 1 because of the "--size" in drink class
	}
	
	@Override
	public double calCost(){
		if(this.getSize() == SMALL){
			return 1.25;
		} else if(this.getSize() == MEDIUM){
			return 2;
		} else if(this.getSize() == LARGE){
			return 2.5;
		} else return 0;
	}
	@Override
	public String toString(){
		return String.format("%s, Tea $%.2f", this.getSizes()[this.getSize()], calCost());		
	}

}
