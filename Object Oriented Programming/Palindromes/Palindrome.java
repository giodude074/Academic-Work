package palindromeMidtermV2;

public abstract class Palindrome {
	public static int alphanumericCount = 0;
	private int count;

	public Palindrome() {
		this.count = 0;
	}

	public abstract boolean checkIfPalindrome(String str);
	
	
	public void updateCount() {
		this.count++;
	}
	
	public int getCount() {
		return this.count;
	}

	
	public void setCount(int count) {
		this.count = count;
	}
	
	// this.setNumberOfPalindromes(this.getNumberOfPalindromes()+1);
}