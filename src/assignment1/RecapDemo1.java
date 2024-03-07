package assignment1;

public class RecapDemo1 {

	public static void main(String[] args) {
		int number1 = 24;
		int number2 = 25;
		int number3 = 2;
		int theGreatestNumber = number1;
		
		if(theGreatestNumber < number2) {
			theGreatestNumber = number2;
		}
		
		if(theGreatestNumber < number3) {
			theGreatestNumber = number3;
		}
		
		System.out.println("The greatest number is " + theGreatestNumber);
		 
	}

}
