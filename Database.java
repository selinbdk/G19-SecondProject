import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;



public class Database {
    protected final String DATABASE_URL = "jdbc:mysql://localhost:3306/firm_management";  
	protected final String SELECT_QUERY = "SELECT employee_id, employee_username,employee_password,employee_role,employee_name,employee_surname,phone_no,dateofbirth,dateofstart,email FROM employees";
	protected final String ROOT = "root";
	protected final String ROOT_PASSWORD = "";

    
	public void displayTable() {
	      
	      try {                                       
	         Connection connection = DriverManager.getConnection(DATABASE_URL, ROOT, ROOT_PASSWORD);                     
	         Statement statement = connection.createStatement();       
	         ResultSet resultSet = statement.executeQuery(SELECT_QUERY);

	         // get ResultSet's meta data
	         ResultSetMetaData metaData = resultSet.getMetaData();
	         int numberOfColumns = metaData.getColumnCount();     
	         
	         System.out.printf("Employees Table of firm_management Database:%n%n");

	         // display the names of the columns in the ResultSet
	         for (int i = 1; i <= numberOfColumns; i++) {
	            System.out.printf("%20s\t", metaData.getColumnName(i));
	            }
	         System.out.println();
	         System.out.printf("     ******************************************************************************************************************************************************************************************************************************************");
	         System.out.println();
	         
	         // display query results
	         while (resultSet.next()) {
	            for (int i = 1; i <= numberOfColumns; i++) {
	               System.out.printf("%20s\t", resultSet.getObject(i));
	               }
	            System.out.println();
	            System.out.printf("     ******************************************************************************************************************************************************************************************************************************************");
	            System.out.println();
	         
	         }

		connection.close();}
	      catch (SQLException sqlException) {
	         sqlException.printStackTrace();
	         }
	      
	}
	
	
	
	
	
	













    
}
