import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

class ListAllBooks {
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
	        Statement stmt1 = conn.createStatement();

		String booksTitle = "SELECT title,publisher_name,book_isbn FROM books b,publishers p where b.book_isbn = '"+args[0].trim()+"' AND p.pub_id = b.pub_id ";
		
		ResultSet rsBooksTitle = stmt1.executeQuery(booksTitle );
		
		while (rsBooksTitle.next()){

			System.out.println("Title: <input class='form-control' type='text' name='booksTitle' id = 'booksTitle' value='"+rsBooksTitle.getString("title")+"' readonly>");
			System.out.println("ISBN : <input class='form-control' type='text' name='booksIsbn' id = 'booksIsbn' value='"+rsBooksTitle.getString("book_isbn")+"' readonly>");
			System.out.println("Publisher : <input class='form-control' type='text' name='publisher' id = 'publisher' value='"+rsBooksTitle.getString("publisher_name")+"' readonly>");

		}

		Statement stmt2 = conn.createStatement();

		String booksAuthor = "SELECT a.author_name,a.author_id from books b, TABLE(b.author_id) aa, authors a where b.book_isbn = '"+args[0].trim()+"' AND aa.author_id = a.author_id";
		
		ResultSet rsBooksAuthor = stmt2.executeQuery(booksAuthor);

		System.out.println("<label> Authors : </label>");
		System.out.println("<select multiple class = 'form-control' name = 'author' id = 'author' readonly>");
		while (rsBooksAuthor.next()){
			System.out.println("<option value = '"+rsBooksAuthor.getInt("author_id")+"' >" + rsBooksAuthor.getString("author_name")+"</option>");
		}
		System.out.println("</select>");

		Statement stmt3 = conn.createStatement();

		String booksGenre = "SELECT gg.genre_name, gg.genre_id,book_isbn from books b, TABLE(b.genre_id) g, genre gg where b.book_isbn = '"+args[0].trim()+"' AND g.genre_id = gg.genre_id ";

		ResultSet rsBooksGenre = stmt3.executeQuery(booksGenre);
		
		System.out.println("<form action='http://undcemcs02.und.edu/~fraol.ahmed/cgi-bin/513/1/saveGenre.cgi' method='get'>");
		System.out.println("<label> Genre (Specialities) : </label>");
		System.out.println("<select multiple class = 'form-control' name = 'genre' id = 'genre'>");
		String isbn = "";
		while (rsBooksGenre.next()){
			System.out.println("<option value = '"+rsBooksGenre.getInt("genre_id")+"' >" + rsBooksGenre.getString("genre_name")+"</option>");
			isbn = rsBooksGenre.getString("book_isbn");
		}
		System.out.println("</select>");
		System.out.println("ISBN : <input class='form-control' type='text' name='booksIsbn' id = 'booksIsbn' value='"+isbn+"' readonly>");

		Statement stmt4 = conn.createStatement();

		String listGenres = "SELECT * FROM genre"; 

		ResultSet rslistGenres = stmt4.executeQuery(listGenres);

		System.out.println("<label> Add Genre (Specialities) : </label>");
		System.out.println("<select multiple class = 'form-control' name = 'newGenre' id = 'newGenre'>");
		while (rslistGenres.next()){
			System.out.println("<option value = '"+rslistGenres.getInt("genre_id")+"' >" + rslistGenres.getString("genre_name")+"</option>");
		}
		//System.out.println("<a href='#add' onClick= 'demoAdd(event); return false;'>Add</a>");
		System.out.println("</select>");
		System.out.println("<button type='submit' class='btn btn-primary btn-round'>Save</button>");
		System.out.println("</form>");



		rsBooksTitle.close();
		rsBooksAuthor.close();
		rsBooksGenre.close();
	
		stmt1.close();
		stmt2.close();
		stmt3.close();
		stmt4.close();
		

	   } catch (SQLException ex) {
	   	System.out.println(ex);
	   }
	   conn.close();

	
	}

	
}
