<?php
require "connection.php";

$sql_query="SELECT * FROM users;";

$response=mysqli_query($conn , $sql_query);

$result=array();

while($rows=mysqli_fetch_array($response))
{
array_push($result,array("name"=>$rows[1] , "email"=>$rows[2] , "username"=>$rows[3] , "password"=>$rows[4]));
}

echo json_encode(array("server_result"=>$result));

mysqli_close($conn);

 
?>