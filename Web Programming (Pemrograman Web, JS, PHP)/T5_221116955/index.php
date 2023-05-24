<?php

    require_once("start.php");

    if(isset($_SESSION["user"])){

    }
    else{
        require_once("mulai.php");
    }

    if(isset($_SESSION["kasus"])){
        
    }
    else{
        $_SESSION["kasus"] = [];
    }

    if(isset($_POST["laporkan"])){
        $judul = $_POST["judul"];
        $nama = $_POST["nama"];
        $notelp = $_POST["notelp"];
        $kategori = $_POST["kategori"];
        $deskripsi = $_POST["deskripsi"];
        if($judul==""||$nama==""||$notelp==""||$kategori==""||$deskripsi==""){
            alert("Semua Field Harus diisi");
        }
        else{
            $kasusBaru = [
                "judul"=>$judul,
                "nama"=>$nama,
                "notelp"=>$notelp,
                "kategori"=>$kategori,
                "deskripsi"=>$deskripsi,
                "status"=>"Terbuka",
                "read"=>false,
                "assigned"=>"f"
            ];

            array_push($_SESSION["kasus"],$kasusBaru);
            alert("Berhasil Melaporkan kasus!");
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
    <link rel="stylesheet" href="style.css?v=<?php echo time(); ?>">
</head>
<body>
    <form action="" method="post">
        <div class="maincenter">
            <h1 class='judul'>Lapor Polisi!</h1>
            <div class="content">
                Judul <br>
                <input type="text" name="judul"> <br><br>
                Nama Pelapor <br>
                <input type="text" name="nama"> <br><br>
                Nomor Telepon <br>
                <input type="text" name="notelp"> <br> <br>
                Kategori Kasus <br>
                <select name="kategori" id="">
                    <option value="Ringan">Kejahatan Ringan</option>
                    <option value="Kekerasan">Kasus Kekerasan</option>
                    <option value="Darurat">Kasus Darurat</option>
                </select> <br><br>
                Deskripsi Kasus <br>
                <textarea name="deskripsi" id="" cols="25" rows="10" ></textarea>
                <br>
                <button name="laporkan" class="maintombol">Laporkan</button>
                <button type="submit" formaction="login.php" class="maintombol">login</button>
            </div>
        </div>
    </form>
</body>
</html>