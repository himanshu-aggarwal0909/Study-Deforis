<?php

require "connection.php";

$email = "himanshu.aggarwal0909@gmail.com";
$randomCode = md5(uniqid(rand()));

$sql_query = "INSERT INTO confirmemail values ('$randomCode' , '$email');";

if(mysqli_query($conn , $sql_query))
{
// user email id
$to=$email;

$subject= "Your confirmation link here";

$header = "From:expert@studydeforis.net23.net \r\n";

$message= "Your confirmation link \r\n";
$message .="Click on the link to activate your account \r\n";

//Confirmation link to the confirmation.php
//{host address}/{confirmation processing page}?{random code name}={actual variable}
//$message .="";

$sentmail = mail($to,$subject, $message , $header);
}

else
{
echo " Check your database connection";
}

if($sentmail)
{
echo "Your Confirmation link has been send to your email address";
}
else
{
echo "cannot send Confirmation link to your email address";
}


?>