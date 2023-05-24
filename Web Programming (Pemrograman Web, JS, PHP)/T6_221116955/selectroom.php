<?php

    require_once('start.php');
    $user = [];
    if(isset($_SESSION["user"])){
        $user = $_SESSION["user"];
        echo '<div class="section" style="width:50%">
            <div style="font-size: 30px">Welcome '.$user["username"].'</div>
        </div>';
    }else{
        header("location: index.php");
    }

    $result = $conn->query("SELECT * FROM room");
    $temp = $conn->query("SELECT * FROM room");
    $banyak = $conn->query("SELECT COUNT(room_id) FROM room");
    $hasil = $banyak->fetch_ASSOC();
    $resASSOC = $temp->fetch_ASSOC();

    for ($i=1; $i <= $hasil["COUNT(room_id)"]; $i++) { 
        if(isset($_POST["button" . $i])){
            if($resASSOC["room_id"]==$_SESSION["user"]["room_id"]){
                $sql = "UPDATE customer set room_id=".NULL." where id_cust=".$_SESSION["user"]["id_cust"];
                if($conn->query($sql)===TRUE){
                    echo "<script>alert('Left The room')</script>";
                }
                else{
                    echo "error";
                }
            }
            else{
                $sql = "UPDATE customer set room_id=".$i." where id_cust=".$_SESSION["user"]["id_cust"];
                
                if($conn->query($sql)===TRUE){
                    echo "<script>alert('Entered the room')</script>";
                }
                else{
                    echo "error";
                }
            }
        }
    }

    if(isset($_POST["back"])){
        header("location: index.php");
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
<style>
    table, th, td{
        text-align:center;
        border:1px solid black;
    }
</style>
<body style="display: flex; flex-direction: column; justify-items:center;">
    <div class="atas" style="width:100%; height:50px; display: flex; flex-direction: row; justify items-center">
         
        <div class="section" style="width:50%; display: flex; align-items:right;">
        <form action="" method="POST">
            <button type=submit name="back">Back to Dashboard.</button>
        </form>
        </div>
    </div>
    <div class="containerbawah" style="display:flex; flex-direction:row; justify-items:center;">
        <form action="" method="POST">
            <table>
                <tr>
                    <th>Nomor</th>
                    <th>Nama Ruangan</th>
                    <th>Isi Ruangan</th>
                    <th>Status Ruangan</th>
                    <th>Action</th>
                </tr>
                <?php
                    $result = $conn->query("SELECT * FROM room");
                    $i = 1;
                    foreach ($result as $key => $value) {
                        echo "<tr>";
                        echo "<td>".$i."</td>";
                        echo "<td>".$value["nama_room"]."</td>";
                        echo "<td>";
                        echo $value["jum_orang"]."/4";
                        echo "</td>";
                        if($value["jum_orang"]==4){
                            echo '<td style="color: red">Penuh</td>';
                        }
                        else{
                            echo '<td style="color: green">Open</td>';
                        }
                        echo '<td><button style="border-radius:10px; background-color:red; color:white;" name=delete'.$value["room_id"].'>Join</button></td>';
                        echo "</tr>";
                        $i++;
                    }
                ?>
            </table>
        </form>

    </div>
</body>
</html>