<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

</head>
<div class="row justify-content-center">
<div class="col-md-12">
<div class="card">
<header class="card-header">
	<h4 class="card-title mt-2">Indexing</h4>
    <a  href="index.php" class="btn btn-secondary btn-block" > Home </a>
</header>
</div>
</div>
</div>
<?php
    $keywords = $_POST['keywords'];
    $seedUrls = $_POST['URL'];

    $filess = file_get_contents($seedUrls);
    $formatted = htmlspecialchars($filess);

    if (strpos($formatted, $keywords) !== false){
        indexPages($seedUrls,$keywords);
    }

    function indexPages($seedUrls, $keywords){

        global $conn;
        $desc = " ";

        $doc = new DOMDocument();
        // echo "insde" . $seedUrls;
        $doc->loadHTML(file_get_contents($seedUrls));

        $title = $doc->getElementsByTagName("title");

        $pageTitle = $title->item(0)->nodeValue;
        // echo "TITLE : " . $pageTitle;
        $metaTag = $doc->getElementsByTagName("meta");

        for ($i = 0; $i < $metaTag->length; $i++) {
            $meta = $metaTag->item($i);
            if (strtolower($meta->getAttribute("name")) == "description")
                $desc = $meta->getAttribute("content");
                // echo "DESCRIPTION" . $desc;
        }
        
            startDB();
            //Saving the KEYWORD for the webpage
            if($keywords != null){
                $check_keyword_sql = "SELECT * FROM keyword where keyword = '$keywords'";
                if($result = mysqli_query($conn, $check_keyword_sql)){
                    if(mysqli_num_rows($result) == 0){
                        $keyword_sql = "INSERT INTO keyword(keyword) VALUES ('$keywords')";
                        checkDB($keyword_sql);
                    }else{
                    }
                }
            }
           
            //Saving the DISCRIPTION for the WEB PAGE
            if($desc != null){
                $check_desc_sql = "SELECT * FROM descriptions where descriptions = '$desc'";
                if($result = mysqli_query($conn, $check_desc_sql)){
                    if(mysqli_num_rows($result) == 0){
                        $desc_sql = "INSERT INTO descriptions(descriptions) VALUES ('$desc')";
                        checkDB($desc_sql);
                    }else{
                    }
                }
            }
            //Saving the TITLE FOR the WEB PAGE
            if($pageTitle != null){

                $check_title_sql = "SELECT * FROM title where title = '$pageTitle'";
                if($result = mysqli_query($conn, $check_title_sql)){
                    if(mysqli_num_rows($result) == 0){
                        $title_sql = "INSERT INTO title(title) VALUES ('$pageTitle')";    
                        checkDB($title_sql);
                    }else{
                    }
                }
            }
            // //saving the URL for the web page
            if($seedUrls != null){

                $check_url_sql = "SELECT * FROM urls where urls = '$seedUrls'";
                if($result = mysqli_query($conn,$check_url_sql)){
                    if(mysqli_num_rows($result) == 0){
                        $url_sql = "
                        INSERT INTO urls (urls,keyword_id,desc_id,title_id) VALUES ('$seedUrls',
                        (SELECT keyword_id FROM keyword WHERE keyword ='$keywords'),
                        (SELECT desc_id from descriptions WHERE descriptions = '$desc'),
                        (SELECT title_id FROM title WHERE title='$pageTitle'))";
                        checkDB($url_sql);
                        $key_url = "
                        INSERT INTO key_url (url_id, keyword_id) VALUES (
                            (SELECT url_id FROM urls WHERE urls = '$seedUrls'),
                            (SELECT keyword_id FROM keyword WHERE keyword ='$keywords'))";
                        checkDB($key_url);
                    }else{
                    }
                }
            }

    }  

    function startDB(){
        global $conn;

        $servername = "undcsmysql.mysql.database.azure.com";
        $username = "fraol.ahmed@undcsmysql";
        $password = "fahmed4580";
        $dbname = "fraol_ahmed";
        
        $conn = mysqli_connect($servername,$username,$password,$dbname);
        
        if(!$conn){
            die("Connection Failed due to " . mysqli_connect_error());
        }
    }

    function checkDB($sql){
        global $conn;

        if ($conn->query($sql) === TRUE) {
            echo "New record created successfully\n";
        } else {
            echo "Error: " . $sql . "<br>" . $conn->error;
        }
    }
?>

</html>