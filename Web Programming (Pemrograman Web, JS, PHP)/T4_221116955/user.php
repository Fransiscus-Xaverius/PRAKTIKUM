<?php
    $tar = 0;
    $teamName = "";
    $data = [];
    
    if(isset($_REQUEST['data'])){
        $data = json_decode($_REQUEST['data'],true);
    }

    if(isset($_REQUEST['tar'])){
        $tar = $_REQUEST['tar'];
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
    <h1>
        <?php
            echo $data[$tar]['TEAMNAME'];
        ?>
    </h1>
    <br>
    <br>
    Nama Coach: 
    <?php
        echo $data[$tar]['COACHNAME'];
    ?>
    <br>
    Nomor Telpon: 
    <?php
        echo $data[$tar]['TELNUM'];
    ?>
      
    
    <form action="" method="POST">
        <button type="submit" formaction="index.php" >Logout</button>
        <br>
        <h1>Schedule</h1>
        <br> 
        <table border = "1">
            <tr>
                <th>Action</th>
                <th>Score</th>
                <th>Event</th>
                <th>Score</th>
                <th>Action</th>
            </tr>
            
            <?php
                
            ?>
        </table>
        <input type="hidden" name="data" value='<?php echo json_encode($data ?? ""); ?>'>
    </form>
</body>
</html>