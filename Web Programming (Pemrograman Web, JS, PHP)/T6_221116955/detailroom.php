<?php

    require_once("start.php");

    if(isset($_SESSION["roomNum"])){
        echo $_SESSION["roomNum"];
        $result = $conn->query("SELECT * FROM room where room_id=".$_SESSION["roomNum"]);
        $row = $result->fetch_all();
        
    }
    else{
        header("location: rooms.php");
    }

    if(isset($_POST["back"])){
        header("location: rooms.php");
    }
    if(isset($_POST["delete"])){
        $users = $conn->query("SELECT * FROM customer where room_id=".$_SESSION["roomNum"]);
        foreach ($users as $key => $value) {
            $conn->query("UPDATE customer set room_id=NULL where id_cust=".$value["id_cust"]);
        }

        $sql = "DELETE FROM room WHERE room_id=".$_SESSION["roomNum"];
        if ($conn->query($sql) === TRUE) {
            echo "Record deleted successfully";
          } else {
            echo "Error deleting record: " . $conn->error;
          }
        header("location: rooms.php");
    }

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<style>
    .container{
        width:100%;
        height:100%;
        display:flex;
        flex-direction: row;
        justify-content: center;
        justify-items: center;
        background-color: white;
    }

    .cont{
        width:60%;
        height:50%;
        flex-direction: column;
        justify-content: center;
        justify-items: center;
        background-color: purple;
        display:flex;
        align-items:center;
        margin:auto;
        justify-items:center;
        border-radius:20px;
    }

    .white{
        color: white;
    }


</style>
<body style="display:flex; flex-direction: column; justify-items:center; align-items:center">
    <?php
    
    ?>
    <div class="container">
        <div class="cont">
            <div class="white">
                <?php
                $result = $conn->query("SELECT * FROM room where room_id=".$_SESSION["roomNum"]);
                $row = $result->fetch_assoc();
                echo "<h1>".$row["nama_room"]."</h1><br>";
                echo "<h4> Jumlah Orang dalam room : ".$row["jum_orang"]."</h4>";
                echo "<h4> Console : ";
                $result = $conn->query('SELECT nama_console from console where id_console='.$row["id_console"]);
                $consoleInfo = $result->fetch_ASSOC();
                echo $consoleInfo["nama_console"]."<br><h4>";
                ?>
            </div>
            <form action="" method="POST">
                <button class="btn btn-primary" name="back">Back</button>';
                <button class="btn btn-danger" name="delete">Close Room</button>';
            </form>
        </div>
    </div>
</body>
</html>