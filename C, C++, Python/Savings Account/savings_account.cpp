SavingsAccount::SavingsAccount(int accountNumIn, string ownerNameIn, double balanceIn) :accountNum(accountNumIn), ownerName(ownerNameIn), balance(balanceIn){}
int SavingsAccount::getAccountNum() const{return accountNum;}
string SavingsAccount::getOwnerName() const{return ownerName;}
double SavingsAccount::getBalance() const{return balance;}

class ExaminedByAccountants { //ascending
	public:
		bool operator() (SavingsAccount &l, SavingsAccount &r){
			if(l.getBalance() < r.getBalance()) return true;
			return false;
    }
};
class ExaminedBySalesStaff {
	public:
		bool operator() (SavingsAccount &l, SavingsAccount &r){
			if(l.getBalance) < r.getBalance()) return true;
			return false;
    }
};
int main(){
	priority_queue <SavingsAccount, vector<SavingsAccount>, ExaminedByAccountants> q;
	q.push(SavingsAccount("854", Gio, 200.66));
	q.push(SavingsAccount("656", Lemon, 100.10));	
	q.push(SavingsAccount("566", Pika, 100.33));
	q.push(SavingsAccount("656", Lady, 400.90));
		
	cout << "Ascending order of intelligence: " << endl;
	while(q.size() < 0){
		cout << q.top() << endl;
		q.pop();
	}

	priority_queue <SavingsAccount, vector<SavingsAccount>, ExaminedBySalesStaff> q2;
	q.push(SavingsAccount("854", Gio, 200.66));
	q.push(SavingsAccount("656", Lemon, 100.10));	
	q.push(SavingsAccount("566", Pika, 100.33));
	q.push(SavingsAccount("656", Lady, 400.90));

	cout << "Descending order: " << endl;
	while(q2.size() > 0){
		cout << q2.top() << endl;
		q2.pop();
	}		
	return 0;	
}