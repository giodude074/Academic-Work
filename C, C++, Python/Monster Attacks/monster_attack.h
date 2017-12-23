#ifndef MONSTER_ATTACK_H
#define MONSTER_ATTACK_H

typedef struct monster_attack {
	int id;
	char name[41];
	char location[41];
	int victim_num;
} monster_attack;

monster_attack get_attack(); //publicly available functions outside the source

char *monster_attack_to_string(monster_attack attack);

#endif