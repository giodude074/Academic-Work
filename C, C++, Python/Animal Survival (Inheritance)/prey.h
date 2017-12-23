#ifndef PREY_H
#define PREY_H

#include "animal.h"

class Prey: public Animal{ 
public:
	Prey(string nameIn, double weight_gramsIn):Animal(nameIn, weight_gramsIn){}
	virtual void flee() = 0;
};

#endif