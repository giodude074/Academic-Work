#ifndef ANIMAL_H
#define ANIMAL_H

#include <string>
using namespace std;

class Animal{
public:
	string name;
	double weight_grams;
	
	Animal(string nameIn, double weight_gramsIn);
	
	virtual void call() = 0; 
	
	void eat(double food_weight);
};

#endif