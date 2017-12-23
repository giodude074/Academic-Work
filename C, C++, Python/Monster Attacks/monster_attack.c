#include <stdio.h>
#include <stdlib.h>

#include "monster_attack.h"

monster_attack get_attack() {
    monster_attack a;
	//char *id = (char *) &a.id;  
    puts("Please enter monster id: ");
    scanf("%d", &a.id);
    puts("Please enter monster name: ");
    scanf("%s", a.name);
    puts("Please enter monster location: ");
    scanf("%s", a.location);
	puts("Please enter number of victims: ");
    scanf("%d", &a.victim_num);
	return a;
}

char *monster_attack_to_string(monster_attack attack) {
	char *buffer = (char*) malloc(1024);
	sprintf(buffer, "Attack Info: %d, %s, %s, %d", attack.id, attack.name, attack.location, attack.victim_num);

    return buffer;
}
