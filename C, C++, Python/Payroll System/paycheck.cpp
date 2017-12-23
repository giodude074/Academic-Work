#include "paycheck.h"

Paycheck::Paycheck(string employeeIdIn, string firstNameIn, string lastNameIn, double amountIn) : employeeId(employeeIdIn), firstName(firstNameIn), lastName(lastNameIn), amount(amountIn) {}


//returns a string representation of the paycheck
	//Paycheck for $666.75 issued to Jerry Jones, employee # E12345
string Paycheck::toString(){  
	char buffer[120];
	sprintf(buffer, "Paycheck for $%.2f issued to %s %s, employee # %s", amount, firstName.c_str(), lastName.c_str(), employeeId.c_str());
	return string(buffer); //convert char array/pointer into string
}