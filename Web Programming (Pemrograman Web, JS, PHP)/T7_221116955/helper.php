<?php

    session_start();

    $host = 'localhost';
    $user='root';
    $password = '';
    $database='t7_6955';
    $port = '3306';
    $conn = new mysqli($host, $user, $password, $database);
    if($conn->connect_errno){
        die("gagal connect :".$conn->connect_error);
        echo "<script>alert('Connect Gagal')</script>";
    }

?>