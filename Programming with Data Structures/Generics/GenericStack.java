package lab2Generics;
import java.util.*;

public class GenericStack<E> extends ArrayList<E>{
	
	  public void push(E o) {
	    this.add(o); //has a method,checks supr class to see if there is a add method and uses it.
	  }

	  public E pop() {
	    E o = this.get(getSize() - 1);
	    this.remove(getSize() - 1);
	    return o;
	  }

	  public E peek() {
	    return this.get(getSize() - 1);
	  }

	  @Override
	  public boolean isEmpty() {
	    return super.isEmpty();
	  }

	  public int getSize() {
	    return this.size();
	  }

	}