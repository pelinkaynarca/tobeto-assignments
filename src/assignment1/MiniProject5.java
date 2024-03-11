package assignment1;

public class MiniProject5 {

	public static void main(String[] args) {
		int[] numbers = new int[] {1,2,5,7,9,0};
		int numberToFind = 6; 
		boolean isPresent = false;
		
		for(int number:numbers) {
			if(number == numberToFind) {
				isPresent = true;
				break;
			}
		}
		if(isPresent) {
			System.out.println("The number is present.");
		}else {
			System.out.println("The number is not present.");
		}
	}

}
