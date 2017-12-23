### Specifications:
1) Implement GenericStack using inheritance and java.util.ArrayList. Draw the UML diagram for the classes and then implement GenericStack.

``` 
import java.util.*;

 

class GenericStack<E> extends ArrayList<E>{


/** Push a new element into the top of the stack */

public void push(E value) {

}
 

/** Return and remove the top element from the stack */

public E pop() {

}
 

/** Return the top element from the stack */

public E peek() {

}


/** whether the stack is empty */

public boolean isEmpty() {

}


/** Return the number of elements in the stack */

public int getSize() {

}
```

2)  Implement the following generic method for linear search.

```
public static <E extends Comparable<E>> int linearSearch(E[] list, E key)

{//please implement the body of method here}
```
 

3)  Implement the following generic method for binary search

`public static <E extends Comparable<E>> int binarySearch(E[] list, E key)`

 

4)  Implement the following generic method for selection sort

`public static<E extends Comparable<E>> void selectionSort(E[] list)`