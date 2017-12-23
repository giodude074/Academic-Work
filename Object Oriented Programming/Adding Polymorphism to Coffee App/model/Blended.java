package model;

public class Blended extends Drink {
	public Blended(int size) {
		super(size,BLENDED);
		this.setType(this.getType()+1); //get current value of coffee, adds 1 because of the "--size" in drink class
	}

	@Override
	public double calCost(){
		 if(this.getSize() == SMALL){
			return 2.5;
		} else if(this.getSize() == MEDIUM){
			return 3;
		} else if(this.getSize() == LARGE){
			return 3.5;
		} else return 0;
	}
	@Override
	public String toString(){
		return String.format("%s, Blended $%.2f", this.getSizes()[this.getSize()], calCost());		
	}

}
