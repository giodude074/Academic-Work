package lab1;

import java.util.Arrays;

public class QuestionThreeFour {
	
	public static void main(String[] args) {
		int[] list = {4, 5, 6, 9, 44, 1, 100,3};
		int key = 9;
		selectionSort(list);
		System.out.println(binarySearch(list,key));
	}

	public static void selectionSort(int[] list) {
	    for (int i = 0; i < list.length; i++) {
	      int min = list[i];
	      int minIndex = i;
	      for (int low = i + 1; low < list.length; low++) {
	        if (list[low] < min) {
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

	public static int binarySearch(int[] list, int key) {
		  int low = 0;
		  int high = list.length - 1;

		  while (high >= low) {
		    int mid = (low + high) / 2;
		    if (key < list[mid])
		      high = mid - 1;
		    else if (key == list[mid])

		      return mid;
		    else
		      low = mid + 1;
		  }
		  return -1;
		}
}