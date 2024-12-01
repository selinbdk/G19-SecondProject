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
	public Employee checkRole(String username,String password) {
		
		
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
	        	
	        	
	        	Employee employee = null;
	        	
	        	if(role.equalsIgnoreCase("manager")) {
	    			
	        		employee = new Manager(id,name, surname,role);
	        	
	        	
	        	}
	        	else {
	        		employee = new RegularEmployee(id,name, surname,role);
	        		
	        	}
	    		
	        	
	        	return employee;
	        	
	        	
	        	 
	         }
	         
			}catch(SQLException sqlException)
			{
				sqlException.printStackTrace();
			
			
			}
		
		return null;
		
	
		
	}
	
	
	

	
	
	

}
