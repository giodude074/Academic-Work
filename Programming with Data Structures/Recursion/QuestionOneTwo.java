package lab1;

public class QuestionOneTwo {
	public static void main(String[] args) {
		reverseDisplay(26513);
		String value = ("!olleH");
		reverseDisplay(value);
	}

	// reverse int
	public static void reverseDisplay(int value) {
		if (value < 10)
			System.out.println(value);
		else {
			System.out.println(value % 10);
			reverseDisplay(value / 10);
		}
	}

	// reverse string
	public static void reverseDisplay(String value){
		if (value.length()==0){
			System.out.println(value);
		}else{
			System.out.print(value.charAt(value.length()-1));
			reverseDisplay(value.substring(0,value.length()-1));
		}
	}
}