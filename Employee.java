
public abstract class Employee {
	
	protected int id;
	protected String username;
	protected String name;
	protected String surname;
	protected String role;
	
	
	Employee(int id,String username,String name, String surname, String role){
		this.id=id;
		this.username=username;
		this.name=name;
		this.surname=surname;
		this.role=role;
		
	}
	
	abstract void displayMenu();
	
	abstract void updateOwnProfile();
	
	

}
