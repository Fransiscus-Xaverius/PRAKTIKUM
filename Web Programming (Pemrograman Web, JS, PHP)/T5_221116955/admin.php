<?php
    require_once("start.php");

    if(isset($_SESSION["kasus"])){
        foreach ($_SESSION["kasus"] as $key) {
            if($key["read"]==false){
                $key["read"]=true;
                $color = "";
                if($key["kategori"]=="Ringan"){
                    $color = "lightgreen";
                }
                else if($key["kategori"]=="Kekerasan"){
                    $color = "yellow";
                }
                else{
                    $color = "red";
                }
                echo "<div class=".$color.";>Kasus baru dengan kategori ".$key["kategori"]." telah dilaporkan oleh ".$key["nama"]."</div>";
            }
        }
    }

    for ($i=0; $i < sizeof($_SESSION["kasus"]); $i++) {
        $tar = $i+1;
        $tombol = 'kasus'.$tar;
        if(isset($_POST[$tombol])){
            $_SESSION["open"] = [];
            $_SESSION["open"] = $i;
            header("location:buka.php?data="."&tar=".$i);
        }
    }

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
    <link rel="stylesheet" href="style.css?v=<?php echo time(); ?>">
</head>
<body>
    <form action="" method="POST">
        <h1 class="judul">DASHBOARD LAPORAN</h1>
        <table>
            <?php
                echo"<tr>";
                echo "<th>Nomor</th>";
                echo "<th>Judul</th>";
                echo "<th>Nama Pelapor</th>";
                echo "<th>Nomor Telepon</th>";
                echo "<th>Kategori Kejahatan</th>";
                echo "<th>Deskripsi Kejahatan</th>";
                echo "<th>Status Pengerjaan</th>";
                echo "<th>Action</th>";
                echo"</tr>";
                $count = 1;
                
                foreach ($_SESSION["kasus"] as $key) {
                    $namaTombol = 'kasus'.$count;
                    $judul = $key["judul"];
                    $nama = $key["nama"];
                    $notelp = $key["notelp"];
                    $kategori = $key["kategori"];
                    $deskripsi = $key["deskripsi"];
                    $status = $key["status"];
                    $class = "";
                    if($kategori=="Ringan"){
                        $class = "kasusRingan";
                    }
                    else if($kategori=="Kekerasan"){
                        $class = "kasusKekerasan";
                    }
                    else{
                        $class = "kasusDarurat";
                    }
                    echo "<tr>";
                    echo "<td class='$class'>$count</td>";
                    echo "<td class='$class'>$judul</td>";
                    echo "<td class='$class'>$nama</td>";
                    echo "<td class='$class'>$notelp</td>";
                    echo "<td class='$class'>$kategori</td>";
                    echo "<td class='$class'>$deskripsi</td>";
                    echo "<td class='$class'>$status</td>";
                    echo "<td class='$class'><button name='$namaTombol'>Action</button></td>";
                    echo "</tr>";
                    $count++;
                }
            ?>
        </table>
    </form>

    <a href="index.php"><button class="metu">Logout</button></a>

</body>
</html>