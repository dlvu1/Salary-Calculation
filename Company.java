// CSC205AB 35564 (Mon 5-7:00 PM)
// Program 1
// Duyen Vu 36510904
// model a company employee tracking system
import java.util.*;
public class Company {
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		Employee[] employ = new Employee[5];
		int numEmployee = 0;
		char input;
		int change;
			
	char menu; 
	do { 
		System.out.println("What do you want to do?");
		System.out.println("A. Add an Employee");
		System.out.println("B. List all Employees");
		System.out.println("C. Give an Employee a Raise");
		System.out.println("D. Give Paychecks");
		System.out.println("E. Change someones hours");
		System.out.println("F. Quit");
		menu = scnr.next().toLowerCase().charAt(0); 
		scnr.nextLine();
	switch (menu) {
	
	case 'a': // user enter a
		System.out.println("What is their name?");
		String name = scnr.nextLine();
		System.out.println("What is their salary (yearly or hourly)?");
		double salary = scnr.nextDouble();
		System.out.println("Are they an hourly worker? (Y/N)"); 
		input = scnr.next().charAt(0);
		if (input == 'Y' || input == 'y') { // user type y if they are an hourly worker
			System.out.println("How many hours per week do they work?");
			int hour = scnr.nextInt();
			Employee e = new AdministrativeAssistant(name, salary, hour);
			employ[numEmployee++] = e;
			System.out.println(name + " was hired!");
		} else if (input == 'N' || input == 'n') { // user type n if they are not an hourly worker
			Employee e = new SoftwareEngineer(name, salary);
			employ[numEmployee++] = e;
			System.out.println(name + " was hired!");
		} else {
			System.out.println("Error! please retype:"); 
		} break;
		
	case 'b': // user enter b
		if(numEmployee == 0) { 
		System.out.println("Nobody works here!");
		} else {
			for(Employee e : employ) {
				if (e == null) 
					break;
			System.out.println(e.getName() + " Salary: " + e.getSalary() + " Cash: " + e.getCash() + ((e instanceof SoftwareEngineer) ? " Software Engineer" : " Adminstrative Assistant"));
			} 
		} break;
	
	case 'c': // user enter c
		System.out.println("Who do you want to give a raise to?"); 
		String userName = scnr.nextLine(); // user enter a name that user want to give a raise
		boolean a = false;
		for (int i = 0; i < numEmployee; i++) {
			if (employ[i].getName().equals(userName)) {
				System.out.println("What raise do you want to give them?"); 
				double amount = scnr.nextDouble(); // user enter the amount
				employ[i].giveRaise(amount); // set a raise amount for employees
				a = true;
			}
		} if (a == true) {
			System.out.println(userName + " is happy!");
		} else {
			System.out.println(userName + " is not found");
		} break;
	
	case 'd': // user enter d
		if(numEmployee == 0) {
			System.out.println("Nobody works here!");
		} else {
			for (Employee e:employ) {
				if (e == null) {
					break;
				} e.getPaid(); 
			}
			System.out.println("Hooray for money!");
		} break;
	
	case 'e':
		if(numEmployee == 0) {
			System.out.println("Nobody works here!");
		}
		System.out.println("Change hours for who?"); 
		name = scnr.nextLine(); // user enter a name that user want to change hour
		for (Employee t: employ) {
			if (t == null) 
				break;
		if (t instanceof AdministrativeAssistant && t.getName().equalsIgnoreCase(name)) {
			System.out.println(t.getName() + " currently works " + ((AdministrativeAssistant)t).numHour() + " hours per week. What would you like to change it to?");
			change = scnr.nextInt();
			((AdministrativeAssistant)t).changeHour(change);
			System.out.println(t.getName() + " will now work " + ((AdministrativeAssistant)t).numHour() + " hours per week"); // print the new hour and the user's name
			break;
		}
		} break;
	
	case 'f':
		System.out.println("Bye!");
		break;
	
	default:
		System.out.println("Invalid option"); // print invalid when user enter wrong char
		break;
	} 
} while (menu != 'f');
}
}
	
