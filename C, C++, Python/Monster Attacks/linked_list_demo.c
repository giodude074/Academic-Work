#include <stdio.h>
#include <stdlib.h>

#include "struct_linked_list.h"
#include "monster_attack.h"

void show_menu()
{
    printf("\n--- C Linked List Demonstration --- \n\n");
    printf("0.quit\n");
    printf("1.prepend an element\n");
    printf("2.append an element\n");
    printf("3.search for an element\n");
    printf("4.insert after an element\n");
    printf("5.insert before an element\n");
    printf("6.remove front node\n");
    printf("7.remove back node\n");
    printf("8.remove any node\n");
    printf("9.sort the list\n");
    printf("10.Reverse the linked list\n");
}
     
int main()
{
    int command;
    monster_attack data;
 
    node* head = NULL;
    node* tmp = NULL;
    
    do {
		show_menu();
        printf("\nEnter a command(0-10,0 to quit): ");
        scanf("%d",&command);
 
        switch(command)
        {
        case 1: //yes
            printf("Please enter data to prepend. ");
            data = get_attack();
            head = prepend(head,data);
            traverse(head);
            break;
        case 2: //yes
            printf("Please enter data to append.  ");
            data = get_attack();
            head = append(head,data);
            traverse(head);
            break;
        case 3:
            printf("Please enter data to search: ");
			scanf("%d",&data.id);
            tmp = search(head,data);
            if(tmp != NULL)
            {
                printf("Element with value %d found.",data.id);

            }
            else
            {
                printf("Element with value %d not found.",data.id);
            }
            break;
        case 4: // insert before by id 
            printf("Enter the element value after which you would like to insert the new value: ");
            data = get_attack();
            tmp = search(head,data);
            if(tmp != NULL)
            {
                printf("Enter the value to insert: ");
                data = get_attack();
                head = insert_after(head,data,tmp);
                if(head != NULL)
                    traverse(head);
            }
            else
            {
                printf("Element with value %d not found.",data.id);
            }
            break;
        case 5: // insert after by id 
            printf("Enter the element value before which you would like to insert a new value: ");
            data = get_attack();
            tmp = search(head,data);
            if(tmp != NULL)
            {
                printf("Enter the value to insert: ");
                data = get_attack();
                head = insert_before(head,data,tmp);
 
                if(head != NULL)
                    traverse(head);
            }
            else
            {
                printf("Element with value %d not found.",data.id);
            }
            break;
        case 6:
            head = remove_front(head);
            if(head != NULL)
                traverse(head);
            break;
        case 7:
            head = remove_back(head);
            if(head != NULL)
                traverse(head);
            break;
        case 8: // remove by id?
            printf("Enter the element value to remove: ");
            data = get_attack();
            tmp = search(head,data);
            if(tmp != NULL)
            {
                remove_any(head,tmp);
                if(head != NULL)
                    traverse(head);
            }
            else
            {
                printf("Element with value %d not found.",data.id);
            }
            break;
        case 9:
            head = insertion_sort(head);
            if(head != NULL)
                traverse(head);
            break;
        case 10:
            head = reverse(head);
            if(head != NULL)
                traverse(head);
            break;
        }
 
    } while(command != 0);
    clear(head);
    return 0;
}
