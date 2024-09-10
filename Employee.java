public abstract class Employee {
	
	protected String name;
	protected double cash;
	protected double salary;
	
	public String getName() { 
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public double getCash() {
		return cash;
	}
	
	public void getPaid() { // void method with no return
		cash = cash + (salary / 26);
	}
	
	public abstract void giveRaise(double percentage); // abstract method

}
