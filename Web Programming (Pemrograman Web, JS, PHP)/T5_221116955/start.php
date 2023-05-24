<?php
    session_start();

    
/*
    echo "Session = ";
    print_r($_SESSION);
    echo "<br>";
    echo "Cookie = ";
    print_r($_COOKIE);

*/

    function alert($message) {
        echo "<script>alert('$message');</script>";
    }

?>