import java.util.Scanner;

public class StartApp {
	
	
	public static void main(String[] args) {
		
		Database obj1 = new Database();
		obj1.displayTable();
		
		displayIntro();
		
		
		
	}
	
	
	public static void displayIntro() {
		
		 boolean resultOperation=true;
		 String operation="";
		 Scanner input= new Scanner(System.in);
		
		String[] welcomeMessage= {
		        "__      _____ _    ___ ___  __  __ ___",
		        "\\ \\    / / __| |  /  _/ _ \\|  \\/  | __|",
		        " \\ \\/\\/ /| _|| |_ | (_|(_) | |\\/| | _| ",
		        "  \\_/\\_/ |___|____\\___\\___/|_|  |_|___|",
		            
		        };
		
		
		 for (String message : welcomeMessage) {
	            System.out.printf("%s%n", message);
	        }
		 
		 
		System.out.println();
	
		System.out.println(
				  " [A] Login to the System,\n"
				+ " [B] Terminate.\n");
			

			do {

				if(!resultOperation){
					System.out.print("Please enter a valid operation character:");

				}else{
					System.out.print("Select the action you want to perform:");
				}
				operation =input.nextLine();
				resultOperation= ((operation.equals("A")) || (operation.equals("B")));
				
			} while (!resultOperation);


			switch (operation) {
				case "A":
					loginScreen();
					break;
				case "B":
					System.exit(0);
	
			}
		 
		
		
	}
	
	public static void loginScreen() {
		Scanner input =new Scanner(System.in);
		Authentication controlObject=new Authentication();
		
		boolean validInput=true;
		String username="";
		String password="";
		
		
		
		
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
		
		
		Employee employee = controlObject.checkRole(username,password);
		
		
		if(employee!=null) {
			employee.displayMenu();
		}
		
		

		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
