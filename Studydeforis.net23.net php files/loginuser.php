<?php
require "connection.php";

$user=$_POST["username"];
$pass=$_POST["password"];

$sql_query="SELECT * FROM users WHERE Username like '$user' AND Password like '$pass';";
$result=mysqli_query($conn,$sql_query);

if(mysqli_num_rows($result)>0)
{
$row=mysqli_fetch_assoc($result);
$name=$row["Name"];
echo "login success";
}
else
{
echo "login failed";
}

?>