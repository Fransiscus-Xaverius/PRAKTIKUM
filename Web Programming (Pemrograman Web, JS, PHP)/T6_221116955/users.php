<?php
    require_once('start.php');

    $result = $conn->query("SELECT * FROM customer");
    $banyak = $conn->query("SELECT COUNT(id_cust) FROM customer");
    $hasil = $banyak->fetch_ASSOC();

    for ($i=1; $i <= $hasil["COUNT(id_cust)"]; $i++) { 
        if(isset($_POST["delete" . $i])){
            $quer = "DELETE FROM customer WHERE id_cust=".$i;
            if ($conn->query($quer) === TRUE) {
                echo "<script>alert('Deleted User')</script>";
              } else {
                echo "script>alert('Error Deleting User.)</script>";
              }
            }
    
    }

    for ($i=1; $i <= $hasil["COUNT(id_cust)"]; $i++) { 
        if(isset($_POST["reset" . $i])){
            $quer = "UPDATE customer set password='dibawahkarpet' where id_cust=".$i;
            if ($conn->query($quer) === TRUE) {
                echo "<script>alert('Resetted Password.')</script>";
              } else {
                echo "script>alert('Error resetting password.)</script>";
              }
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
<style>
    table, th, td{
        text-align:center;
        border:1px solid black;
    }
</style>
<body>
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
    <div class="containerbawah">
        <form action="" method="POST">
        <table style="width: 50%;">
        <tr>
        <th>Nomor</th>
        <th>Nama User</th>
        <th>Status</th>
        <th>Action</th>
        </tr>
        <?php
            $result = $conn->query("SELECT * FROM customer");
            $i = 1;
            foreach ($result as $key => $value) {
                echo "<tr>";
                echo "<td>".$i."</td>";
                echo "<td>".$value["username"]."</td>";
                echo "<td>";
                if($value["room_id"]==NULL){
                    echo "Not Playing";
                }
                else{
                    echo "Playing";
                }
                echo "</td>";
                echo "<td>";
                echo '<button style="border-radius:10px; background-color:red; color:white;" name=delete'.$value["id_cust"].'>Delete User</button>';
                echo '<button style="border-radius:10px; background-color:blue; color:white;" name=reset'.$value["id_cust"].'>Reset Password</button>';
                echo "</td>";
                echo "</tr>";
                $i++;
            }
        ?>
        </table>
        </form>
    </div>
</body>
</html>