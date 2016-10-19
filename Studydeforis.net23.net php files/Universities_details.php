<?php
require "connection.php";

$sql_query="SELECT * FROM Universities;";

$response=mysqli_query($conn , $sql_query);

$result=array();

while($rows=mysqli_fetch_array($response))
{
array_push($result,array("Name"=>$rows[0] , "Country"=>$rows[1] , "Type"=>$rows[2] , "Fees"=>$rows[3] ));
}

echo json_encode(array("server_result"=>$result));

mysqli_close($conn);

 
?>