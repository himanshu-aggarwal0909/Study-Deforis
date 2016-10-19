<?php
$my_DB="a8196617_studyde";
$mysql_user="a8196617_studyde";
$mysql_pass="qwerty123";
$myserver="mysql4.000webhost.com";
$conn= mysqli_connect($myserver,$mysql_user,$mysql_pass,$my_DB);

$name=$_POST['name'];
$email=$_POST['email'];
$username=$_POST['username'];
$password=$_POST['password'];
$con_password=$_POST['con_password'];

$sql_query="INSERT INTO users(Name,Email,Username,Password,Confirmpassword) VALUES ('$name','$email','$username','$password','$con_password');";
mysqli_query($conn,$sql_query);

?>