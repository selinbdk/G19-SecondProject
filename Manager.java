public class Manager extends Employee {
    Manager(int id,String name, String surname, String role){
		super(id,name,surname,role);
	}

	
	@Override
	void displayMenu() {
		System.out.println("Welcome "+ this.name + " " + this.surname+ ",\n");
		System.out.println("MANAGER MENU");
		System.out.println(
				  " [1] Update Own Profile,\n"
				+ " [2] Display All Employees,\n"
				+ " [3] Update Employee Non-Profile Fields,\n"
				+ " [4] Hire Employee,\n"
				+ " [5] Fire Employee,\n"
				+ " [6] Algorithms.\n"
				);
		
	}
	


    
}
