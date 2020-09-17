#!/usr/bin/perl
use CGI; 
$query   = new CGI;


print ("Content-type: text/html\n\n");

print <<ENDOFTAG;

   
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="./assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="./assets/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
   Book Store | Home
  </title>
 

  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
 

  <!-- Datatable files -->
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
  <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
  <!--     Fonts and icons     -->
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
  <!-- CSS Files -->
  <link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <!-- <link rel="stylesheet" type="text/css" href="./assets/css/datatable.css"> -->
  <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">

  <!--  <link href="../../../513/1/assets/css/bootstrap.min.css" rel="stylesheet" /> -->
  <link href="../../../513/1/assets/css/paper-dashboard.css?v=2.0.1" rel="stylesheet" />
 
</head>

<body class="">
  <div class="wrapper ">
    <div class="sidebar" data-color="white" data-active-color="danger">
      <div class="logo">
        <a href="https://www.creative-tim.com" class="simple-text logo-mini">
          <!-- <div class="logo-image-small">
            <img src="./assets/img/logo-small.png">
          </div> -->
          <!-- <p>CT</p> -->
        </a>
        <a href="https://www.creative-tim.com" class="simple-text logo-normal">
          513 Book Store
          <!-- <div class="logo-image-big">
            <img src="../assets/img/logo-big.png">
          </div> -->
        </a>
      </div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          <li class="active ">
            <a href="#">
              <i class="fa fa-list"></i>
              <p>List Books</p>
            </a>
          </li>
          <li>
            <a href="javascript:;">
              <i class="fa fa-book"></i>
              <p>Register a Book</p>
            </a>
          </li>
          <li>
            <a href="javascript:;">
              <i class="fa fa-users"></i>
              <p>Register Author</p>
            </a>
          </li>
          <li>
            <a href="javascript:;">
              <i class="fa fa-list-alt"></i>
              <p>Register a Genre</p>
            </a>
          </li>
        </ul>
      </div>
    </div>
    <div class="main-panel" style="height: 100vh;">
      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-absolute fixed-top navbar-transparent">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <div class="navbar-toggle">
              <button type="button" class="navbar-toggler">
                <span class="navbar-toggler-bar bar1"></span>
                <span class="navbar-toggler-bar bar2"></span>
                <span class="navbar-toggler-bar bar3"></span>
              </button>
            </div>
            <a class="navbar-brand" href="javascript:;">List of Books</a>
          </div>
          <div class="collapse navbar-collapse justify-content-end" id="navigation">
            <ul class="navbar-nav">
              <li class="nav-item btn-rotate dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="fa fa-user-circle-o"></i>
                 
                </a>
                <div class="dropdown-menu dropdown-menu-left" aria-labelledby="navbarDropdownMenuLink">
                  <a class="dropdown-item" href="#">Account Detail</a>
                  <a class="dropdown-item" href="#">Log out</a>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <!-- End Navbar -->
      <div class="content">
        <div class="row">
          <div class="col-md-12">
            <table id="datatable" class="table table-striped table-bordered" cellspacing="0" width="100%">
              <thead>
              <tr>
                <th>ID</th>
                <th>Title</th>
                <th>ISBN</th>
                <th>Author</th>
                <th>Publisher</th>
                <th>Genre</th>
                  <th>Edit</th>
                    <th>Delete</th>
              </tr>
            </thead>
  
            <tfoot>
              <tr>
                <th>Id </th>
                <th>Title</th>
                <th>ISBN</th>
                <th>Author</th>
                <th>Publisher</th>
                <th>Genre</th>
                   <th>Edit</th>
                   <th>Delete</th>
              </tr>
            </tfoot>
            <tbody>
             
ENDOFTAG
    $cmd = "/usr/bin/java -Djava.security.egd=file:/dev/./urandom ViewBooks";

    system($cmd);
print <<ENDOFTAG;
               
            </tbody>
          </table>
          </div>
        </div>
      </div>
      <div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
        <div class="modal-dialog">
      <div class="modal-content">
            <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
          <h4 class="modal-title custom_align" id="Heading">Edit Your Detail</h4>
        </div>
            <div class="modal-body">
            <div class="form-group">
          <input class="form-control " type="text" placeholder="Tiger Nixon">
          </div>
          <div class="form-group">
          
          <input class="form-control " type="text" placeholder="System Architect">
          </div>
          <div class="form-group">
          
          
        <input class="form-control " type="text" placeholder="Edinburgh">
          
          </div>
        </div>
            <div class="modal-footer ">
          <button type="button" class="btn btn-warning btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Update</button>
        </div>
          </div>
      <!-- /.modal-content --> 
    </div>
        <!-- /.modal-dialog --> 
      </div>
      <footer class="footer" style="position: absolute; bottom: 0; width: -webkit-fill-available;">
        <div class="container-fluid">
          <div class="row">
            <nav class="footer-nav">
              <ul>
                <!-- <li><a href="https://www.creative-tim.com" target="_blank">Creative Tim</a></li> -->
              </ul>
            </nav>
            <div class="credits ml-auto">
              <span class="copyright">
                © 2020, made with <i class="fa fa-heart heart"></i> by Fraol
              </span>
            </div>
          </div>
        </div>
      </footer>
    </div>
  </div>
  <!--   Core JS Files   -->
  <script src="../../../513/1/assets/js/core/jquery.min.js"></script>
  <script src="../../../513/1/assets/js/core/bootstrap.min.js"></script>
  <script language="JavaScript" src="../../../513/1/assets/js/datatable.js"></script>
  <script language="JavaScript" src="https://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>
  <script language="JavaScript" src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js" type="text/javascript"></script>
  <script language="JavaScript" src="https://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js" type="text/javascript"></script>

</body>

</html>

ENDOFTAG
