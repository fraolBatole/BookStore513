#!/usr/bin/perl
use CGI;

$query = new CGI;

$authorName = $query -> param('authorName');

print ("Content-type: text/html\n\n");

print <<ENDOFTAG;
 <h1>  
ENDOFTAG
        $cmd = "/usr/bin/java -Djava.security.egd=file:/dev/./urandom RegisterAuthor '$authorName'";
	system($cmd);
	print("Successfully Saved!!!");

my $url = "http://undcemcs02.und.edu/~fraol.ahmed/513/1/registerAuthor.html";
my $t = 2;
print "<META HTTP-EQUIV=refresh CONTENT=\"$t;URL=$url\">\n";

print <<ENDOFTAG;
</h1>  
ENDOFTAG
