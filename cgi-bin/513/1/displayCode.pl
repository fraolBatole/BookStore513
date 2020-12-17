#!/usr/bin/perl
use CGI; 
$query     = new CGI;

$act = $query->param('act');

print( "Content-type: text/plain\n\n" );

    if ( $act == 1 ) {
      system( "cat ViewBooks.cgi;echo '\n\n\n\n\n';cat ViewBooks.pl;echo '\n\n\n\n\n';cat ViewBooks.java" );
    }   
    elsif ( $act == 2 ) {
      system( "cat RegisterBooks.cgi;echo '\n\n\n\n\n';cat RegisterBooks.pl;echo '\n\n\n\n\n';cat RegisterBooks.java" );
    }
    elsif ( $act == 3 ) {
      system( "cat RegisterAuthor.cgi;echo '\n\n\n\n\n';cat RegisterAuthor.pl;echo '\n\n\n\n\n';cat RegisterAuthor.java" );
    }
    elsif ( $act == 4 ) {
      system( "cat RegisterGenre.cgi;echo '\n\n\n\n\n';cat RegisterGenre.pl;echo '\n\n\n\n\n';cat RegisterGenre.java" );
    }
    elsif ( $act == 5 ) {
      system( "cat RegisterPublisher.cgi;echo '\n\n\n\n\n';cat RegisterPublisher.pl;echo '\n\n\n\n\n';cat RegisterPublisher.java" );
    }
    else {
      print( "\n\n\n     No such interface: $interface" );
    }