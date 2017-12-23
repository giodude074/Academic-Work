package lab4;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Lab4 {
	public static void main(String args[]) {
		// (5 pts) Problem Definition: Write a program that reads an unspecified
		// number of integers and finds the one that has the most occurrences. The
		// input ends when the input is 0. For example, if you entered 2 3 4 3 42 3 4 3 3 0. the number 3 occurred most often. If not one but several numbers
		// have the most occurrences, all of them should be reported.

		ArrayList<Integer> nums = new ArrayList<>();
		TreeMap<Integer,Integer> tree = new TreeMap<>(); //key, value
		Scanner input = new Scanner(System.in);
		System.out.println("How many integers would you like to input?");
		int size = input.nextInt();
		System.out.println("Enter a integers: ");
		for (int i = 0; i < size; i++) {
			int num = input.nextInt();
			nums.add(num); //adding input to arrayList
		}
		if(!nums.get(nums.size()-1).equals(0)) {
			System.out.println("Your last index has to be 0 ");
			getTime(10);
			getTime(20);
			getTime(40);
			return;
		}else{
			for(Integer num: nums){
				tree.put(num, 0);
			}//added them to tree
			for(Integer num: nums)
				tree.put(num, tree.get(num) +1);
			Integer key=0, max=0;
			for(Integer num: tree.keySet()) {
				if(tree.get(num).compareTo(max) > 0){
					max = tree.get(num);
					key = num;
				}
			}

			System.out.println(tree);
			System.out.println("Number that repeats the most: "+ key);

			getTime(10);
			getTime(20);
			getTime(40);
		}
	}

	public static long fib(long n) {
		long f0 = 0; // For fib(0)
		long f1 = 1; // For fib(1)
		long f2 = 1; // For fib(2)

		if (n == 0)
			return f0;
		else if (n == 1)
			return f1;
		else if (n == 2)
			return f2;

		for (int i = 3; i <= n; i++) {
			f0 = f1;
			f1 = f2;
			f2 = f0 + f1;
		}

		return f2;
	}

	public static long rfib(long index) {
		if (index == 0) // Base case
			return 0;
		else if (index == 1) // Base case
			return 1;
		else // Reduction and recursive calls
			return rfib(index - 1) + rfib(index - 2);
	}

	public static void getTime(int n) {
		long startTime = System.currentTimeMillis();
		fib(n);
		long endTime = System.currentTimeMillis();
		System.out.println("Dynamic: Fib(" + n + ") Execution Time: " + (endTime - startTime) + " ms");
		startTime = System.currentTimeMillis();
		rfib(n);
		endTime = System.currentTimeMillis();
		System.out.println("Recursive: Fib(" + n + ") Execution Time: " + (endTime - startTime) + " ms");
	}
}