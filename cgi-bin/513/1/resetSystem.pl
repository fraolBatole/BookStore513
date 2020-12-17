#!/usr/bin/perl
use CGI; 


$query   = new CGI;

print ("Content-type: text/html\n\n");

print <<ENDOFTAG;
 <h1>  
ENDOFTAG
        
    $cmd = "/usr/bin/java -Djava.security.egd=file:/dev/./urandom resetSystem";
     system($cmd);

my $url="http://undcemcs02.und.edu/~fraol.ahmed/cgi-bin/513/1/ViewBooks.cgi";
my $t=1; # time until redirect activates
print "<META HTTP-EQUIV=refresh CONTENT=\"$t;URL=$url\">\n";

print <<ENDOFTAG;
</h1>  
ENDOFTAG
