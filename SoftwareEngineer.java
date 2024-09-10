public class SoftwareEngineer extends Employee {
	
	public SoftwareEngineer(String name, double salary) { // parameterized constructor
		this.name = name;
		this.salary = salary;
		this.cash = 0;
	}

	public void giveRaise(double percentage) { // override 
		salary = salary + (salary * percentage / 100);
	}	
}
