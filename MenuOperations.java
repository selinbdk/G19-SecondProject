import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MenuOperations extends Database {
	

	public void displayProfileInfo(int employeeId) {
		
		try {           
			 String queryForProfile="SELECT employee_password, phone_no, email FROM employees WHERE employee_id =?";
	         Connection connection = DriverManager.getConnection(DATABASE_URL, ROOT, ROOT_PASSWORD);                     
	         PreparedStatement statement =connection.prepareStatement(queryForProfile);
	         statement.setInt(1,employeeId);
	     
	         ResultSet resultSet = statement.executeQuery();
		
	         if(resultSet.next()) {
	        	
	        	String password= resultSet.getString("employee_password");
	        	String phoneNumber= resultSet.getString("phone_no");
	        	String email= resultSet.getString("email");
	        	
	        	System.out.println("\nPROFILE INFORMATION\n");
	 	        System.out.println("Password: " + password);
	 	        System.out.println("Phone number: " + phoneNumber);
	 	        System.out.println("Email: " + email);
	 	        
	         }
	        
	 
	    
			}catch(SQLException sqlException)
			{
				sqlException.printStackTrace();
			
			}
		
		
	}
	
	
	
	public void displayNonProfileInfo(int employeeId) {
		
		
		try {           
			 String queryForNonProfile="SELECT employee_username,employee_role,employee_name,employee_surname,dateofbirth,dateofstart FROM employees WHERE employee_id =?";
	         Connection connection = DriverManager.getConnection(DATABASE_URL, ROOT, ROOT_PASSWORD);                     
	         PreparedStatement statement =connection.prepareStatement(queryForNonProfile);
	         statement.setInt(1,employeeId);
	     
	         ResultSet resultSet = statement.executeQuery();
		
	         if(resultSet.next()) {
	        	String username= resultSet.getString("employee_username");
		        String role= resultSet.getString("employee_role");
		        String name= resultSet.getString("employee_name");
		        String surname= resultSet.getString("employee_surname");
	        	String dateofbirth= resultSet.getString("dateofbirth");
	        	String dateofstart= resultSet.getString("dateofstart");
	        	
	        	
	        	System.out.println("\nNON PROFILE INFORMATION\n");
	 	        System.out.println("Username: " + username);
	 	        System.out.println("Role: " + role);
	 	        System.out.println("Name: " + name);
	 	        System.out.println("Surname: " + surname);
	 	        System.out.println("Date of Birth: " + dateofbirth);
	 	        System.out.println("Date of Start: " + dateofstart);
	 	        
	         }
	        
	 
	    
			}catch(SQLException sqlException)
			{
				sqlException.printStackTrace();
			
			}
		
		
	
			
		}
	
	
	
	
	//Overloading
	
	//Update one field
	public void updateField(int employeeId, String columnName, String updatedVersion) {
		
	
		try {           
			 String queryForUpdate="UPDATE employees SET "+columnName+"=? WHERE employee_id =?";
	         Connection connection = DriverManager.getConnection(DATABASE_URL, ROOT, ROOT_PASSWORD);                     
	         PreparedStatement statement =connection.prepareStatement(queryForUpdate);
	         statement.setString(1,updatedVersion);
	         statement.setInt(2,employeeId);
	         
	         statement.executeUpdate();
	     
	    
			}catch(SQLException sqlException)
			{
				sqlException.printStackTrace();
			
			}
				
		
	}
	
	
	//Update all the fields
	public void updateField(int employeeId, String newPassword,String newPhoneNumber, String newEmail) {
		
		try {           
			 String queryForUpdate="UPDATE employees SET employee_password=?,phone_no=?,email=? WHERE employee_id =?";
	         Connection connection = DriverManager.getConnection(DATABASE_URL, ROOT, ROOT_PASSWORD);                     
	         PreparedStatement statement =connection.prepareStatement(queryForUpdate);
	         statement.setString(1,newPassword);
	         statement.setString(2,newPhoneNumber);
	         statement.setString(3,newEmail);
	         statement.setInt(4,employeeId);
	         
	         statement.executeUpdate();
	        
	        
	        

			}catch(SQLException sqlException)
			{
				sqlException.printStackTrace();
			
			}
			
		
	}
	
	
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

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, ROOT, ROOT_PASSWORD);
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
	
	
	
	public void fireEmployee(String managerUsername) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n**** FIRE EMPLOYEE ****");

        System.out.print("Enter the username of the employee to fire: "); //INPUT KONTROLÜ EKLENMELİ
        String username = input.nextLine();

        if (username.equals(managerUsername)) {
            System.out.println("Managers cannot fire themselves!");
            return;
        }

        String query = "DELETE FROM employees WHERE employee_username = ?";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, ROOT, ROOT_PASSWORD);
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

	
	
	public void displayAllEmployees() {
		

		try {           
			 String queryForDisplayEmployee="SELECT employee_username,employee_role,employee_name,employee_surname,phone_no,dateofbirth,dateofstart,email FROM employees";
	         Connection connection = DriverManager.getConnection(DATABASE_URL, ROOT, ROOT_PASSWORD);                               
	         Statement statement = connection.createStatement();       
	         
	         
	         ResultSet resultSet = statement.executeQuery(queryForDisplayEmployee);
	         ResultSetMetaData metaData = resultSet.getMetaData();
	         int numberOfColumns = metaData.getColumnCount();     
	         
	        	
	        	System.out.println("\nALL EMPLOYEES\n");
	        	 for (int i = 1; i <= numberOfColumns; i++) {
	 	            System.out.printf("%20s\t", metaData.getColumnName(i));
	 	            }
	 	         System.out.println();
	 	         System.out.printf(" ***********************************************************************************************************************************************************************************************************");
	 	         System.out.println();
	 	         
	 	         // display query results
	 	         while (resultSet.next()) {
	 	            for (int i = 1; i <= numberOfColumns; i++) {
	 	               System.out.printf("%20s\t", resultSet.getObject(i));
	 	               }
	 	            System.out.println();
	 	            System.out.printf(" ***********************************************************************************************************************************************************************************************************  ");
	 	            System.out.println();
	 	         
	 	         }
	    
			}catch(SQLException sqlException)
			{
				sqlException.printStackTrace();
			
			}
		
		

	}
	

	public void displayEmployeesWithRole(String displayedRole) {
		

		try {           
			 String queryForDisplayEmployeeWithRole="SELECT employee_username,employee_role,employee_name,employee_surname,phone_no,dateofbirth,dateofstart,email FROM employees WHERE LOWER(employee_role)=LOWER(?)";
	        
	         Connection connection = DriverManager.getConnection(DATABASE_URL, ROOT, ROOT_PASSWORD);                     
	         PreparedStatement statement =connection.prepareStatement(queryForDisplayEmployeeWithRole);
	         statement.setString(1,displayedRole);
	         
	         
	    
	         ResultSet resultSet = statement.executeQuery();
	         ResultSetMetaData metaData = resultSet.getMetaData();
	         int numberOfColumns = metaData.getColumnCount();     
	         
	        	
	        	System.out.println("\nALL EMPLOYEES WITH THE "+displayedRole.toUpperCase()+" ROLE");
	        	 for (int i = 1; i <= numberOfColumns; i++) {
	 	            System.out.printf("%20s\t", metaData.getColumnName(i));
	 	            }
	 	         System.out.println();
	 	         System.out.printf(" ***********************************************************************************************************************************************************************************************************");
	 	         System.out.println();
	 	         
	 	         // display query results
	 	         while (resultSet.next()) {
	 	            for (int i = 1; i <= numberOfColumns; i++) {
	 	               System.out.printf("%20s\t", resultSet.getObject(i));
	 	               }
	 	            System.out.println();
	 	            System.out.printf(" ***********************************************************************************************************************************************************************************************************  ");
	 	            System.out.println();
	 	         
	 	         }
	    
			}catch(SQLException sqlException)
			{
				sqlException.printStackTrace();
			
			}
		
		
		
		
		
	}


	
	
	
	
		// TODO Auto-generated method stub
		public void displayEmployeesWithUsername(String username) {
			try {
				String query = "SELECT employee_username, employee_role, employee_name, employee_surname, dateofbirth, dateofstart, email FROM employees WHERE employee_username = ?";
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/firm_management", "root", "");
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, username);
				ResultSet resultSet = preparedStatement.executeQuery();
				ResultSetMetaData metaData = resultSet.getMetaData();
				int columnCount = metaData.getColumnCount();
		
				System.out.println("\nEMPLOYEE INFORMATION FOR USERNAME: " + username);
				for (int i = 1; i <= columnCount; ++i) {
					System.out.printf("%20s\t", metaData.getColumnName(i));
				}
				System.out.println();
				System.out.printf(" ***********************************************************************************************************************************************************************************************************");
				System.out.println();
		
				if (resultSet.next()) {
					for (int i = 1; i <= columnCount; ++i) {
						System.out.printf("%20s\t", resultSet.getObject(i));
					}
					System.out.println();
				} else {
					System.out.println("\nNo employee found with the username: " + username);
				}
		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	

	
	// TODO Auto-generated method stub
	public void updateSingleField(int employeeId, String fieldName, String newValue) {
    try {
        String query = "UPDATE employees SET " + fieldName + " = ? WHERE employee_id = ?";
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/firm_management", "root", "");
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, newValue);
        preparedStatement.setInt(2, employeeId);

        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Employee field \"" + fieldName + "\" updated successfully.");
        } else {
            System.out.println("No employee found with the given ID: " + employeeId);
        }
    } catch (SQLException e) {
        System.out.println("Error updating field \"" + fieldName + "\": " + e.getMessage());
    }
}

	public void updateMultipleFields(int employeeId, String newName, String newSurname, String newRole, String newPhoneNumber) {
    try {
        String query = "UPDATE employees SET "
                     + "employee_name = IFNULL(?, employee_name), "
                     + "employee_surname = IFNULL(?, employee_surname), "
                     + "employee_role = IFNULL(?, employee_role), "
                     + "phone_no = IFNULL(?, phone_no) "
                     + "WHERE employee_id = ?";
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/firm_management", "root", "");
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        
        preparedStatement.setString(1, newName);
        preparedStatement.setString(2, newSurname);
        preparedStatement.setString(3, newRole);
        preparedStatement.setString(4, newPhoneNumber);
        preparedStatement.setInt(5, employeeId);

        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Employee information updated successfully.");
        } else {
            System.out.println("No employee found with the given ID: " + employeeId);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}



	public void algorithms() {
		// TODO Auto-generated method stub
		
	}
	

	
	
	
	
	

}
