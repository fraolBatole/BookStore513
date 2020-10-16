#!/usr/bin/perl
use CGI;

$query = new CGI;

$publisherName = $query -> param('publisherName');
$publisherCity = $query -> param('publisherCity');

print ("Content-type: text/html\n\n");

print <<ENDOFTAG;
 <h1>  
ENDOFTAG
        $cmd = "/usr/bin/java -Djava.security.egd=file:/dev/./urandom RegisterPublisher '$publisherName' '$publisherCity' ";
	system($cmd);
	print("Successfully Saved!!!");

my $url = "http://undcemcs02.und.edu/~fraol.ahmed/513/1/registerPublisher.html";
my $t = 2;
print "<META HTTP-EQUIV=refresh CONTENT=\"$t;URL=$url\">\n";

print <<ENDOFTAG;
</h1>  
ENDOFTAG
