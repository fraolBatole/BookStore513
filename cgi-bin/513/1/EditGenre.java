import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

class EditGenre {
	public static void main (String [] args) throws SQLException {
	   String user = "#";
           String password = "#";
	   String database = "#";
	

	   OracleDataSource ods = new OracleDataSource ();
		ods.setURL ("jdbc:oracle:thin:@" + database);
		ods.setUser (user);
		ods.setPassword (password);
	   Connection conn = ods.getConnection();

	   try{
	    // PreparedStatement pstmt = conn.prepareStatement("UPDATE genre SET genre_name = ? where genre_id = ?");
	     	
	      //  String genreId = args[0].trim();
		//String genreName = args[1].trim();
		
		//System.out.println(genreId);
		//System.out.println(genreName);

		//pstmt.setString(1, genreName);
		//pstmt.setString(2, genreId );
	
	       	//pstmt.execute();
		
		//pstmt.close();


	 	Statement stmt1 = conn.createStatement();
		ResultSet rsGenre = stmt1.executeQuery("SELECT genre_name from genre a where a.genre_id = '"+args[0].trim()+"' ");
		
		System.out.println("ID: <input class='form-control' type='text' name='genreID' value='"+args[0].trim()+"' id = 'genreID' readonly>");

		while (rsGenre.next()){

			System.out.println("Genre Name: <input class='form-control' type='text' name='authorName' id = 'authorName' value='"+rsGenre.getString("genre_name")+"' readonly>");
		}

		Statement stmt2 = conn.createStatement();
		ResultSet rsTitle = stmt1.executeQuery("SELECT DISTINCT title from books b, table(b.genre_id) d where d.genre_id = '"+args[0].trim()+"' ");
		String genresBook = "Genre (Speciality's) Books :";
		while (rsTitle.next()){

			genresBook += "<input class='form-control' type='text' name='genreTitle' id = 'genreTitle' value='"+rsTitle.getString("title")+"' readonly>";
		}
		System.out.println(genresBook);

		Statement stmt3 = conn.createStatement();
		ResultSet rsAuthor = stmt3.executeQuery("SELECT DISTINCT gg.author_name from books b, table(b.genre_id) d,table(b.author_id) g, authors gg where d.genre_id = '"+args[0].trim()+"' AND gg.author_id = g.author_id");
		String authorsGenre = "Genre (Specialitys') author :";
		while (rsAuthor.next()){

			authorsGenre += "<input class='form-control' type='text' name='authorGenre' id = 'authorGenre' value='"+rsAuthor.getString("author_name")+"' readonly>";
		}
		System.out.println(authorsGenre);


		rsGenre.close();
		rsTitle.close();
		rsAuthor.close();

		stmt1.close();
		stmt2.close();
		stmt3.close();

		
	   } catch (SQLException ex) {
	   	System.out.println(ex);
	   }
	   conn.close();

	
	}
}
