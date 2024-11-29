
public class RegularEmployee extends Employee {
	
	RegularEmployee(int id,String name, String surname, String role){
		super(id,name,surname,role);
	}

	@Override
	void displayMenu() {
		System.out.println("Welcome "+ this.role.toUpperCase() +  " " + this.name + " " + this.surname+ ",\n");
		System.out.println("REGULAR EMPLOYEE MENU");
		System.out.println(
				  " [1] Display own profile,\n"
				+ " [2] Display own non profile,\n"
				+ " [3] Update Own Profile,\n"
				+ " [4] Logout,\n"
				);
		
	}
	
	
	

}
