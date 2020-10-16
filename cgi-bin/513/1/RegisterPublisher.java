import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

class RegisterPublisher{
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
	     PreparedStatement pstmt = conn.prepareStatement("INSERT INTO publishers (publisher_name,publisher_city) VALUES (?,?)");
	     	
	        String publisherName = args[0].trim();
		String publisherCity = args[1].trim();
		
		System.out.println(publisherName );
		System.out.println(publisherCity );

		pstmt.setString(1, publisherName );
		pstmt.setString(2, publisherCity );
	
	       	pstmt.execute();
		
		pstmt.close();
		
	   } catch (SQLException ex) {
	   	System.out.println(ex);
	   }
	   conn.close();
	}
}
