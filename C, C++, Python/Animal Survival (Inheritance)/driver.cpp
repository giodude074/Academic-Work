#include <cstdlib>
#include <vector>
#include <ctime>

#include "cat.h"
#include "bird.h"
#include "mouse.h"

int main(){

	Cat *tom = new Cat("Tom", 4309.13);
	
	tom->call(); // because tom is a pointer
	cout << *tom; //operator overloading 
	
	vector<Prey*> prey;
	prey.push_back(new Bird("Tweety", 40.41));
	prey.push_back(new Bird("Big Bird", 100.80));
	prey.push_back(new Mouse("Jerry", 25.53));
	prey.push_back(new Mouse("Stuart Little", 19.27));
	
	srand((unsigned int) time(NULL));
	for(Prey *p: prey){
		p->call();
		if(rand()%2 == 0){
			tom->predate(*p);
		} else {
			p->flee();
		}
		delete p; //free to prevent leak
	}
	
	prey.clear();
	
	
	delete tom;
	return 0;
}