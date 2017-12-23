package lab5;

public class Lab5 {
	public static void main(String args[]) {

		Integer[] list = { 2, 3, 2, 5, 6, 1, -2, 3, 14, 12 };

		System.out.print("Unsorted list:  ");
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
		insertionSort(list);
		System.out.println("\nInsertion sort: ");
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
		bubbleSort(list);
		 System.out.println("\nbubble sort: ");
		 for (int i = 0; i < list.length; i++)
		 System.out.print(list[i] + " ");
		mergeSort(list);
		 System.out.println("\nmerge sort: ");
		 for (int i = 0; i < list.length; i++)
		 System.out.print(list[i] + " ");
		 heapSort(list);
		 System.out.println("\nheap sort: ");
		 for (int i = 0; i < list.length; i++)
		 System.out.print(list[i] + " ");
	}
	// 1. (5 pts) Implement generic insertion sort
	public static <E extends Comparable<E>> void insertionSort(E[] list) {
		for (int i = 1; i < list.length; i++) {
			E currentElement = list[i];
			int k;
			for (k = i - 1; k >= 0 && list[k].compareTo(currentElement) > 0; k--) {
				list[k + 1] = list[k];
			}
			list[k + 1] = currentElement;
		}
	}

	// 2. (5) Implement generic bubble sort
	public static <E extends Comparable<E>> void bubbleSort(E[] list) {
		boolean needNextPass = true;

		for (int k = 1; k < list.length && needNextPass; k++) {
			needNextPass = false;
			for (int i = 0; i < list.length - k; i++) {
				if (list[i].compareTo(list[i + 1]) > 0) {
					E temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
					needNextPass = true;
				}
			}
		}
	}

	// 3. (5) Implement generic merge sort
	public static <E extends Comparable<E>> void mergeSort(E[] list) {
		if (list.length > 1) {
			// Merge sort the first half
			E[] firstHalf = (E[]) new Comparable[list.length / 2]; //casting
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			mergeSort(firstHalf);

			// Merge sort the second half
			int secondHalfLength = list.length - list.length / 2;
			E[] secondHalf = (E[]) new Comparable[secondHalfLength];
			System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf);

			// Merge firstHalf with secondHalf into list
			merge(firstHalf, secondHalf, list);
		}
	}

	/** Merge two sorted lists */
	public static <E extends Comparable<E>> void merge(E[] list1, E[] list2, E[] temp) {
		int current1 = 0; // Current index in list1
		int current2 = 0; // Current index in list2
		int current3 = 0; // Current index in temp

		while (current1 < list1.length && current2 < list2.length) {
			if (list1[current1].compareTo(list2[current2]) < 0)
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
		}

		while (current1 < list1.length)
			temp[current3++] = list1[current1++];

		while (current2 < list2.length)
			temp[current3++] = list2[current2++];
	}

	  //4. (5) Implement generic heap sort
	public static <E extends Comparable<E>> void heapSort(E[] list){
		int count = list.length;

		heapify(list, count);

		int end = count - 1;
		while(end > 0){
			E tmp = list[end];
			list[end] = list[0];
			list[0] = tmp;
			siftDown(list, 0, end - 1);
			end--;
		}
	}

	public static <E extends Comparable<E>> void heapify(E[] list, int count){
		int start = (count - 2) / 2;

		while(start >= 0){
			siftDown(list, start, count - 1);
			start--;
		}
	}

	public static <E extends Comparable<E>> void siftDown(E[] list, int start, int end){
		int root = start;

		while((root * 2 + 1) <= end){
			int child = root * 2 + 1;
			if((child + 1 <= end) && ((list[child].compareTo(list[child + 1]) < 0)))
				child = child + 1;
			if(list[root].compareTo(list[child]) < 0){
				E tmp = list[root];
				list[root] = list[child];
				list[child] = tmp;
				root = child;
			}else
				return;
		}
	}
}
