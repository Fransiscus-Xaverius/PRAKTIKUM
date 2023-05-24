<?php

    require("helper.php");

    unset($_SESSION["menu"]);

    if(isset($_SESSION["nama"])){
        $noNota = 0;
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
        $query ="SELECT COUNT(*) FROM htrans ORDER BY htrans_id DESC LIMIT 1";
        $hasil = $conn->query($query)->fetch_assoc(); 
        
        $cnt = intval($hasil["COUNT(*)"]);

        if($cnt==0){
            $noNota = "001";
        }
        else{
            $cnt++;
            if($noNota>100){
                $noNota = strval($cnt/100).strval($cnt%100/10).strval($cnt%10);
            }
            else if($noNota>10){
                $noNota = "0".strval($cnt%100/10).strval($cnt%10);
            }
            else{
                $noNota = "00".strval($cnt%10);
            }
        }
        $y = date("Y");
        $m = date("m");
        $d = date("d");
        
        $yn= strval($y);
        $mn= strval($m);
        $dn= strval($d);
            
        $generateNoNota = $yn.$mn.$dn.$noNota;
        
    }
    else{
        header("location: index.php");
    }

    if(isset($_SESSION["menu"])){

    }
    else{
        $_SESSION["menu"] = [];
    }

    if(isset($_SESSION["grandtotal"])){

    }
    else{
        $_SESSION["grandtotal"] = 0;
    }

    if(isset($_POST["Logout"])){
        unset($_SESSION["nama"]);
        header("location: index.php");
    }

//    if(isset($_POST["nota"])){
//         $query ="SELECT COUNT(*) FROM htrans";
//         $hasil = $conn->query($query)->fetch_assoc(); 
//         $cnt = intval($hasil["COUNT(*)"]);
        
//    }

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body{
            padding:20px;
            display:flex;
            flex-direction:column;
            justify-items:center;
        }

        .logomenu{
            width:200px;
            height:150px;
        }

        .list{
            height:500px;
        }

        .menu{
            justify-content: center;
            align-items: center;
            width:100%;
            height:80%;
        }

        .container{
            background-color:blue;
            height: 100%;
            width: 100%;
            display:flex;
            padding: 30px;
            border-radius: 10px;
        }

        .kiri{
            width: 30%;
            height: 100%;
        }

        .kanan{
            width: 70%;
        }

        .box{
            padding: 5%;
            width:95%;
            display:flex;
        }

        .btn{
            width:40px;
            height:40px;
            background:white;
            border: 1px solid black;
        }

    </style>

</head>
<body onload="onloadPage()">
    <form action="" method="POST">
        <div class="form-group">
            <input type="text" class="form-control" id="search" name="search" placeholder="Search Item" onkeyup="fetch_menu()">
        </div>
    </form>
    <div class="box">
    <div class="" style="border: 1px solid black; border-radius:10px; width: 70%">
        <h1>Menu</h1>
        <div id="menu">
        
        </div>
    </div>
    <div class="" style="padding: 10px;width: 30%">
        <h1>Order <?php echo $_SESSION["nama"] ?></h1>
        <h2><?php echo $generateNoNota ?></h2>
        <form action="" method="POST">
            <input type="submit" value="Logout" name="Logout" class="bg-danger text-white"><br><br>
        </form>
        <div id="order" style="width: 400px; display:flex; flex-direction:column; border: 1px solid black; border-radius:10px; padding:5px;">
            
        </div>
    </div>
    </div>

</body>
<script>
    function onloadPage(){
        menu = document.getElementById("menu");
        inp = document.getElementById("search");
        calc = document.getElementById("order");

        fetch_menu();
        initialCalc();
    }

    function fetch_menu(){
        keyword = inp.value;
        console.log(keyword);
        r = new XMLHttpRequest();
        r.onreadystatechange = function() {
            if ((this.readyState==4) && (this.status==200)) {
                menu.innerHTML = this.responseText;
                menu.value = this.responseText;
            }        
        }
        r.open('GET','searchitem.php?input='+keyword,true);
        r.send();
    }

    function initialCalc(){
        r = new XMLHttpRequest();
        r.onreadystatechange = function() {
            if ((this.readyState==4) && (this.status==200)) {
                calc.innerHTML = this.responseText;
            }        
        }
        r.open('GET','calc.php?hadeh=Y',true);
        r.send();
    }

    function Calc(dex){
        r = new XMLHttpRequest();
        r.onreadystatechange = function() {
            if ((this.readyState==4) && (this.status==200)) {
                calc.innerHTML = this.responseText;
            }        
        }
        r.open('GET','calc.php?add='+dex,true);
        r.send();
    }

    function Calc2(dex){
        r = new XMLHttpRequest();
        r.onreadystatechange = function() {
            if ((this.readyState==4) && (this.status==200)) {
                calc.innerHTML = this.responseText;
            }        
        }
        r.open('GET','calc.php?remove='+dex,true);
        r.send();
    }

    function bayar(){
        var target = document.getElementById("grandtotal");
        let nota = parseInt(target.innerHTML);
        if(nota>0){
            r = new XMLHttpRequest();
            r.onreadystatechange = function() {
                if ((this.readyState==4) && (this.status==200)) {
                    calc.innerHTML = this.responseText;
                }        
            }
            r.open('GET','calc.php?nota='+nota);
            r.send();
            alert('Berhasil Membeli.');
        }
        else{
            alert('Tidak ada yang dibeli.. yang benar kamu');
        }
    }

    function klikNambah(dex){
        var target = document.getElementById("label"+dex);
        let val = parseInt(target.innerHTML);
        val++;
        target.innerHTML=val;
        Calc(dex);
        fetch_menu();
    }

    function klikKurang(dex){
        var target = document.getElementById("label"+dex);
        let val = parseInt(target.innerHTML);
        if(val!=0){
            val--;
            target.innerHTML=val;
            Calc2(dex);
            fetch_menu();
        }
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</html>