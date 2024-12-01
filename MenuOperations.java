import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	
	
	
	
	
	
	
	
	

}
