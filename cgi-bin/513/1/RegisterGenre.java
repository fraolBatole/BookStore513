import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

class RegisterGenre{
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
	     PreparedStatement pstmt = conn.prepareStatement("INSERT INTO genre (genre_name) VALUES (?)");
	     	
	        String genreName = args[0].trim();
		
		System.out.println(genreName );
		pstmt.setString(1, genreName );
	
	       	pstmt.execute();
		
		pstmt.close();
		
	   } catch (SQLException ex) {
	   	System.out.println(ex);
	   }
	   conn.close();
	}
}
