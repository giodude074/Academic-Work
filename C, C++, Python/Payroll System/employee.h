#ifndef EMPLOYEE
#define EMPLOYEE

#include <string>
using namespace std;

class Employee{
	public:
		Employee(string employeeIdIn); //constructor
		double calcPay(); //returns # of hours worked * the hourly wage
		
		string getEmployeeId();
		string getFirstName();
		string getLastName();
	
		
		void setHoursWorked(int hoursWorked);
		void setFirstName(string firstName);
		void setLastName(string lastName);
		void setHourlyWage(double hourlyWage);
	
	private:
		string employeeId;
		string firstName;
		string lastName;
		double hourlyWage;
		int hoursWorked;
};

#endif