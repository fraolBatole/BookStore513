<?php

   if ( $_POST['password'] == "password" ) {
     header( "Content-type: text/plain" );
     
      echo  ( "\n\n\n============================ Home.php(1.php) ============================= \n\n\n" );

       $file = fopen( "index.php", "r" ) or exit( "Unable to open file!" );
       while ( !feof( $file ) )  echo  fgets( $file );
       fclose( $file );

       echo  ( "\n\n\n============================ IndexPage.php(2.php) ============================= \n\n\n" );

       $file = fopen( "2.php", "r" ) or exit( "Unable to open file!" );
       while ( !feof( $file ) )  echo  fgets( $file );
       fclose( $file );

       echo  ( "\n\n\n============================ Search.php(3.php) ============================= \n\n\n" );

       $file = fopen( "3.php", "r" ) or exit( "Unable to open file!" );
       while ( !feof( $file ) )  echo  fgets( $file );
       fclose( $file );

       echo  ( "\n\n\n============================ Spider.php(crawler.php) ============================= \n\n\n" );
       $file = fopen( "crawler.php", "r" ) or exit( "Unable to open file!" );
       while ( !feof( $file ) )  echo  fgets( $file );
       fclose( $file );

       echo  ( "\n\n\n============================ reset.php ============================= \n\n\n" );

       $file = fopen( "reset.php", "r" ) or exit( "Unable to open file!" );
       while ( !feof( $file ) )  echo  fgets( $file );
       fclose( $file );
    
      echo  ( "\n\n\n============================== Check.php ============================== \n\n\n" );
      $file = fopen( "check.php", "r" ) or exit( "Unable to open file!" );
      while ( !feof( $file ) )  echo  fgets( $file );
      fclose( $file );

      echo  ( "\n\n\n============================== IndexPage.php ============================== \n\n\n" );
      $file = fopen( "indexPage.php", "r" ) or exit( "Unable to open file!" );
      while ( !feof( $file ) )  echo  fgets( $file );
      fclose( $file );
   }
   else {
     header( "Content-type: text/html" );
     echo  "<html><body><h3>Wrong password: <em>";
     echo  $_POST['password'];
     echo  "</em></h3></body></html>";
   }

?>