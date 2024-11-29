
public abstract class Employee {
	
	protected int id;
	protected String name;
	protected String surname;
	protected String role;
	
	
	Employee(int id,String name, String surname, String role){
		this.id=id;
		this.name=name;
		this.surname=surname;
		this.role=role;
		
	}
	
	abstract void displayMenu();
	
	abstract void updateOwnProfile();
	
	

}
