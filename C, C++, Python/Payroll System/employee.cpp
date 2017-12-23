#include "employee.h"


Employee::Employee(string employeeIdIn) : employeeId(employeeIdIn) {}

//getters
string Employee::getEmployeeId(){
	return employeeId;
}

string Employee::getFirstName(){
	return firstName;
}

string Employee::getLastName(){
	return lastName;
}

//setters
void Employee::setHoursWorked(int hoursWorked){
	this->hoursWorked = hoursWorked;
}

void Employee::setFirstName(string firstName){
	this->firstName = firstName;
}

void Employee::setLastName(string lastName){
	this->lastName = lastName;
}

void Employee::setHourlyWage(double hourlyWage){
	this->hourlyWage = hourlyWage;
}

double Employee::calcPay(){
	//return # of hours worked * the hourly wage
	return hoursWorked * hourlyWage;
}