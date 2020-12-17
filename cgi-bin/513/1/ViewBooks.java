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
	    Statement stmt2 = conn.createStatement();
	    Statement stmt3 = conn.createStatement();

            //String query = "SELECT * FROM books b,table(b.author_id) aa, table(b.genre_id) gg,publishers p,authors a,genre g where b.pub_id = p.pub_id AND aa.column_value = a.author_id AND gg.column_value = g.genre_id";

            String query = "SELECT * from books b inner join publishers p on b.pub_id = p.pub_id";
	    //String authorQuery = "SELECT author_name,author_id from TABLE(select b.author_id from books b where b.book_isbn = '') d, authors a where a.author_id = d.author_id";

            //System.out.println("<h3><em>" + query + "</em>");
	    ResultSet rs = stmt.executeQuery( query );
	   
	    int id = 1;
            while ( rs.next() ) {
		System.out.println("<tr>");
	        System.out.println("<td>" + id + "</td>");
	        System.out.println("<td>" + "<a href='#mybooks' onClick= 'demoBooks(event); return false;' data-toggle='modal' id='"+ rs.getString("book_isbn") +"' value='' data-target='#mybooks'>" + rs.getString("title") + "</a>" +"</td>");
		System.out.println("<td>" + "<a href='#'>" + rs.getString("book_isbn") + "</a>" + "</td>");
		System.out.println("<td>" + "<a href='#'>" + rs.getString("publisher_name") + "</a>" + "</td>");
		//String q = "SELECT author_name from TABLE(select b.author_id from books b where b.book_isbn = '"+rs.getString("title")+"') d, authors a where a.author_id = d.author_id";
		ResultSet rsAuthor = stmt2.executeQuery("SELECT author_name,a.author_id from TABLE(select b.author_id from books b where b.book_isbn = '"+rs.getString("book_isbn")+"') d, authors a where a.author_id = d.author_id");
		String authorT = "<td>" ;
		while(rsAuthor.next()){
			authorT +=  "<a href='#myauthor' onClick= 'demoAuthor(event); return false;' data-toggle='modal' id='"+ rsAuthor.getString("author_id") +"' value='' data-target='#myauthor'>" + rsAuthor.getString("author_name") + ", " + "</a>" ;
		}
		authorT += "</td>";
		System.out.println(authorT );
		
		ResultSet rsGenre = stmt3.executeQuery("SELECT genre_name,g.genre_id from TABLE(select b.genre_id from books b where b.book_isbn = '"+rs.getString("book_isbn")+"') d, genre g where g.genre_id = d.genre_id");
		String genreT = "<td>" ;
		while(rsGenre.next()){
			genreT +=  "<a href='#myedit' onClick= 'demoFun(event); return false;' data-toggle='modal' id='"+ rsGenre.getString("genre_id") +"' value='' data-target='#myedit'>" + rsGenre.getString("genre_name") + ", " + "</a>" ;
		}
		genreT += "</td>";
		System.out.println(genreT);

		//System.out.println("<td>" + "<a href='#myedit' onClick= 'demoFun(event); return false;' data-toggle='modal' id='"+rs.getString("g.genre_id")+"' value='' data-target='#myedit'>" + rs.getString("genre_name")+ "</a>" + "</td>");
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
