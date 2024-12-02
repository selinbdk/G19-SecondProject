import java.util.Scanner;

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
				displayAllEmployees();
				break;
			case "3":
				displayEmployeesWithRole();
				break;
			case "4":
				displayEmployeesWithUsername();
				break;
				
			case "5":
				updateEmployeeNonProfile();
				break;
			case "6":
				hireEmployee();
				break;
			case "7":
				fireEmployee();
				break;
			case "8":
				algorithms();
				break;
			case "9":
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

	@Override
	public void hireEmployee() {
	        Scanner input = new Scanner(System.in);
	        System.out.println("\n**** HIRE EMPLOYEE ****");

	        System.out.print("Enter employee's username: "); //INPUT KONTROLÜ EKLENMELİ
	        String username = input.nextLine();
	
	        System.out.print("Enter employee's role (engineer/technician/intern): "); //INPUT KONTROLÜ EKLENMELİ
	        String role = input.nextLine();
	
	        System.out.print("Enter employee's real name: "); //INPUT KONTROLÜ EKLENMELİ
	        String name = input.nextLine();
	
	        System.out.print("Enter employee's real surname: "); //INPUT KONTROLÜ EKLENMELİ
	        String surname = input.nextLine();
	
	        System.out.print("Enter employee's phone number: ");  //INPUT KONTROLÜ EKLENMELİ
	        String phoneNumber = input.nextLine(); 
	
	        System.out.print("Enter employee's birth date (YYYY-MM-DD): "); //INPUT KONTROLÜ EKLENMELİ
	        String dob = input.nextLine();
	
	        System.out.print("Enter employee's job starting date (YYYY-MM-DD): "); //INPUT KONTROLÜ EKLENMELİ
	        String startDate = input.nextLine();
	
	        System.out.print("Enter employee's email adress: "); //INPUT KONTROLÜ EKLENMELİ
	        String email = input.nextLine();
	
	        String defaultPassword = "newemployee123"; // başta verilen default şifre
	
	        String query = "INSERT INTO employees (employee_username, employee_password, employee_role, employee_name, employee_surname, phone_no, dateofbirth, dateofstart, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	        try (Connection connection = DriverManager.getConnection(Database.DATABASE_URL, Database.ROOT, Database.ROOT_PASSWORD);
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	
	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, defaultPassword);
	            preparedStatement.setString(3, role);
	            preparedStatement.setString(4, name);
	            preparedStatement.setString(5, surname);
	            preparedStatement.setString(6, phoneNumber);
	            preparedStatement.setString(7, dob);
	            preparedStatement.setString(8, startDate);
	            preparedStatement.setString(9, email);
	
	            int rowsInserted = preparedStatement.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("Employee hired."); //Hiring is successful
	            }
	        } catch (SQLException e) {
	            System.out.println("Error hiring employee: " + e.getMessage());
	        }
	    }
	 //****************************************************************** */
    @Override
    	public void fireEmployee() {
	        Scanner input = new Scanner(System.in);
	        System.out.println("\n**** FIRE EMPLOYEE ****");
	
	        System.out.print("Enter the username of the employee to fire: "); //INPUT KONTROLÜ EKLENMELİ
	        String username = input.nextLine();
	
	        if (username.equals(this.username)) {
	            System.out.println("Managers cannot fire themselves!");
	            return;
	        }
	
	        String query = "DELETE FROM employees WHERE employee_username = ?";
	
	        try (Connection connection = DriverManager.getConnection(Database.DATABASE_URL, Database.ROOT, Database.ROOT_PASSWORD);
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	
	            preparedStatement.setString(1, username);
	
	            int rowsDeleted = preparedStatement.executeUpdate();
	            if (rowsDeleted > 0) {
	                System.out.println("Employee fired."); //fired successfully
	            } else {
	                System.out.println("No employee found with this username.");
	            }
	        } catch (SQLException e) {
	            System.out.println("Error firing employee: " + e.getMessage());
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


	public void algorithms() {
		// TODO Auto-generated method stub
		
	}


	public void fireEmployee() {
		// TODO Auto-generated method stub
		
	}


	public void hireEmployee() {
		// TODO Auto-generated method stub
		
	}


	public void updateEmployeeNonProfile() {
		// TODO Auto-generated method stub
		
	}


	public void displayEmployeesWithUsername() {
		// TODO Auto-generated method stub
		
	}


	public void displayEmployeesWithRole() {
		// TODO Auto-generated method stub
		
	}


	public void displayAllEmployees() {
		// TODO Auto-generated method stub
		
	}

		
	
	}
	
	
	
	


