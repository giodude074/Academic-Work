#ifndef STRUCT_LINKED_LIST_H
#define STRUCT_LINKED_LIST_H

#include "monster_attack.h"

typedef struct node{
    monster_attack attack;
    struct node* next; /* pointer to the next node in the list. */
} node;
 
 
/*
    create a new node
    initialize the attack and next field
 
    return the newly created node
*/
node* create(monster_attack attack,node* next);
 
/*
    add a new node at the beginning of the list
*/
node* prepend(node* head,monster_attack attack);
/*
    add a new node at the end of the list
*/
node* append(node* head, monster_attack attack);
/*
    insert a new node after the prev node
*/
node* insert_after(node *head, monster_attack attack, node* prev);
/*
    insert a new node before the nxt node
*/
node* insert_before(node *head, monster_attack attack, node* nxt);
/*
    traverse the linked list
*/
void traverse(node* head);
/*
    remove node from the front of list
*/
node* remove_front(node* head);
/*
    remove node from the back of the list
*/
node* remove_back(node* head);
/*
    remove a node from the list
*/
node* remove_any(node* head,node* nd);
/*
    display a node
*/
void display(node* n);
node* search(node* head,monster_attack attack);

/*
    remove all element of the list
*/
void clear(node *head);
/*
    return the number of elements in the list
*/
int count(node *head);
/*
    sort the linked list using insertion sort
*/
node* insertion_sort(node* head);
 
/*
    reverse the linked list
*/
node* reverse(node* head);

#endif
