#include "animal.h"

Animal::Animal(string nameIn, double weight_gramsIn): name(nameIn), weight_grams(weight_gramsIn){}

void Animal::eat(double food_weight){
	weight_grams += food_weight;
	
}