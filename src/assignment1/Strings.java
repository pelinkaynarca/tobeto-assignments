package assignment1;

public class Strings {

	public static void main(String[] args) {
		String message = "  The weather is nice.  ";
		System.out.println(message);
		
		/* System.out.println("The length of message is " + message.length());
		System.out.println("5th element is " + message.charAt(4));
		System.out.println(message.concat(" Yahoo!"));
		System.out.println(message.startsWith("b")); // returns boolean
		System.out.println(message.endsWith("."));
		
		char[] chars = new char[6];
		message.getChars(0, 5, chars, 0); // returns a char array
		System.out.println(chars);
		
		System.out.println(message.indexOf('e')); // returns the index of the first "e" found
		System.out.println(message.lastIndexOf('e')); // returns the index of the last "e" found */
		
		String newMessage = message.replace(' ', '-');
		System.out.println(newMessage);
		
		System.out.println(message.substring(4,7)); 
		
		for(String word:message.split(" ")) {
			System.out.println(word);
		}
		
		System.out.println(message.toLowerCase());
		System.out.println(message.toUpperCase());
		
		System.out.println(message.trim()); // removes the leading and trailing spaces
	}

}
