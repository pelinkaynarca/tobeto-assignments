package assignment1;

public class MiniProject1 {

	public static void main(String[] args) {
		int number = 3;
		boolean isPrime = true;
		
		if(number == 1) {
			System.out.println(number + " is not a prime number");
			return;
		}
		
		if(number<1) {
			System.out.println("Unvalid number");
		}
		
		for(int i = 2; i<number; i++) {
			if(number % i == 0) {
				isPrime = false;
			}
		}
		
		if(isPrime) {
			System.out.println(number + " is a prime number");
		}else {
			System.out.println(number + " is not a prime number");
		}
		
	}

}
