import java.sql.*;
import java.io.*;
import java.util.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

class saveGenre{
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

		Statement stmt2 = conn.createStatement();
		Statement stmt3 = conn.createStatement();

	  	String isbn = args[0].trim();

			

		ArrayList<String> listGenre = new ArrayList<String>();
		ArrayList<String> listNewGenre = new ArrayList<String>();

		for (int i = 1; i < args.length; i++){
		    if(args[i].trim().contains("a")){
			listGenre.add(args[i].trim().replace("a",""));
			
			String check = "select count(*) from table (select b.genre_id from books b where b.book_isbn = '"+isbn+"') d";
			ResultSet rs = stmt3.executeQuery(check);
			int count = 0;	
			while (rs.next()){
				count = rs.getInt(1);
			}	
			if (count > 1){
				String deleteGenre = "DELETE TABLE (SELECT b.genre_id from books b WHERE b.book_isbn = '"+isbn+"') d where d.genre_id = '"+args[i].trim().replace("a","")+"'";
				stmt2.executeQuery(deleteGenre );
			}else {
				System.out.println("Can't delete the only Genre!!!");
			}
			//System.out.println(deleteGenre);		
		    }
		    else if(args[i].trim().contains("g")){
			listNewGenre.add( args[i].trim().replace("g",""));
			String addGenre = "INSERT INTO TABLE(SELECT b.genre_id FROM books b where b.book_isbn = '"+isbn+"') d values ("+args[i].trim().replace("g","")+")";
			stmt.executeQuery(addGenre );
			//System.out.println(addGenre);
		    }
		}

		//deleteGenre += listGenre.toString().replace("[","").replace("]","") ;
		//addGenre += listNewGenre.toString().replace("[","").replace("]","");

		//stmt.executeQuery(query);
		System.out.println("Successful!!!");
		stmt.close();
		stmt2.close();
						
	   } catch (SQLException ex) {
	   	System.out.println(ex);
	   }
	   conn.close();
	}
}
