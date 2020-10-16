<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body>
<div class="container">
<div class="row justify-content-center">
<div class="col-md-12">
<div class="card">
<header class="card-header">
	<h4 class="card-title mt-2">Web Indexing, searching and Ranking</h4>
</header>
<article class="card-body">
<form>
	<div class="form-row">
        <div class="form-group col-md-6">
            <button type="submit" formaction="2.php" class="btn btn-info btn-block"> Index Webpage  </button>
        </div> <!-- form-group// -->      
        <div class="form-group col-md-6">
            <button type="submit" formaction="3.php" class="btn btn-info btn-block"> Search Webpage  </button>
        </div> <!-- form-group// -->     
	</div> <!-- form-row end.// -->

</form>
</article> <!-- card-body end .// -->
<form method="POST" action="reset.php">
<div class="border-top card-body text-center">
    
        <div class="form-group">
            <input class="form-control" type="password" name="password" value="password" placeholder="Password">
        </div> <!-- form-group end.// -->  
    <div class="form-row">
        <div class="form-group col-md-4">
            <button type="submit" class="btn btn-info btn-block" > Reset </button>
        </div> 
        <div class="form-group col-md-4">
            <button type="submit" formaction = "help.php" class="btn btn-info btn-block"> Help  </button>
        </div> 
        <div class="form-group col-md-4">
            <button type="submit" formaction = "check.php" class="btn btn-info btn-block"> Display Source  </button>
        </div> 
    </div>
</div>
</form>
</div> <!-- card.// -->
</div> <!-- col.//-->
</div> <!-- row.//-->
</div> 
<!--container end.//-->
</body>
</html>
