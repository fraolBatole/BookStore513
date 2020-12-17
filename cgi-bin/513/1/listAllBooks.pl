#!/usr/bin/perl
use CGI;

$query = new CGI;

$isbn = $query -> param('isbn');

print ("Content-type: text/html\n\n");

$cmd = "/usr/bin/java -Djava.security.egd=file:/dev/./urandom ListAllBooks '$isbn'";
system($cmd);
