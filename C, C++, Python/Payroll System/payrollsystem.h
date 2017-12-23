#ifndef PAYROLLSYSTEM
#define PAYROLLSYSTEM

#include <vector>

#include "employee.h"

using namespace std;

class PayrollSystem{
	public:
		PayrollSystem(string companyNameIn); //constructor
		
		void addEmployee(string employeeId, string firstName, string lastName, double hourlyWage); 
		void removeEmployee(string employeeId);
		void recordHrsWorkes(string employeeId, int hoursWorked); 
		void issuePaychecks(); 
	
	private:
		string companyName;
		vector<Employee> employees;

};

#endif