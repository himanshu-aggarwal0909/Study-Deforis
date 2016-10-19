<?php
require "connection.php";

$sql_query="SELECT Name FROM Universities;";

$response=mysqli_query($conn , $sql_query);

$result=array();

while($rows=mysqli_fetch_array($response))
{
array_push($result,$rows[0] );
}

echo json_encode(array("server_result"=>$result));

mysqli_close($conn);

 
?>