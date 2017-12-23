package hw6;

public class SortingExecutionTime {
	public static void randomlyFillArray(Integer[] array, int start, int end) {
		for (int i = 0; i < array.length; i++) {
			array[i] = randomInt(start, end);
		}
	}

	public static int randomInt(int start, int end) { // oneTo10
		return (int) (start + Math.random() * (end - start + 1));

	}

	// f insertion sort, bubble sort,
	// selection sort, merge sort, quick sort, and heap sort
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

	public static <E extends Comparable<E>> void selectionSort(E[] list) {

		for (int i = 0; i < list.length - 1; i++) {
			E min = list[i];// objects of unknown type inside of list
			int minIndex = i;

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
	}

	public static <E extends Comparable<E>> void mergeSort(E[] list) {
		if (list.length > 1) {
			E[] firstHalf = (E[]) new Comparable[list.length / 2]; // casting
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			mergeSort(firstHalf);

			int secondHalfLength = list.length - list.length / 2;
			E[] secondHalf = (E[]) new Comparable[secondHalfLength];
			System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf);

			merge(firstHalf, secondHalf, list);
		}
	}

	public static <E extends Comparable<E>> void merge(E[] list1, E[] list2, E[] temp) {
		int current1 = 0;
		int current2 = 0;
		int current3 = 0;

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

	public static <E extends Comparable<E>> void heapSort(E[] list) {
		int count = list.length;
		heapify(list, count);
		int end = count - 1;
		while (end > 0) {
			E tmp = list[end];
			list[end] = list[0];
			list[0] = tmp;
			siftDown(list, 0, end - 1);
			end--;
		}
	}

	public static <E extends Comparable<E>> void heapify(E[] list, int count) {
		int start = (count - 2) / 2;
		while (start >= 0) {
			siftDown(list, start, count - 1);
			start--;
		}
	}

	public static <E extends Comparable<E>> void siftDown(E[] list, int start, int end) {
		int root = start;
		while ((root * 2 + 1) <= end) {
			int child = root * 2 + 1;
			if ((child + 1 <= end) && ((list[child].compareTo(list[child + 1]) < 0)))
				child = child + 1;
			if (list[root].compareTo(list[child]) < 0) {
				E tmp = list[root];
				list[root] = list[child];
				list[child] = tmp;
				root = child;
			} else
				return;
		}
	}

	public static void main(String[] args) {
		System.out.println("Execution time:\n");
		for (int num : new int[] { 50000, 100000, 150000, 200000, 250000, 300000 }) {
			for (int i = 0; i < 5; i++) {
				String sort = null;
				Integer[] array = new Integer[num];
				randomlyFillArray(array, 1, 100); // randomly fill from 1 to 100
				long startTime = System.currentTimeMillis();
				if (i == 0) {
					sort = "insertionSort";
					insertionSort(array);
				} else if (i == 1) {
					sort = "bubbleSort";
					bubbleSort(array);
				} else if (i == 2) {
					sort = "SelectionSort";
					selectionSort(array);
				} else if (i == 3) {
					sort = "mergeSort";
					mergeSort(array);
				} else if (i == 4) {
					sort = "heapSort";
					heapSort(array);
				}

				long stopTime = System.currentTimeMillis();
				long executionTime = stopTime - startTime;
				System.out.println(sort + "- Array of " + num + " integers: " + executionTime + " ms");
			}
		}
	}
}