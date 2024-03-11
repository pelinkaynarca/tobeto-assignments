package assignment1;

public class MiniProject3 {

	public static void main(String[] args) {
		// ex. 6-> 1,2,3
		// ex. 28-> 1,2,4,7,14
		int number = 28;
		int total = 0;
		
		for(int i=1; i<number; i++) {
			if(number % i == 0) {
				total += i;
			}
		}
		
		if(total == number) {
			System.out.println("It'a prime number");
		}else {
			System.out.println("It's not a prime number");
		}
		
	}

}
