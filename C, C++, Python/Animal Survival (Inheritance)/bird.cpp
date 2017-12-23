#include <iostream>
#include "bird.h"

Bird::Bird(string nameIn, double weight_gramsIn):Prey(nameIn, weight_gramsIn){}

void Bird::flee(){
	cout << name << " flies away\n";
}

void Bird::call(){
	cout << name << " says 'tweet.'\n";
}