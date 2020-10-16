import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

class RegisterBooks{
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
	     PreparedStatement pstmt = conn.prepareStatement("INSERT INTO books (title,book_isbn,pub_id,author_id,genre_id) VALUES (?,?,?,?,?)");
	     	
	        String title = args[0].trim();
		String isbn = args[1].trim();
		int publisher = Integer.parseInt(args[2].trim());
		int author = Integer.parseInt(args[3].trim());
		int genre = Integer.parseInt(args[4].trim());

		//System.out.println(title + isbn + publisher + author + genre);
		pstmt.setString(1, title);
		pstmt.setString(2, isbn);
		pstmt.setInt(3, publisher);
		pstmt.setInt(4, author);
		pstmt.setInt(5, genre);

	       	pstmt.execute();
		
		pstmt.close();
		
	   } catch (SQLException ex) {
	   	System.out.println(ex);
	   }
	   conn.close();
	}
}
