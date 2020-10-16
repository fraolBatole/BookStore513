#!/usr/bin/perl
use CGI; 


$query   = new CGI;

$title = $query -> param ('title');
$isbn = $query -> param ('isbn');
$publisher = $query -> param ('publisher');
$author = $query -> param ('author');
$genre = $query -> param ('genre');

print ("Content-type: text/html\n\n");

print <<ENDOFTAG;
 <h1>  
ENDOFTAG
        
    $cmd = "/usr/bin/java -Djava.security.egd=file:/dev/./urandom RegisterBooks '$title' '$isbn' '$publisher' '$author' '$genre'";
    system($cmd);

    print("Successfully saved!!!");


my $url="http://undcemcs02.und.edu/~fraol.ahmed/513/1/registerBook.html";
my $t=2; # time until redirect activates
print "<META HTTP-EQUIV=refresh CONTENT=\"$t;URL=$url\">\n";

print <<ENDOFTAG;
</h1>  
ENDOFTAG
