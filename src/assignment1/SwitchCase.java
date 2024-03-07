package assignment1;

public class SwitchCase {

	public static void main(String[] args) {
		char grade = 'B';

		switch (grade) {
		case 'A':
			System.out.println("Excellent: Passed");
			break;
		case 'B':
		case 'C':
			System.out.println("Good: Passed"); // both for b and c case, you get the same output
			break;
		case 'D':
			System.out.println("Fair: Passed");
			break;
		case 'F':
			System.out.println("Poor: Failed");
			break;
		default:
			System.out.println("Unvalid grade");
		}
	}

}
