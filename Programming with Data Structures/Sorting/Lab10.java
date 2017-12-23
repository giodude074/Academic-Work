package labs;

public class Lab10 {
	public static int[] sort(int[] ar) {
		int[] nums = new int[ar.length];

		int min = ar[0];
		int max = ar[0];
		for (int i = 1; i < ar.length; i++) {
			if (ar[i] < min) {
				min = ar[i];
			} else if (ar[i] > max) {
				max = ar[i];
			}
		}

		int[] counts = new int[max - min + 1];

		for (int i = 0; i < ar.length; i++) {
			counts[ar[i] - min]++;
		}

		counts[0]--;
		for (int i = 1; i < counts.length; i++) {
			counts[i] = counts[i] + counts[i - 1];
		}

		for (int i = ar.length - 1; i >= 0; i--) {
			nums[counts[ar[i] - min]--] = ar[i];
		}

		return nums;
	}

	public static void main(String[] args) {

		int[] array = { 333, 4, 620, 7, 6, 81, 44, 23, 5641, 74, 8, 3 };
		System.out.print("Unsorted array is: ");
		for (int i = 0; i < array.length; ++i)
			System.out.print(array[i] + " ");

		System.out.print("\n");
		int[] after = sort(array);
		System.out.print("Sorted: ");
		for (int i = 0; i < after.length; ++i)
			System.out.print(after[i] + " ");

	}
}