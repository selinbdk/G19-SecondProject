import java.util.Scanner;

public class RegularEmployee extends Employee {
	
	RegularEmployee(int id,String username,String name, String surname, String role){
		super(id,username,name,surname,role);
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
		

		returnPreviousMenu();
		
		
		
	}
	
	
	//harf ve negatif sayı girilmesi kontrol edildi
	
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
		
		returnPreviousMenu();
		
		
		
	}
	

	
	public void case3() {
		MenuOperations operations3 = new MenuOperations();
		Scanner input3= new Scanner(System.in);
		
		System.out.print("Please enter your new email:");
		String updatedEmail=input3.nextLine();
		operations3.updateField(this.id, "email", updatedEmail);
		System.out.println("\nThe field has been updated successfully.");
		
		returnPreviousMenu();
		
		
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
		
		returnPreviousMenu();
		

		
		
	}


	
	
	public void returnPreviousMenu() {
		
		String enteredOperation="";
		Scanner input6= new Scanner(System.in);
		
 		boolean isValid=true;
 		do {
 			
 			if(isValid==true) {
 				System.out.print("\nIf you want to return to the previous menu, type (Y):");
 	
 			}else {
 				System.out.print("Please enter valid letter:");
 			}
 			
 			enteredOperation= input6.nextLine();
 	
 			
 			if(enteredOperation.equals("Y")) {
 				updateOwnProfile();
 				isValid=true;
 				
 			}
 			else {
 				isValid=false;
 			}
 		

 		}while(!isValid);
		
		
	}
	
	
	
	
	void displayOwnProfile() {
	
		MenuOperations operations = new MenuOperations();
		operations.displayProfileInfo(this.id);
		
		 String restartOperation="";
	 		boolean isValidAnswer=true;
	 		Scanner input5= new Scanner(System.in);
	 		do {
	 			
	 			if(isValidAnswer==true) {
	 				System.out.print("\nIf you want to return to the previous menu, type (Y):");
	 	
	 			}else {
	 				System.out.print("Please enter valid letter:");
	 			}
	 			
	 			restartOperation= input5.nextLine();
	 	
	 			
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
		
		MenuOperations operations = new MenuOperations();
		operations.displayNonProfileInfo(this.id);
		
		 String restartOperation="";
	 		boolean isValidAnswer=true;
	 		Scanner input6= new Scanner(System.in);
	 		do {
	 			
	 			if(isValidAnswer==true) {
	 				System.out.print("\nIf you want to return to the previous menu, type (Y):");
	 	
	 			}else {
	 				System.out.print("Please enter valid letter:");
	 			}
	 			
	 			restartOperation= input6.nextLine();
	 	
	 			
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
