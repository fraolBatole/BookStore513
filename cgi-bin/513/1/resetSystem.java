import java.sql.*;
import java.io.*;
import java.util.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

class resetSystem{
    public static void main (String [] args) throws SQLException {
	   String user = "C##fraol.ahmed";
           String password = "fraol7124";
	   String database = "65.52.222.73:1521/cdb1";
	

	   OracleDataSource ods = new OracleDataSource ();
		ods.setURL ("jdbc:oracle:thin:@" + database);
		ods.setUser (user);
		ods.setPassword (password);
	   Connection conn = ods.getConnection();

	   try{
		Statement stmt = conn.createStatement();

		String deleteBooks = "DELETE FROM books";
		stmt.executeQuery(deleteBooks );

		String deleteAuthors = "DELETE FROM authors";
		stmt.executeQuery(deleteAuthors );

		String deleteGenre = "DELETE FROM genre";
		stmt.executeQuery(deleteGenre );

		String deletePublisher = "DELETE FROM publishers"; 
		stmt.executeQuery(deletePublisher );

		
		System.out.println("Successful!!!");
		stmt.close();
	
						
	   } catch (SQLException ex) {
	   	System.out.println(ex);
	   }
	   conn.close();
	}
}
