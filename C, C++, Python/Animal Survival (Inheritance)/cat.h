#ifndef CAT_H
#define CAT_H

#include <iostream>
#include "predator.h"
using namespace std;


class Cat: public Predator{
public:
	Cat(string nameIn, double weight_gramsIn);
	~Cat(){}
	void call();
	void predate(Prey &prey);
	friend ostream &operator<<(ostream &os, Cat cat);
};

#endif