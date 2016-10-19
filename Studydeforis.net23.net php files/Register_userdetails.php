<?php
$my_DB="a8196617_studyde";
$mysql_user="a8196617_studyde";
$mysql_pass="qwerty123";
$myserver="mysql4.000webhost.com";
$conn= mysqli_connect($myserver,$mysql_user,$mysql_pass,$my_DB);

$collegename=$_POST["College_name"];
$collegecourse=$_POST["College_course"];
$workexp=$_POST["Work_exp"];
$dreamcollege=$_POST["Dreamcollege_name"];
$dreamcourse=$_POST["Dream_course"];
$user=$_POST["User_name"];

$sql_query="INSERT INTO Userdetails(Username,Undergrad_College_name ,Undergrad_College_course,Work_exp,Dream_college,Dream_course) VALUES ('$user','$collegename','$collegecourse','$workexp','$dreamcollege','$dreamcourse');";
$res=mysqli_query($conn,$sql_query);
if($res)
{
echo "Done";
}
else{
echo "error";
}



?>