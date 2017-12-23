#include "cat.h"

Cat::Cat(string nameIn, double weight_gramsIn):Predator(nameIn, weight_gramsIn){}

void Cat::call() { 
	cout << name << " says 'Meow'\n"; 
}

void Cat::predate(Prey &prey){
	cout << name << " pounces and devours " << prey.name << " who weighs " << weight_grams << " grams.\n";
	eat(prey.weight_grams);
}

ostream &operator<<(ostream &os, Cat cat){
	os << cat.name << " is a cat weighing " << cat.weight_grams << " grams.\n";
	return os;
}