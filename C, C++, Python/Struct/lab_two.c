#include <string.h>
#include <stdio.h>
#include <ctype.h>

 typedef struct monster_attack {
  int id;
  char name[41];
  char location[41];
  int victim_num;
}monster_attack;


int main(){
	int attack_num;
	int total_attacks = 0;

	printf("How many attacks?\n");
	scanf("%d", &attack_num);
	monster_attack attacks[attack_num];
	
	for(int i = 0; i < attack_num; ++i){
       printf("Enter monster id, monster name, monster location, number of victims: \n");
       scanf("%d%s%s%d", (attacks+i)->id, &(attacks+i)->name, &(attacks+i)->location, (attacks+i)->victim_num);
	}

	printf("Attack Infromation:\n");
	for(int i = 0; i < attack_num; ++i)
       printf("%d\t%s\t%s\t%d\n", (attacks+i)->id, (attacks+i)->name, (attacks+i)->location, (attacks+i)->victim_num);

	return 0;
}