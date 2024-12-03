import java.util.Scanner;

public class Manager extends Employee {
	
	Manager(int id,String username,String name, String surname, String role){
		super(id,username,name,surname,role);
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
				+ " [9] Logout,\n"
				);
		
		

		 boolean result=true;
		 String operation="";
		 Scanner input1= new Scanner(System.in);

		do {

			if(!result){
				System.out.print("Please enter a valid operation character:");

			}else{
				System.out.print("Select the action you want to perform:");
			}
			operation =input1.nextLine();
			result= ((operation.equals("1")) || (operation.equals("2")) || (operation.equals("3")) || (operation.equals("4"))|| (operation.equals("5")) || (operation.equals("6")) || (operation.equals("7")) || (operation.equals("8"))|| (operation.equals("9")));
			
		} while (!result);


		switch (operation) {
			case "1":
				updateOwnProfile();
				break;
			case "2":
				MenuOperations operations2 = new MenuOperations();
				operations2.displayAllEmployees();
				returnPreviousMenu();
				break;
			case "3":
				roleForView();
				returnPreviousMenu();
				break;
			case "4":
				MenuOperations operations4 = new MenuOperations();
				operations4.displayEmployeesWithUsername();
				returnPreviousMenu();
				break;
				
			case "5":
				MenuOperations operations5 = new MenuOperations();
				operations5.updateEmployeeNonProfile();
				returnPreviousMenu();
				break;
			case "6":
				MenuOperations operations6 = new MenuOperations();
				operations6.hireEmployee();
				returnPreviousMenu();
				break;
			case "7":
				MenuOperations operations7 = new MenuOperations();
				operations7.fireEmployee(this.username);
				returnPreviousMenu();
				break;
			case "8":
				MenuOperations operations8 = new MenuOperations();
				operations8.algorithms();
				returnPreviousMenu();
				break;
			case "9":
				StartApp.displayIntro();
				break;
			

		}
		

	}
	
	
	

	public void roleForView() {
		
		MenuOperations operations3 = new MenuOperations();
		Scanner scanner3= new Scanner(System.in);
		System.out.print("\nPlease enter the role you want to view:");
		String desiredRole=scanner3.nextLine();
		if(desiredRole.equalsIgnoreCase("manager")) {
			operations3.displayEmployeesWithRole("manager");
		}else if(desiredRole.equalsIgnoreCase("engineer")) {
			operations3.displayEmployeesWithRole("engineer");
			
		}
		else if(desiredRole.equalsIgnoreCase("technician")) {
			operations3.displayEmployeesWithRole("technician");
			
		}else if(desiredRole.equalsIgnoreCase("intern")) {
			operations3.displayEmployeesWithRole("intern");
			
		}else {
			System.out.println("\nPlease enter a valid role.");
			roleForView();
		}
		

		
	}


	@Override
	void updateOwnProfile() {
		
		MenuOperations operations = new MenuOperations();
		
		
		System.out.println("UPDATE YOUR PROFILE");
		System.out.println(
				  " [1] Update Password,\n"
				+ " [2] Update Phone Number,\n"
				+ " [3] Update Email,\n"
				+ " [4] Update All Of The Profile Fields,\n"
				+ " [5] Return Previous Menu,\n"
				);
		
		 boolean operationResult=true;
		 String operation="";
		 Scanner input3= new Scanner(System.in);

		do {
			
			if(!operationResult){
				System.out.print("Please enter a valid operation character:");

			}else{
				System.out.print("Choose the field that needs to be updated:");
			}
			operation =input3.nextLine();
			operationResult= ((operation.equals("1")) || (operation.equals("2")) || (operation.equals("3")) || (operation.equals("4")|| (operation.equals("5"))));
			
		} while (!operationResult);


		switch (operation) {
		
			case "1":
			case1();
				break;
				
			case "2":
			case2();
				break;
				
			case "3":
			case3();
				break;

			case "4":
			case4();
				break;
				
			case "5":
				displayMenu();
				break;
			
		}
		
	
	
	
	}
	


	public void case1() {
		MenuOperations operations1 = new MenuOperations();
		Scanner input1= new Scanner(System.in);
		
		System.out.print("Please enter your new password:");
		String updatedPassword=input1.nextLine();
		operations1.updateField(this.id, "employee_password", updatedPassword);
		System.out.println("\nThe field has been updated successfully.");
		

		returnUpdateMenu();
		
		
	}


	public void case2() {
		MenuOperations operations2 = new MenuOperations();
		Scanner input2= new Scanner(System.in);
	
		 boolean isAnswerValid=true;
	     String updatedPhoneNumber="";
	     long number;
	        
	        do {
	            try {
	            	
		        	if(isAnswerValid==false) {
		        		System.out.println("Please enter a valid phone number:");
		        		
		        	}
		        	else {
		        		System.out.println("Please enter your new phone number:");
		        	}
		        	
		        	updatedPhoneNumber=input2.nextLine();
		        	 number= Long.parseLong(updatedPhoneNumber);
		        	 
		        	 if(number<=0) {
		        		 isAnswerValid=false;
		        		 
		        	 }else {
		        		 isAnswerValid=true;
		        	 }
		        	 
	            	}catch(NumberFormatException e) {
	            		System.out.println(e);
	            		isAnswerValid=false;
	            	
	            	}
	            
	        } while (!isAnswerValid);
		

		
		operations2.updateField(this.id, "phone_no", updatedPhoneNumber);
		System.out.println("\nThe field has been updated successfully.");
		
		returnUpdateMenu();
		
		
		
	}


	public void case3() {
		MenuOperations operations3 = new MenuOperations();
		Scanner input3= new Scanner(System.in);
		
		System.out.print("Please enter your new email:");
		String updatedEmail=input3.nextLine();
		operations3.updateField(this.id, "email", updatedEmail);
		System.out.println("\nThe field has been updated successfully.");
		
		returnUpdateMenu();
		
		
	}


	public void case4() {
		MenuOperations operations4 = new MenuOperations();
		Scanner input4= new Scanner(System.in);
		
		System.out.print("Please enter your new password:");
		String newPassword=input4.nextLine();
		

	    String newPhoneNumber="";
	    long numberVersion;
	        
	        
	            try {
	            	
		        	System.out.println("Please enter your new phone number:");
		      
		        	newPhoneNumber=input4.nextLine();
		        	numberVersion= Long.parseLong(newPhoneNumber);
		        	 
		        	 if(numberVersion<=0) {
		        		 System.out.println("You entered an invalid number. You will be directed to the beginning.");
		        		 case4();
		        		 
		        	 }
		        	
		        	 
	            	}catch(NumberFormatException e) {
	            		System.out.println(e);
	            		System.out.println("You entered an invalid number. You will be directed to the beginning.");
	            		case4();
	            	
	            	}
	            
		System.out.print("Please enter your new email:");
		String newEmail=input4.nextLine();
	
		operations4.updateField(this.id, newPassword, newPhoneNumber, newEmail);
		System.out.println("\nThe fields have been updated successfully.");
		
		returnUpdateMenu();
		
		
	}
	
	

	public void returnUpdateMenu() {
		
		String enteredOperation="";
		Scanner input7= new Scanner(System.in);
		
 		boolean isValid=true;
 		do {
 			
 			if(isValid==true) {
 				System.out.print("\nIf you want to return to the previous menu, type (Y):");
 	
 			}else {
 				System.out.print("Please enter valid letter:");
 			}
 			
 			enteredOperation= input7.nextLine();
 	
 			
 			if(enteredOperation.equals("Y")) {
 				updateOwnProfile();
 				isValid=true;
 				
 			}
 			else {
 				isValid=false;
 			}
 		

 		}while(!isValid);
		
		
	}
	
	

	public void returnPreviousMenu() {
		
		String enteredOperation="";
		Scanner input7= new Scanner(System.in);
		
 		boolean isValid=true;
 		do {
 			
 			if(isValid==true) {
 				System.out.print("\nIf you want to return to the previous menu, type (Y):");
 	
 			}else {
 				System.out.print("Please enter valid letter:");
 			}
 			
 			enteredOperation= input7.nextLine();
 	
 			
 			if(enteredOperation.equals("Y")) {
 				displayMenu();
 				isValid=true;
 				
 			}
 			else {
 				isValid=false;
 			}
 		

 		}while(!isValid);
		
		
	}
	
	
	
	
	






		
		
		
		
		
		
		
		
		
	
	
	
		
	}
	
	
	
	


