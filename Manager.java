
public class Manager extends Employee {
	
	Manager(int id,String name, String surname, String role){
		super(id,name,surname,role);
	}

	
	@Override
	void displayMenu() {
		System.out.println("\nWelcome "+ this.role.toUpperCase()+ " "+ this.name + " " + this.surname+ ",\n");
		System.out.println("MANAGER MENU");
		System.out.println(
				  " [1] Update Own Profile,\n"
				+ " [2] Display All Employees,\n"
				+ " [3] Display Employees With The Role,\n"
				+ " [4] Display Employee With Username,\n"
				+ " [5] Update Employee Non-Profile Fields,\n"
				+ " [6] Hire Employee,\n"
				+ " [7] Fire Employee,\n"
				+ " [8] Algorithms.\n"
				);
		
	}


	@Override
	void updateownProfile() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
