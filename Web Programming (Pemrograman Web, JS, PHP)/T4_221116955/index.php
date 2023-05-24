<?php

    $teamName = "";
    $pass  = "";
    $data = [];
    if(isset($_POST['data'])){
        $data = json_decode($_POST['data'],true);
    }

    if(isset($_POST['login'])){
        if(isset($_POST['TEAMNAME']) && isset($_POST['PASS'])){
            $teamName = $_POST['TEAMNAME'];
            $pass  = $_POST['PASS'];
            if($teamName==""||$pass==""){
                echo "<script> alert('Username dan password ini sangat bagus sekali hingga tidak dapat dilihat oleh mata kepala biasa. Hubungi Dokter mata untuk informasi lebih lanjut.')";
            }
            else if($teamName=="FIFA" && $pass=="admin"){

            }
            else{
                $tar = -1;
                for ($i=0; $i < sizeof($data); $i++) { 
                    if($data[$i]['TEAMNAME']==$teamName&&$data[$i]['PASS']){
                        $tar = $i;
                    }
                }
                if($tar!=-1){
                    header("location:user.php?data=".json_encode($data)."&tar=".$tar);
                    
                }
                else{
                    echo "<script>alert('Kamu siapa kamu siapa, aku siapa? ')</script>";
                }
            }
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
</head>
<body>
    <h1>Login</h1>
    <br><br>
    <form action="" method="POST">
        Nama Tim:
        <br>
        <input type="text" name="TEAMNAME" id="">
        <br>
        Password:
        <br>
        <input type="text" name="PASS" id="">
        <br>
        <button type="submit" name="login">Login</button>
        <br>
        <br>
        Belum mendaftar?
        <input type="submit" name="RegisterBang" style="background-color: transparent; border: none; color: blue; text-decoration: underline;" value="Daftar Sekarang" formaction="register.php">
        <input type="hidden" name="data" value='<?php echo json_encode($data ?? ""); ?>'>
    </form>
    
</body>
</html>