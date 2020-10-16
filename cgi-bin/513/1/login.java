import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

class login {
    public static void main(String [] args) throws SQLException{
        String user = "C##fraol.ahmed";
        String password = "fraol7124";
	String database = "65.52.222.73:1521/cdb1";

	// Open an OracleDataSource and get a connection.
	OracleDataSource ods = new OracleDataSource( );
	ods.setURL     ( "jdbc:oracle:thin:@" + database );
	ods.setUser    ( user );
	ods.setPassword( password );
	Connection conn = ods.getConnection( );

        try {

            	Statement stmt = conn.createStatement();
	
	    	String user_name = args[0].trim();
	    	String user_password = args[1].trim();
        
	    	String query = "SELECT * FROM users where user_name = '" + user_name +"' AND user_password = '"+ user_password +"'";
		
 		ResultSet rs = stmt.executeQuery(query);  

    		if (rs.next() ){	
		System.out.println("<META " + "HTTP-EQUIV=refresh "+ "CONTENT=\"1;URL='http://undcemcs02.und.edu/~fraol.ahmed/cgi-bin/513/1/ViewBooks.cgi'\">");
			
		} else {
		System.out.println("<META " + "HTTP-EQUIV=refresh "+ "CONTENT=\"1;URL='http://undcemcs02.und.edu/~fraol.ahmed/513/1/index.html'\">");

		} 

            	//System.out.println("<h3><em>" + query + "</em>\n");
	  
            	rs.close();
            	stmt.close();
        } catch (SQLException ex){
            System.out.println(ex);
        }

        conn.close();
    }
}
