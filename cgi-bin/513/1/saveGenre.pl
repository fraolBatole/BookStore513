#!/usr/bin/perl
use CGI; 


$query   = new CGI;
$isbn = $query -> param('booksIsbn');

print ("Content-type: text/html\n\n");

print <<ENDOFTAG;
 <h1>  
ENDOFTAG
        
    $cmd = "/usr/bin/java -Djava.security.egd=file:/dev/./urandom saveGenre '$isbn' ";
    
	my @rmGenre = $query -> param('genre');
	foreach my $genre (@rmGenre) {    $cmd .= "'" . $genre .  "a' "; }

	my @genres = $query -> param('newGenre');
	foreach my $newGenre (@genres) {    $cmd .= "'" . $newGenre . "g' "; }

	print($cmd);
#	system($cmd);

#my $url="http://undcemcs02.und.edu/~fraol.ahmed/cgi-bin/513/1/ViewBooks.cgi";
#my $t=1; # time until redirect activates
#print "<META HTTP-EQUIV=refresh CONTENT=\"$t;URL=$url\">\n";

print <<ENDOFTAG;
</h1>  
ENDOFTAG
