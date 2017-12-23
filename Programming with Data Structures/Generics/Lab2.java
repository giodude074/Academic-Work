package lab2Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;

public class Lab2 {
	public static void main(String[] args) {
		Integer[] ints = { 44, 100, 11, 1, 70, 25 };
		Double[] doubles = { 8.1, 32.7, 4.0, 8.5, 24.1, 80.2, 44.0 };
		Character[] chars = { 'g', 'i', 'o', 'v', 'a', 'n' };
		String[] strings = { "Eevee", "Charmander", "Milotic", "Altaria", "Swellow", "Oshawott" };
		// TEST GENERIC STACK
		System.out.println("GENERIC STACK TEST");
		GenericStack<String> stackStr = new GenericStack<>();
		stackStr.push("Jigglypuff");
		stackStr.push("Rayquaza");
		stackStr.push("Moltres");
		stackStr.push("Pikachu");
		System.out.println("Stack:" + stackStr);
		stackStr.pop();
		System.out.println("Stack with popped item:" + stackStr);
		System.out.print("\n");

		// TEST LINEAR SORT
		// print int array
		System.out.println("LINEAR SORT TEST");
		System.out.println("Integer Array: " + Arrays.toString(ints));
		System.out.println("100 is in index: " + linearSearch(ints, 100));
		System.out.println("Doubles Array: " + Arrays.toString(doubles));
		System.out.println("24.1 is in index: " + linearSearch(doubles, 24.1));
		System.out.println("Character Array: " + Arrays.toString(chars));
		System.out.println("o is in index: " + linearSearch(chars, 'o'));
		System.out.println("String Array: " + Arrays.toString(strings));
		System.out.println("Eevee is in index: " + linearSearch(strings, "Eevee"));
		System.out.print("\n");

		// TEST SELECTION SORT
		System.out.println("SELECTION SORT TEST");
		System.out.print("Sorted Integer array: ");
		selectionSort(ints);
		System.out.print("Sorted Doubles array: ");
		selectionSort(doubles);
		System.out.print("Sorted Character array: ");
		selectionSort(chars);
		System.out.print("Sorted String array: ");
		selectionSort(strings);
		System.out.print("\n");

		// TEST BINARY SEARCH
		System.out.println("BINARY SORT TEST");
		Integer key2 = 44;
		System.out.print(key2 + " is in index: ");
		System.out.println(binarySearch(ints, key2));
		Double key1 = 44.0;
		System.out.print(key1 + " is in index: ");
		System.out.println(binarySearch(doubles, key1));
		Character key0 = 'i';
		System.out.print(key0 + " is in index: ");
		System.out.println(binarySearch(chars, key0));
		String key3 = "Milotic";
		System.out.print(key3 + " is in index: ");
		System.out.println(binarySearch(strings, key3));

		// test extra credit
		System.out.println("\nExtra Credit:");
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("eevee");
		arrayList.add("oshawott");
		arrayList.add("typhosion");
		arrayList.add("arceus");
		arrayList.add("ditto");
		arrayList.add("shuckle");
		arrayList.add("yveltal");
		arrayList.add("ditto");

		// remove duplicates
		System.out.println("\n");
		System.out.println("Stack without duplicates: " + removeDup(arrayList));

		// max
		System.out.println("\n");
		Integer[][] twoDArray = { { 2, 8, 10 }, { 5, 5, 5 }, { 4, 4, 7 }, { 4, 1, 3 } };

		for (int x = 0; x < twoDArray.length; x++) {
			for (int y = 0; y < twoDArray[x].length; y++) {
				System.out.print(twoDArray[x][y] + " "); // prints out
			}
		}
		System.out.println("\nMax value in 2D array: " + max(twoDArray));

		// shuffled
		System.out.println("\n");
		System.out.println("Original Arraylist: " + arrayList);
		shuffle(arrayList);
		System.out.println("Shuffled Arraylist: " + arrayList);

	}

	// 2) Implement the following generic method for linear search.
	// public static <E extends Comparable<E>> int linearSearch(E[] list, E key)
	public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
		for (int i = 0; i < list.length; i++)
			if (key.compareTo(list[i]) == 0)
				return i;
		return -1;
	}

	// 4) Implement the following generic method for selection sort
	// public static<E extends Comparable<E>> void selectionSort(E[] list)

	public static <E extends Comparable<E>> void selectionSort(E[] list) {

		for (int i = 0; i < list.length - 1; i++) {
			E min = list[i];// objects of unknown type inside of list
			int minIndex = i;//

			for (int low = i + 1; low < list.length; low++) {
				if (min.compareTo(list[low]) > 0) {
					min = list[low];
					minIndex = low;
				}
			}

			if (minIndex != i) {
				list[minIndex] = list[i];
				list[i] = min;
			}
		}
		System.out.println(Arrays.toString(list));
	}

	// 3) Implement the following generic method for binary search
	// public static <E extends Comparable<E>> int binarySearch(E[] list, E key)
	public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
		int low = 0;
		int high = list.length - 1;

		while (high >= low) { // these are indexes, they are ints by default,
								// that will never change, no matter what your
								// type
			int mid = (low + high) / 2;
			if (key.compareTo(list[mid]) < 0)
				high = mid - 1;
			else if (key.compareTo(list[mid]) == 0)

				return mid;
			else
				low = mid + 1;
		}
		return -1;
	}
	// Extra Credit

	// 5) (5pts) public static <E> ArrayList<E> removeDup(ArrayList<E> list)
	public static <E> ArrayList<E> removeDup(ArrayList<E> list) {
		ArrayList<E> newArray = new ArrayList<E>();
		for (E object : list) {
			if (!newArray.contains(object))
				newArray.add(object);
		}
		return newArray;
	}

	// 6) (5 pts) public static <E extends Comparable<E>> E max(E[][] list)
	public static <E extends Comparable<E>> E max(E[][] list) {
		E max = list[0][0];
		for (E[] i : list) // index in list
			for (E j : i)
				if (j.compareTo(max) > 0)
					max = j;
		return max;
	}

	// 7) (5 pts) public static <E> void shuffle(ArrayList<E> list)
	public static <E> void shuffle(ArrayList<E> list) {
		Random rand = new Random();
		for (int i = 0; i < list.size(); i++) {
			int r = rand.nextInt(list.size());
			Collections.swap(list, i, r);
		}
	}
