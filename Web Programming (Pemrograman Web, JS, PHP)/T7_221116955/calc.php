<?php
    include("helper.php");
    if(isset($_GET["add"])){
        $input = $_GET["add"];
        array_push($_SESSION["menu"],$input);
        recalc();

    }

    if(isset($_GET["remove"])){
        $dex = -1;
        for ($i=0; $i < count($_SESSION["menu"]); $i++) { 
            if($_GET["remove"]==$_SESSION["menu"][$i]){
                $dex = $i;
            }
        }
        echo "<script>alert(".$dex.")</script>";
        if($dex!=-1){
            unset($_SESSION["menu"][$dex]);
            echo "<script>alert(".count($_SESSION["menu"]).")</script>";
            recalc();
        }
    }

    if(isset($_GET["hadeh"])){
        recalc();
    }

    if(isset($_GET["nota"])){
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
        $date = date("Y/m/d");
        $h = $_GET["nota"];

        $insert = "INSERT INTO `htrans`( `htrans_id`, `htrans_date`, `htrans_total`) 
	    VALUES ('$generateNoNota','$date','$h')";
        
        $q = mysqli_query($conn, $insert);

        if($q){
            $q = "SELECT * from menu";
            $hasil = mysqli_query($conn,$q);
            while($row = mysqli_fetch_assoc($hasil)){
                $id = $row["id"];
                $count = 0;
                for ($i=0; $i < count($_SESSION["menu"]); $i++) { 
                    if($_SESSION["menu"][$i]==$id){
                        $count++;
                    }
                }
                if($count>0){
                    $harga = ((int)$row["harga"])*$count;
                    $grandtotal+=$harga;
                    $dtrans = "INSERT INTO dtrans (`menu_id`, `htrans_id`, `jumlah`, `dtrans_subtotal`)
                    VALUES ('$id','$generateNoNota','$count','$harga')";
                    $go = mysqli_query($conn, $dtrans);
                }
            }
            unset($_SESSION["menu"]);
            $_SESSION["menu"] = [];
            recalc();
        }
        else{
            echo "<script>alert('Gagal Pesan')</script>";
        }

    }

    function recalc(){
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
        $grandtotal = 0;
        $query = "SELECT * FROM menu";
        $hasil = mysqli_query($conn,$query);
        while($row = mysqli_fetch_assoc($hasil)){
            $id = $row["id"];
            $count = 0;
            for ($i=0; $i < count($_SESSION["menu"]); $i++) { 
                if($_SESSION["menu"][$i]==$id){
                    $count++;
                }
            }
            if($count>0){
                $harga = ((int)$row["harga"])*$count;
                $grandtotal+=$harga;
                echo '<div style="width: 70%">'.$row["nama_menu"].' x'.$count.'</div> <div style="width: 30%;">Rp.'.$harga.'</div>';
            }
        }
        $_SESSION["grandtotal"]=$grandtotal;
        echo '<div style="display:flex; flex-direction: row;">';
        echo '<div style="width: 50%; font-weight:bold; font-size: 20px;">Grand Total : Rp.</div>';
        echo '<div style="width: 50%; font-weight:bold; font-size: 20px;" id="grandtotal">'.$grandtotal.'</div>';
        echo '</div>';
        echo '<form action="" method="POST">';
        echo '<button name="nota" style="width: 100%;border-radius:10px; border: 1px solid black" class="bg-danger text-white" onclick="bayar()">Bayar</button>';
        echo '</form>';

    }

?>