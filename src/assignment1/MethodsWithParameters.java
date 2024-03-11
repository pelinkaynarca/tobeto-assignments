package assignment1;

public class MethodsWithParameters {

	public static void main(String[] args) {
		String message = "The weather is nice.";
		String newMessage = returnCity();
		System.out.println(newMessage);
		int number = sum(15,7);
		System.out.println(number);
		int sum = sum2(5,8,2);
		System.out.println(sum);
	}
	
	public static void add() {
		System.out.println("Added");
	}
	
	public static void delete() {
		System.out.println("Deleted");
	}
	
	public static void update() {
		System.out.println("Updated");
	}
	
	public static int sum(int number1, int number2) {
		return number1+number2;
	}
	
	// variable arguments
	
	public static int sum2(int... numbers) {
		int sum = 0;
		for(int number:numbers) {
			sum += number;
		}
		return sum;
	}
	
	public static String returnCity() {
		return "Ankara";
	}
}
