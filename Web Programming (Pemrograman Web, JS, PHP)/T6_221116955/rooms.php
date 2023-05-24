<?php

    require_once('start.php');
    unset($_SESSION['roomNum']);
    $result = $conn->query("SELECT * FROM room");
    $banyak = $conn->query("SELECT COUNT(room_id) FROM room");
    $hasil = $banyak->fetch_ASSOC();

    for ($i=1; $i <= $hasil["COUNT(room_id)"]; $i++) { 
        if(isset($_POST["button" . $i])){
            echo "<script>alert('coba')</script>";
            $_SESSION["roomNum"]= $i;
            header("location: detailroom.php");
        }
    }

    if(isset($_POST["back"])){
        header("location: admin.php");
    }

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Document</title>
</head>
<body style="display: flex; flex-direction: column; justify-items:center;">
    <div class="atas" style="width:100%; height:50px; display: flex; flex-direction: row; justify items-center">
        <div class="section" style="width:50%">
            <div style="font-size: 30px">Welcome Admin.</div>
        </div>  
        <div class="section" style="width:50%; display: flex; align-items:right;">
        <form action="" method="POST">
            <button type=submit name="back">Back to Dashboard.</button>
        </form>
        </div>
    </div>
    <div class="containerbawah" style="display:flex; flex-direction:row; justify-items:center;">
        <form action="" method="POST">
        <?php
             $i = 1;
            if($result->num_rows>0){
                while ($row = $result->fetch_ASSOC()) {
                    $id = $row["id_console"];
                    $stmt = $conn->query("SELECT * FROM console WHERE id_console='$id'");
                    $console = $stmt->fetch_assoc();
                    echo'
                        <div class="card" style="width: 18rem; background-color:'.$console["warna_console"].'">
                            <div class="card-body">
                            <h5 class="card-title">'.$row["nama_room"].'</h5>
                                <p class="card-text">Room number.'.$row["room_id"].'</p>
                                <button class="btn btn-primary" name="button'.$i.'">Details</button>
                            </div>
                        </div>
                    ';
                    $i++;
                }
            }
        ?>
        </form>
    </div>
</body>
</html>