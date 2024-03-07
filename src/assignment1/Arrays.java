package assignment1;

public class Arrays {

	public static void main(String[] args) {
		String student1 = "Matt";
		String student2 = "Joe";
		String student3 = "Chloe";
		
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student3);
		
		System.out.println("---------------");
		
		String[] students = new String[3];
		students[0] = "Matt";
		students[1] = "Joe";
		students[2] = "Chloe";
		
		for(int i=0; i<students.length; i++) {
			System.out.println(students[i]);
		}
		
		System.out.println("---------------");
		
		for(String student:students) {
			System.out.println(student);
		}
	}

}
