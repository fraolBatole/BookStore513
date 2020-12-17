#!/usr/bin/perl
use CGI;

$query = new CGI;

$genreId = $query -> param('id');

print ("Content-type: text/html\n\n");

$cmd = "/usr/bin/java -Djava.security.egd=file:/dev/./urandom EditGenre '$genreId'";
system($cmd);
