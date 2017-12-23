#ifndef BIRD_H
#define BIRD_H

#include "prey.h"

class Bird: public Prey{
public:
	Bird(string nameIn, double weight_gramsIn);
	~Bird(){}
	void flee();
	void call();
};

#endif