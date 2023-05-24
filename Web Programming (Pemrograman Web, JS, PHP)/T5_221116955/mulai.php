<?php

    $budi = [
        "username"=>"budi",
        "password"=>"ibud"
    ];

    $susi = [
        "username"=>"susi",
        "password"=>"isus"
    ];

    $agus = [
        "username"=>"agus",
        "password"=>"suga"
    ];

    if(isset($_SESSION["user"])){
      array_push($_SESSION["user"],$agus);  
      array_push($_SESSION["user"],$budi);  
      array_push($_SESSION["user"],$susi);  
    }
    
    else{
        $_SESSION["user"] = [];
        array_push($_SESSION["user"],$agus);  
        array_push($_SESSION["user"],$budi);  
        array_push($_SESSION["user"],$susi);  
    }

?>