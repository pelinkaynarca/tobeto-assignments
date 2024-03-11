package assignment1;

public class Methods {

	public static void main(String[] args) {
		findNumber();
	}
	
	public static void findNumber() {
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
			showMessage(numberToFind + " is present.");
		}else {
			showMessage(numberToFind + " is not present.");
		}
	}
	
	public static void showMessage(String message) {
		System.out.println(message);
	}

}
