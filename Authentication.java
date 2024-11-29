import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Authentication extends Database {
	
	
	public boolean checkValidLogin(String username, String password) {
		
		try {                                       
	         Connection connection = DriverManager.getConnection(DATABASE_URL, ROOT, ROOT_PASSWORD);                     
	         Statement statement = connection.createStatement();       
	         ResultSet resultSet = statement.executeQuery(SELECT_QUERY);
		
	         while(resultSet.next()) {
	        	 
	        	 if(username.equals(resultSet.getString("employee_username")) && password.equals(resultSet.getString("employee_password"))) {
	        		 
	        		 return true;
	        	 }
	        	 
	        	 
	         }
	         
			}catch(SQLException sqlException)
			{
				sqlException.printStackTrace();
				return false;
			
			}
		
			return false;
		
	
		
	}
	
	
	
	//SELECT_QUERY içerisinde variable kullanılacağı için prepared statement kullanıldı.
	public Manager checkRole(String username,String password) {
		
		
		try {           
			 String queryForRole="SELECT employee_id, employee_name, employee_surname, employee_role FROM employees WHERE employee_username =? AND employee_password =?";
	         Connection connection = DriverManager.getConnection(DATABASE_URL, ROOT, ROOT_PASSWORD);                     
	         PreparedStatement statement =connection.prepareStatement(queryForRole);
	         statement.setString(1,username);
	         statement.setString(2,password);
	         ResultSet resultSet = statement.executeQuery();
		
	         while(resultSet.next()) {
	        	
	        	int id=resultSet.getInt("employee_id"); 
	        	String name= resultSet.getString("employee_name");
	        	String surname= resultSet.getString("employee_surname");
	        	String role= resultSet.getString("employee_role");
	        	
	        	
	        	Manager manager = new Manager(id,name, surname,role);
	        	
	        	return manager;		
	    
	        		
	        	 
	         }
	         
			}catch(SQLException sqlException)
			{
				sqlException.printStackTrace();
			
			
			}
		
		return null;
		
	
		
	}
	
	
	
	public RegularEmployee checkRoleForRegular(String username,String password) {
		
	
		try {           
			 String queryForRole="SELECT employee_id, employee_name, employee_surname, employee_role FROM employees WHERE employee_username =? AND employee_password =?";
	         Connection connection = DriverManager.getConnection(DATABASE_URL, ROOT, ROOT_PASSWORD);                     
	         PreparedStatement statement =connection.prepareStatement(queryForRole);
	         statement.setString(1,username);
	         statement.setString(2,password);
	         ResultSet resultSet = statement.executeQuery();
		
	         while(resultSet.next()) {
	        	
	        	int id=resultSet.getInt("employee_id"); 
	        	String name= resultSet.getString("employee_name");
	        	String surname= resultSet.getString("employee_surname");
	        	String role= resultSet.getString("employee_role");
	        	
	        	RegularEmployee employee = new RegularEmployee(id,name, surname,role);
	        	
	        	return employee;		
	        	 
	        		
	        	 
	         }
	         
			}catch(SQLException sqlException)
			{
				sqlException.printStackTrace();
			
			
			}
		
		return null;
		

	}
	
	public void displayProfileInfo(int employeeId) {
		
		try {           
			 String queryForRole="SELECT employee_password, phone_no, email FROM employees WHERE employee_id =?";
	         Connection connection = DriverManager.getConnection(DATABASE_URL, ROOT, ROOT_PASSWORD);                     
	         PreparedStatement statement =connection.prepareStatement(queryForRole);
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
			 String queryForRole="SELECT employee_username,employee_role,employee_name,employee_surname,dateofbirth,dateofstart FROM employees WHERE employee_id =?";
	         Connection connection = DriverManager.getConnection(DATABASE_URL, ROOT, ROOT_PASSWORD);                     
	         PreparedStatement statement =connection.prepareStatement(queryForRole);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
