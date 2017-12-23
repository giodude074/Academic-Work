package palindromeMidtermV2;

public class NumericPalindrome extends Palindrome {
	public NumericPalindrome() {
		super();
	}

	@Override
	public boolean checkIfPalindrome(String string) {
		try {
			Double.parseDouble(string); //checks to see it its numbers
			int x = 0, y = string.length()-1;
			while(y > x)
				if(string.charAt(x++) != string.charAt(y--))
					return false;
			this.updateCount(); //checks each line and adds 1 to the current # of palendromes it has detected
			alphanumericCount++;
			return true;
		} catch(NumberFormatException e) { // not numeric if it gives you an exception
			return false;
		}
	}
}