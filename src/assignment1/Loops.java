package assignment1;

public class Loops {

	public static void main(String[] args) {
		// for
		for(int i=2; i<=10; i+=2) {
			System.out.println(i);
		}
		System.out.println("for loop has ended");
		
		/*  while infinite loop
		int i = 1;
		while(i<10) {
			System.out.println(i);
		}
		System.out.println("while loop has ended"); */
		
		// while loop
		int i = 1;
		while(i<10) {
			System.out.println(i);
			i+=2;
		}
		System.out.println("while loop has ended");
		
		// do-while loop - initially the loop body is executed at least one time and only after that while condition is checked
		int j = 100;
		do {
				System.out.println(j);
				j+=2;
		}while(j<10);
		System.out.println("do-while loop has ended");
	}

}
