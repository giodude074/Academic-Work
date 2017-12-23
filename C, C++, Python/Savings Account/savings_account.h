#include <queue>
#include <vector>
#include <iostream>
#include <string>

using namespace std;

class SavingsAccount{
	friend ostream &operator<< ( ostream &output, const SavingsAccount &v );
	public:
		SavingsAccount(int accountNumIn, string ownerNameIn, double balanceIn); //constructor
		
		//getters setters
		int getAccountNum();
		string getOwnerName();
		double getbalance();
	
	private:
		int accountNum;
		string ownerName;
		double balance; 
};

ostream &operator<<( ostream &output, const SavingsAccount &v ){
	output << v.getAccountNum() << "; OwnerName: " << v.getOwnerName() << "; Balance: " << v.getbalance();
	return output;
}	