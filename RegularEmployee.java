import java.util.Scanner;

public class RegularEmployee extends Employee {
	
	RegularEmployee(int id,String name, String surname, String role){
		super(id,name,surname,role);
	}

	@Override
	void displayMenu() {
		
		System.out.println("\nWelcome "+ this.role.toUpperCase() +  " " + this.name + " " + this.surname+ ",\n");
		System.out.println("REGULAR EMPLOYEE MENU");
		System.out.println(
				  " [1] Display own profile,\n"
				+ " [2] Display own non profile,\n"
				+ " [3] Update Own Profile,\n"
				+ " [4] Logout,\n"
				);
		
		 boolean operationResult=true;
		 String operation="";
		 Scanner input1= new Scanner(System.in);

		do {

			if(!operationResult){
				System.out.print("Please enter a valid operation character:");

			}else{
				System.out.print("Select the action you want to perform:");
			}
			operation =input1.nextLine();
			operationResult= ((operation.equals("1")) || (operation.equals("2")) || (operation.equals("3")) || (operation.equals("4")));
			
		} while (!operationResult);


		switch (operation) {
			case "1":
			displayOwnProfile();
				break;
			case "2":
			displayOwnNonProfile();
				break;
			case "3":
			updateOwnProfile();
				break;
			case "4":
			StartApp.displayIntro();
				break;
			

		}
		
	}
	
	

	@Override
	void updateOwnProfile() {
		// TODO Auto-generated method stub
		
	}
	

	
	void displayOwnProfile() {
	
		Authentication authentication = new Authentication();
		authentication.displayProfileInfo(this.id);
		
		 String restartOperation="";
	 		boolean isValidAnswer=true;
	 		Scanner input2= new Scanner(System.in);
	 		do {
	 			
	 			if(isValidAnswer==true) {
	 				System.out.print("\nIf you want to return to the previous menu, type (Y):");
	 	
	 			}else {
	 				System.out.print("Please enter valid letter:");
	 			}
	 			
	 			restartOperation= input2.nextLine();
	 	
	 			
	 			if(restartOperation.equals("Y")) {
	 				displayMenu();
	 				isValidAnswer=true;
	 				
	 			}
	 			else {
	 				isValidAnswer=false;
	 			}
	 		
	
	 		}while(!isValidAnswer);
	 		
		
	}
	
	void displayOwnNonProfile() {
		
		Authentication authentication = new Authentication();
		authentication.displayNonProfileInfo(this.id);
		
		 String restartOperation="";
	 		boolean isValidAnswer=true;
	 		Scanner input2= new Scanner(System.in);
	 		do {
	 			
	 			if(isValidAnswer==true) {
	 				System.out.print("\nIf you want to return to the previous menu, type (Y):");
	 	
	 			}else {
	 				System.out.print("Please enter valid letter:");
	 			}
	 			
	 			restartOperation= input2.nextLine();
	 	
	 			
	 			if(restartOperation.equals("Y")) {
	 				displayMenu();
	 				isValidAnswer=true;
	 				
	 			}
	 			else {
	 				isValidAnswer=false;
	 			}
	 		
	
	 		}while(!isValidAnswer);
	 		
		
	
		
			
			
	}

	
	
	

}
