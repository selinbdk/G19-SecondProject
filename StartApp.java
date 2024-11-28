import java.util.Scanner;

public class StartApp {

    
	public static void main(String[] args) {
		
		Database obj1 = new Database();
		obj1.displayTable();
		
		loginScreen();
		
		
	}
	
	
	public static void displayIntro() {
		
		String[] welcomeMessage= {
		        "__      _____ _    ___ ___  __  __ ___",
		        "\\ \\    / / __| |  /  _/ _ \\|  \\/  | __|",
		        " \\ \\/\\/ /| _|| |_ | (_|(_) | |\\/| | _| ",
		        "  \\_/\\_/ |___|____\\___\\___/|_|  |_|___|",
		            
		        };
		
		
		 for (String message : welcomeMessage) {
	            System.out.printf("%s%n", message);
	        }
		
	}
	
	public static void loginScreen() {
		Scanner input =new Scanner(System.in);
		Authentication controlObject=new Authentication();
		
		boolean validInput=true;
		String username="";
		String password="";
		int id=0;
		String name="";
		String surname="";
		String role="";
		
		
		
		String[] loginMessage= {
		
		 " _    ___   ___ ___ _  _", 
		 "| |  / _ \\ / __|_ _| \\_ | ",
		 "| |_| (_) | (_ || ||    | ",
		 "|___ \\___/\\___ |___|_|\\_|",
		
		
		};
		
		 for (String message : loginMessage) {
	            System.out.printf("%s%n", message);
	        }
		
		
		
		
		
		do{
			if(validInput==true) {
				System.out.println("\nPlease enter your username and password to login system.");
				System.out.print("Username:");
				 username= input.nextLine();
				System.out.print("Password:");
				 password= input.nextLine();
				validInput= controlObject.checkValidLogin(username, password);
				
			}else {
				System.out.println("\nYou entered the wrong username or password. Please enter again.");
				System.out.print("Username:");
				username= input.nextLine();
				System.out.print("Password:");
				password= input.nextLine();
				validInput= controlObject.checkValidLogin(username, password);
				
			}
			
		}while(!validInput);
		
		
		Employee manager = controlObject.checkRole(username,password);
		
		if(manager.role.equalsIgnoreCase("manager")) {
			manager.displayMenu();
			
		}else {
			Employee regularEmployee = controlObject.checkRoleForRegular(username, password);
			regularEmployee.displayMenu();
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	




















    
}
