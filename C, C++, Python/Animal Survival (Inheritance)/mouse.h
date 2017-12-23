#ifndef MOUSE_H
#define MOUSE_H

#include "prey.h"

class Mouse: public Prey{
public:
	Mouse(string nameIn, double weight_gramsIn);
	~Mouse(){}
	void flee();
	void call();
};

#endif