import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

class PopulateSelect {
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
// -----------------------
//This is for publisher 
// -----------------------
            String query = "SELECT * FROM publishers";

        
            //System.out.println("<h3><em>" + query + "</em>");
	    ResultSet rs = stmt.executeQuery( query );

	  	System.out.println("<div class='col-md-4 pr-1'>");
	        System.out.println("<div class='form-group'>");
	        System.out.println("<label for = 'sel1'> Publisher </label>");
		System.out.println("<select multiple class = 'form-control' name = 'publisher' id = 'publisher'>");
            while ( rs.next() ) {
		
	        System.out.println("<option value = '"+rs.getInt("pub_id")+"'>" + rs.getString("publisher_name")+"</option>");
		
	    }
		System.out.println("</select>");
		System.out.println("</div>");
		System.out.println("</div>");
	
// -----------------------
//This is for Author 
// -----------------------
            String queryA = "SELECT * FROM authors";

        
            //System.out.println("<h3><em>" + query + "</em>");
	    ResultSet rsA = stmt.executeQuery( queryA );

	  	System.out.println("<div class='col-md-4 pr-1'>");
	        System.out.println("<div class='form-group'>");
	        System.out.println("<label> Author </label>");
		System.out.println("<select multiple class = 'form-control' name = 'author' id = 'author'>");
            while ( rsA.next() ) {
		
	        System.out.println("<option value = '"+rsA.getInt("author_id")+"' >" + rsA.getString("author_name")+"</option>");
		
	    }
		System.out.println("</select>");
		System.out.println("</div>");
		System.out.println("</div>");
	
// -----------------------
//This is for Author 
// -----------------------
            String queryG = "SELECT * FROM genre";

        
            //System.out.println("<h3><em>" + query + "</em>");
	    ResultSet rsG = stmt.executeQuery( queryG );

	  	System.out.println("<div class='col-md-4 pr-1'>");
	        System.out.println("<div class='form-group'>");
	        System.out.println("<label> Genre </label>");
		System.out.println("<select multiple class = 'form-control' name = 'genre' id = 'genre'>");
            while ( rsG.next() ) {
		
	        System.out.println("<option value = '"+rsG.getInt("genre_id")+"'>" + rsG.getString("genre_name")+"</option>");
		
	    }
		System.out.println("</select>");
		System.out.println("</div>");
		System.out.println("</div>");
	


            rs.close();
	    rsA.close();
	    rsG.close();
            stmt.close();
        } catch (SQLException ex){
            System.out.println(ex);
        }

        conn.close();
    }
}
