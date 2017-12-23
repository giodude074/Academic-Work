#ifndef PAYCHECK
#define PAYCHECK

#include <string>
using namespace std;

class Paycheck{
	public:
		Paycheck(string employeeIdIn, string firstNameIn, string lastNameIn, double amountIn); //constructor
		string toString(); 
		
	
	private:
		string employeeId;
		string firstName;
		string lastName;
		double amount;
};

#endif