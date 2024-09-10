public class AdministrativeAssistant extends Employee implements Hourly {
	
	public int hourPerWeek;
	
	public AdministrativeAssistant(String name, double salary, int hour) { // parameterized constructor
		this.name = name;
		this.salary = salary;
		this.hourPerWeek = hour;
	}

	public int numHour() { // override
		return hourPerWeek;
	}

	public void changeHour(int change) { // override
		this.hourPerWeek = change;
	}

	public void giveRaise(double amountRaise) { // override
		// TODO Auto-generated method stub
		salary = salary + amountRaise;
	}
	
	public void getPaid() {
		cash = cash + (salary * 2 * hourPerWeek);
	}
}