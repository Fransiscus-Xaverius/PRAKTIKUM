<?php
    require_once("start.php");

    if(isset($_REQUEST['tar'])){
        $tar = $_REQUEST['tar'];
    }
    else{
        header("location: admin.php");
    }

    if(isset($_POST["assign"])){
        $idx = $_SESSION["open"][0];
                
        header("location: admin.php");
    }

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="" method="post">
        <h1>Kasus <?php 
        $kasus = $_SESSION["kasus"][$tar];
        echo $kasus["judul"];
        ?></h1>
        <br>
        Assign Kasus
        <br>

        <select name="babu" id="babu">
        <option value="agus">Agus</option>
        <option value="susi">Susi</option>
        <option value="budi">Budi</option>
        </select>
        <br>
        <br>
        <button type="submit" name="assign">Assign Kasus</button>
        <br><br>
    </form>
    <a href="admin.php"><button>Back to Admin</button></a>
</body>
</html>