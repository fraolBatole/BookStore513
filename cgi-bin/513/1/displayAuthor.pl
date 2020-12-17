#!/usr/bin/perl
use CGI;

$query = new CGI;

$authorID = $query -> param('id');

print ("Content-type: text/html\n\n");

$cmd = "/usr/bin/java -Djava.security.egd=file:/dev/./urandom displayAuthor '$authorID'";
system($cmd);
