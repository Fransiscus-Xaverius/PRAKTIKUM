<?php
    include("helper.php");
    if(isset($_GET['input'])){
        $keyword = $_GET["input"];
        $query = "SELECT * from menu WHERE nama_menu like '{$keyword}%'";
        $hasil = mysqli_query($conn,$query);

        if(mysqli_num_rows($hasil)==0){
            $query = "SELECT * FROM MENU";
            $hasil = mysqli_query($conn,$query);
        }
        $ctr = 1;
        while($row = mysqli_fetch_assoc($hasil)){
            $id = $row['id'];
            $nama = $row['nama_menu'];
            $deskripsi = $row['deskripsi'];        
            $harga = $row['harga'];
            $img = $row['img'];

            $count = 0;

            for ($i=0; $i < count($_SESSION["menu"]); $i++) { 
                if($_SESSION["menu"][$i]==$id){
                    $count++;
                }
            }

            echo '<div class="container">
                <div class="kiri"><img src="img/'.$img.'.jpg" class="logomenu img-rounded"></div><div class="kanan text-white"><div style="font-weight: bolder; font-size: 30px">'
                .$nama.'</div><br>Deskripsi:'.$deskripsi.'<br>Harga :'.$harga.'</div>
                <button class="btn" onclick="klikNambah('.$ctr.')">+</button><button class="btn" id="label'.$ctr.'" type="button" disabled>'.$count.'</button><button class="btn" onclick="klikKurang('.$ctr.')">-</button>
            </div><br>';
            $ctr++;
        }

    }


?>