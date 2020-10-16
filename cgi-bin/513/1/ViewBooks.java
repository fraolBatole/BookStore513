import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

class ViewBooks {
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
            String query = "SELECT * FROM books b,publishers p,authors a,genre g where b.pub_id = p.pub_id AND b.author_id = a.author_id AND b.genre_id = g.genre_id";

        
            //System.out.println("<h3><em>" + query + "</em>");
	    ResultSet rs = stmt.executeQuery( query );

	    int id = 1;
            while ( rs.next() ) {
		System.out.println("<tr>");
	        System.out.println("<td>" + id + "</td>");
	        System.out.println("<td>" + rs.getString("title") + "</td>");
		System.out.println("<td>" + rs.getString("book_isbn") + "</td>");
		System.out.println("<td>" + rs.getString("author_name") + "</td>");
		System.out.println("<td>" + rs.getString("publisher_name") + "</td>");
		System.out.println("<td>" + rs.getString("genre_name")+ "</td>");
		System.out.println("<td><p data-placement='top' data-toggle='tooltip' title='Edit'><button class='btn btn-primary btn-xs'" + "data-title='Edit' data-toggle='modal' data-target='#edit' ><span class='glyphicon glyphicon-pencil'> </span></button></p></td>");
		System.out.println("<td><p data-placement='top' data-toggle='tooltip' title='Delete'><button class='btn btn-danger btn-xs' data-title='Delete' data-toggle='modal' data-target='#delete' ><span class='glyphicon glyphicon-trash'></span></button></p></td>");
		System.out.println("</tr>");
		id++;
	    }
            rs.close();
            stmt.close();
        } catch (SQLException ex){
            System.out.println(ex);
        }

        conn.close();
    }
}
