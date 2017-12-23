#include "payrollsystem.h"

int main(int argc, char * argv[]){
	//create an object of class PayrollSystem, add at least four employees
	//record their hours worked, issue paychecks, 
	//delete an employee, 
	//and then record new hours worked and issue another set of paychecks.
	
	PayrollSystem p("GioStudios");
	p.addEmployee("E1234", "Tom", "Ato", 300.99);
	p.addEmployee("E4444", "Caesar", "Salad", 50.48);
	p.addEmployee("E8989", "Anne", "Chovy", 99.99);
	p.addEmployee("E6666", "Bulba", "Saur", 10.79);
	
	p.recordHrsWorkes("E1234", 168); //calling a method (from inside a class.)
	p.recordHrsWorkes("E4444", 20);
	p.recordHrsWorkes("E8989", 80);
	p.recordHrsWorkes("E6666", 45);
	
	p.issuePaychecks();
	
	p.removeEmployee("E4444");
	
	p.issuePaychecks();
	
	p.recordHrsWorkes("E1234", 20); //calling a method (from inside a class.)
	p.recordHrsWorkes("E8989", 47);
	p.recordHrsWorkes("E6666", 85);
	
	p.issuePaychecks();
	
	
	return 0;
}