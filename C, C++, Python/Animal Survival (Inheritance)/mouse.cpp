#include <iostream>

#include "mouse.h"

Mouse::Mouse(string nameIn, double weight_gramsIn):Prey(nameIn, weight_gramsIn){}

void Mouse::flee(){
	cout << name << " scurries off\n";
}

void Mouse::call(){
	cout << name << " says 'squeak.'\n";
}