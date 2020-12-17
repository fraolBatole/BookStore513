#!/usr/bin/perl
use CGI; 


$query   = new CGI;

$title = $query -> param ('title');
$isbn = $query -> param ('isbn');
$publisher = $query -> param ('publisher');
#$author = $query -> param ('author');
#$genre = $query -> param ('genre');

print ("Content-type: text/html\n\n");

print <<ENDOFTAG;
 <h1>  
ENDOFTAG
        
    $cmd = "/usr/bin/java -Djava.security.egd=file:/dev/./urandom RegisterBooks '$title' '$isbn' '$publisher' ";
    
	my @authors = $query -> param('author');
	foreach my $author (@authors) {    $cmd .= "'" . $author .  "a' "; }

	my @genres = $query -> param('genre');
	foreach my $genre (@genres) {    $cmd .= "'" . $genre . "g' "; }

	print($cmd);
	system($cmd);

my $url="http://undcemcs02.und.edu/~fraol.ahmed/cgi-bin/513/1/RegisterBooks.cgi";
my $t=1; # time until redirect activates
print "<META HTTP-EQUIV=refresh CONTENT=\"$t;URL=$url\">\n";

print <<ENDOFTAG;
</h1>  
ENDOFTAG
