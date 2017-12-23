package lab6;

public class MyLinkedListTest {
	  public static void main(String[] args) {
	    MyLinkedList<String> list = new MyLinkedList<String>();

	    list.add("dog");
	    list.add("cat");
	    list.add("person");
	    list.add("rabbit");
	    list.add("child");
	    list.add("mouse");
	    System.out.println(list);

	    list.add(0, "Animals");
	    System.out.println(list);

	    list.remove(3);
	    System.out.println(list);

	    System.out.println(list.isEmpty()+ " List is not Empty");

	    list.remove("child");
	    System.out.println(list);

	    System.out.println("List size: " +list.size());

	    System.out.println(list.contains("person")+ " List does not contain person");

	    System.out.println("Element at index 3 is " + list.get(3));

	    list.set(3,"bunny");
	    System.out.println("Element at index 3 is now bunny: " + list );


	    list.clear();
	    System.out.println("After clearing the list, the list size is " + list.size());
	  }
	}