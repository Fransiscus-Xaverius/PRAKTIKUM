<?php

    require_once("helper.php");

    if(isset($_POST["masuk"])){
        $nama = $_POST["nama"];
        if($nama==""){
            echo "<script>alert('Field harus diisi.')</script>";
        }
        else if(preg_match('~[0-9]+~', $nama)){
            echo "<script>alert('Nama Tidak boleh menggandung angka!')</script>";
        }
        else{
            unset($_SESSION["nama"]);
            $_SESSION["nama"]=$nama;
            header("location: menu.php");
        }
    }

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
        .container{
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .inside{
            height: 100%;
            width: 400px;
            padding: 30px;
            border-radius: 10px;
        }

    </style>
</head>
<body onload="welcome()">
    <div class="container">
        <form action="" method="POST">
            <div class="form-group bg-primary inside">
                <label for="formGroupExampleInput" style="color: white;">Nama Pelanggan</label>
                <input type="text" class="form-control" id="nama" name="nama" placeholder="Nama Pelanggan">
                <button type="submit" class="btn btn-danger" id="masuk" name="masuk">Masuk</button>
            </div>
        </form>
    </div>
</body>
<script>
    function welcome(){
        alert("Selamat Datang Customer!");
    }
</script>
</html>