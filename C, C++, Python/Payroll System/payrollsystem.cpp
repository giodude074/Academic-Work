#include <iostream>

#include "paycheck.h"
#include "payrollsystem.h"

PayrollSystem::PayrollSystem(string companyNameIn) : companyName(companyNameIn) {}

// takes info about the employee as parameters 
//and uses this data in a call to Employee's constructor
void PayrollSystem::addEmployee(string employeeId, string firstName, string lastName, double hourlyWage){
	Employee e(employeeId); //instance of employee
	e.setFirstName(firstName);
	e.setLastName(lastName);
	e.setHourlyWage(hourlyWage);
	employees.push_back(e);
}

//find an employee by id # 
//& remove him/her from the employee vector 
//look up vector's erase() function
void PayrollSystem::removeEmployee(string employeeId){
	for(int i = 0; i < employees.size(); i++){
		if(employees[i].getEmployeeId() == employeeId){
			employees.erase(employees.begin()+i);
			break; // we dont wanna keep iterating
		}
	}
}

// find an employee by id # 
//& record the hours s/he worked during the current pay period
//search the vector for the employee
void PayrollSystem::recordHrsWorkes(string employeeId, int hoursWorked){
	for(int i = 0; i < employees.size(); i++){
		if(employees[i].getEmployeeId() == employeeId){
			employees[i].setHoursWorked(hoursWorked);
			break;
		}
	}
}

//issue paychecks to all employees the vector
//calls the calcPay() function of the correct employee, 
//creating a Paycheck with the appropriate data, 
//getting a string representation of the Paycheck object, 
//and printing the string. 
void PayrollSystem::issuePaychecks(){
	cout << "Company Name: "<< companyName << endl;
	for(Employee &employee : employees){
		double pay = employee.calcPay();
		Paycheck p(employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(), pay);
		cout << p.toString() << endl;
		employee.setHoursWorked(0);
	}
}