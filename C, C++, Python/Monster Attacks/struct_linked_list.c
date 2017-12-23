#include <stdio.h>
#include <stdlib.h>

#include "struct_linked_list.h" 
#include "monster_attack.h"

 
/*
    create a new node
    initialize the attack and next field
 
    return the newly created node
*/
node* create(monster_attack attack,node* next){
    node* new_node = (node*)malloc(sizeof(node)); /* the pointer ‘new_node’ now contains address of a newly created node. If the linked list is empty and first node is created then it is also known as head node.*/
    if(new_node == NULL){
        printf("Error creating a new node.\n");
        exit(0);
    }
    new_node->attack = attack;   //assigned the value that it is created to hold 
    new_node->next = next;    //and its next pointer is assigned the address of next node, NULL if no next node exists
 
    return new_node;
}
 
/*
    add a new node at the beginning of the list
*/
node* prepend(node* head,monster_attack attack){
    node* new_node = create(attack,head);
    head = new_node;
    return head;
}
 
/*
    add a new node at the end of the list
*/
node* append(node* head, monster_attack attack){
	if(head == NULL) head = create(attack, head);
	else {
		/* go to the last node */
		node *cursor = head;
		while(cursor->next != NULL)  //startt at the egining and go all the way till the next null pointer (which is end)
			cursor = cursor->next;
	
		/* create a new node */
		node* new_node =  create(attack,NULL);
		cursor->next = new_node;
	}
    return head;
}
 
/*
    insert a new node after the prev node
*/
node* insert_after(node *head, monster_attack attack, node* prev){
    if(head == NULL || prev == NULL)
        return NULL;
    /* find the prev node, starting from the first node*/
    node *cursor = head;
    while(cursor != prev)
        cursor = cursor->next;
 
    if(cursor != NULL){
        node* new_node = create(attack,cursor->next);
        cursor->next = new_node;
        return head;
    }
    else{
        return NULL;
    }
}
 
/*
    insert a new node before the nxt node
*/
node* insert_before(node *head, monster_attack attack, node* nxt){
    if(nxt == NULL || head == NULL)
        return NULL;
 
    if(head == nxt){
        head = prepend(head,attack);
        return head;
    }
 
    /* find the prev node, starting from the first node*/
    node *cursor = head;
    while (cursor != NULL){
        if (cursor->next == nxt)
            break;
        cursor = cursor->next;
    }
 
    if(cursor != NULL){
        node* new_node = create(attack,cursor->next);
        cursor->next = new_node;
        return head;
    }
    else{
        return NULL;
    }
}
 
/*
    traverse the linked list
*/
void traverse(node* head){
    node* cursor = head;
    while (cursor != NULL){
        display(cursor);
        cursor = cursor->next;
    }
    printf("\n");
}
/*
    remove node from the front of list
*/
node* remove_front(node* head){
    if (head == NULL)
        return NULL;
    node *front = head;
    head = head->next;
    front->next = NULL;
    /* is this the last node in the list */
    if (front == head)
        head = NULL;
    free(front);
    return head;
}
 
/*
    remove node from the back of the list
*/
node* remove_back(node* head){
    if(head == NULL)
        return NULL;
 
    node *cursor = head;
    node *back = NULL;
    while(cursor->next != NULL){
        back = cursor;
        cursor = cursor->next;
    }
 
    if(back != NULL)
        back->next = NULL;
 
    /* if this is the last node in the list*/
    if(cursor == head)
        head = NULL;
 
    free(cursor);
 
    return head;
}
 
/*
    remove a node from the list
*/
node* remove_any(node* head,node* nd){
    if(nd == NULL)
        return NULL;
    /* if the node is the first node */
    if(nd == head)
        return remove_front(head);
 
    /* if the node is the last node */
    if(nd->next == NULL)
        return remove_back(head);
 
    /* if the node is in the middle */
    node* cursor = head;
    while(cursor != NULL){
        if(cursor->next == nd)
            break;
        cursor = cursor->next;
    }
 
    if(cursor != NULL){
        node* tmp = cursor->next;
        cursor->next = tmp->next;
        tmp->next = NULL;
        free(tmp);
    }
    return head;
 
}
/*
    display a node
*/
void display(node* n){ //THISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
    if(n != NULL){ 
		char *buffer = monster_attack_to_string(n->attack);
        printf("%s ", buffer);
		free(buffer);
	}
}
 
/*
    Search for a specific node with input attack
 
    return the first matched node that stores the input attack,
    otherwise return NULL
*/
node* search(node* head,monster_attack attack){
 
    node *cursor = head;
    while(cursor!=NULL){
        if(cursor->attack.id == attack.id)
            return cursor;
        cursor = cursor->next;
    }
    return NULL;
}
 
/*
    remove all element of the list
*/
void clear(node *head){
    node *cursor, *tmp;
 
    if(head != NULL){
        cursor = head->next;
        head->next = NULL;
        while(cursor != NULL){
            tmp = cursor->next;
            free(cursor);
            cursor = tmp;
        }
    }
}
/*
    return the number of elements in the list  TRANVERSES AND COUNTS AS IT GOES, count the number of nodes in the list
*/
int count(node *head){
    node *cursor = head;
    int c = 0;
    while(cursor != NULL){
        c++;
        cursor = cursor->next;
    }
    return c;
}
/*
    sort the linked list using insertion sort
*/
node* insertion_sort(node* head){
    node *x, *y, *e;
 
    x = head;
    head = NULL;
 
    while(x != NULL){
        e = x;
        x = x->next;
        if (head != NULL){
            if(e->attack.id > head->attack.id){
                y = head;
                while ((y->next != NULL) && (e->attack.id> y->next->attack.id)){
                    y = y->next;
                }
                e->next = y->next;
                y->next = e;
            }
            else{
                e->next = head;
                head = e ;
            }
        }
        else{
            e->next = NULL;
            head = e ;
        }
    }
    return head;
}
 
/*
    reverse the linked list
*/
node* reverse(node* head){
    node* prev    = NULL;
    node* current = head;
    node* next;
    while (current != NULL){
        next  = current->next;
        current->next = prev;
        prev = current;
        current = next;
    }
    head = prev;
    return head;
}
