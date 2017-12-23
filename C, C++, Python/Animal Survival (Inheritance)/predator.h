#ifndef PREDATOR_H
#define PREDATOR_H

#include "animal.h"
#include "prey.h"

class Predator: public Animal{ //subclass of Animal
public:
	Predator(string nameIn, double weight_gramsIn):Animal(nameIn, weight_gramsIn){}
	virtual void predate(Prey &prey) = 0;
};
#endif