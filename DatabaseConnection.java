/**
 * @author Ryan Llewellyn 
 * @version 1.0
 * @since 06/04/2018
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DatabaseConnection {

	public static void main(String[] args) throws Exception {
		// Calling Methods
		getConnection();
		//createTable();
		//post();
		//delete();
		get();
	}

	//Establish a connection to a MySQL database
		public static Connection getConnection() throws Exception {
			try {
				//Login information for MySQL Server
				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/gspdatabase";
				String username = "root";
				String password = "";
				Class.forName(driver);

				//Pass Login values into Database and Connect
				Connection con = DriverManager.getConnection(url,username,password);
				System.out.println("Connected");
				return con;
			} catch(Exception e) {System.out.println(e);}
			return null;
		}

		//connect to the Database and Create a table with fields
			public static void createTable() throws Exception {
				try {
					//Establish Database Connection
					Connection con = getConnection();

					//Create SQL Statement
					PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS exampletablename(id int NOT NULL AUTO_INCREMENT, firstname varchar(255), lastname varchar(255), PRIMARY KEY(id))");

					//Execute Prepared Statement
					create.executeUpdate();
				} catch (Exception e) {System.out.println(e);}
				finally {System.out.println("Function Complete");}
			}

		//Insert Values to Database
			public static void post() throws Exception {
				//assign prepared statement variables
				final String val1 ="John";
				final String val2 = "Johnson";
				final String val3 = "john@email.com";
				final int val4 = 1123456789;
				try {
					//Establish Database Connection
					Connection con = getConnection();

					//Create SQL Statement
					PreparedStatement posted = con.prepareStatement("INSERT INTO customers (fname, sname, email, phone) VALUES ('"+val1+"','"+val2+"','"+val3+"','"+val4+"')");

					//Execute Prepared Statement
					posted.executeUpdate();
				} catch(Exception e) {System.out.println(e);}
				finally {
					System.out.println("Insert Successful");
				}
			}

		//Select Values from Database (get() + print them in terminal)
			public static ArrayList<String> get() throws Exception{
				//assign prepared statement variables
				final String TableSelection ="customers";
				try {
					Connection con = getConnection();
					PreparedStatement selection = con.prepareStatement("SELECT * FROM " +TableSelection);

					ResultSet result = selection.executeQuery();

					ArrayList<String> array = new ArrayList<String>();
					while(result.next()) {
						System.out.print(result.getInt("customerid"));
						System.out.print(" ");
						System.out.print(result.getString("fname"));
						System.out.print(" ");
						System.out.print(result.getString("sname"));
						System.out.print(" ");
						System.out.print(result.getString("email"));
						System.out.print(" ");
						System.out.println(result.getInt("phone"));

						array.add(result.getString("fname"));
						array.add(result.getString("sname"));
						array.add(result.getString("email"));
					}

					System.out.println("All Records have been selected");
					return array;

				} catch (Exception e) {System.out.println(e);}
				return null;

			}
			
		//Delete Values from Database
			public static void delete() throws Exception{
				//assign prepared statement variables
				final String TabName ="customers";
				final String identifier ="customerid";
				final String delRecName = "1";
				try {
					//Establish Database Connection
					Connection con = getConnection();

					//Create SQL Statement (Delete Row from Table)
					PreparedStatement delete = con.prepareStatement("DELETE FROM "+TabName+" WHERE " +identifier+ " = " +delRecName );
					
					//Execute Prepared Statement
					delete.executeUpdate();
				} catch(Exception e) {System.out.println(e);}
				finally {
					System.out.println("Delete Successful");
				}
			}

}

