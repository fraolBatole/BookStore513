import java.sql.*;
import java.io.*;
import java.util.*;
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
		Statement stmt = conn.createStatement();
	        String title = args[0].trim();
		String isbn = args[1].trim();
		int publisher = Integer.parseInt(args[2].trim());
		ArrayList<String> listAuthor = new ArrayList<String>();
		ArrayList<String> listGenre = new ArrayList<String>();

		for (int i = 3; i < args.length; i++){
		    if(args[i].trim().contains("a")){
			listAuthor.add("author_l("+ args[i].trim().replace("a","")+")");
		    }
		    else if(args[i].trim().contains("g")){
			listGenre.add("genre_l(" + args[i].trim().replace("g","") + ")");
		    }
		}
		String query = "INSERT INTO books (title,book_isbn,pub_id,author_id,genre_id) VALUES ('"+title+"','"+ isbn +"', "+ publisher +", ";
		query += "author_n("+ listAuthor.toString().replace("[","").replace("]","") +"),";
		query += "genre_n("+ listGenre.toString().replace("[","").replace("]","") +"))";
		System.out.println(query);

		stmt.executeQuery(query);
		stmt.close();
						
	   } catch (SQLException ex) {
	   	System.out.println(ex);
	   }
	   conn.close();
	}
}
