<?php
    $data = [];
    $teamName = "";
    $pass  = "";
    $confirm = "";
    $noTel  = "";
    $coachname = "";

    if(isset($_POST['data'])){
        $data = json_decode($_POST['data'],true);
    }

    if(isset($_POST['regis'])){
        if(isset($_POST['TEAMNAME']) && isset($_POST['COACHNAME']) && isset($_POST['PASS']) && isset($_POST['CONFIRM']) && isset($_POST['TELNUM'])){
            $teamName = $_POST['TEAMNAME'];
            $pass  = $_POST['PASS'];
            $confirm = $_POST['CONFIRM'];
            $noTel  = $_POST['TELNUM'];
            $coachname = $_POST['COACHNAME'];
            if($teamName == "" || $pass == "" || $confirm == "" || $noTel  == "" || $coachname ==""){
                echo "<script>alert('DIH KOSONGAN KEK NILAINYA KEK ARIEL')</script>";
            }
            else{
                $tar = -1;
                for ($i=0; $i < sizeof($data); $i++) { 
                    if($data[$i]['TEAMNAME']==$teamName){
                        $tar = $i;
                    }
                }
                if($tar!=-1){
                    echo "<script>alert('NAMA TEAM KEMBAR BRUH')</script>";
                }
                else{
                    if($confirm!=$pass){
                        echo "<script>alert('PASSWORD DAN CONFIRM PASSWORD TIDAK SAMA (KAMU BELAJAR NGETIK SAMA ARIEL YA?)')</script>";
                    }
                    else{
                        $data[]=[
                            'TEAMNAME'=>$teamName,
                            'PASS'=>$pass,
                            'COACHNAME'=>$coachname,
                            'TELNUM'=>$noTel
                        ];
                        echo "<script>alert('BERHASIL REGISTER!')</script>";
                    }
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
    <h1>Register</h1>
    <br><br>
    <form action="" method="POST">
        Nama Tim:
        <br>
        <input type="text" name="TEAMNAME" id="">
        <br>
        Nama Coach:
        <br>
        <input type="text" name="COACHNAME" id="">
        <br>
        Password: 
        <br>
        <input type="text" name="PASS" id="">
        <br>
        Confirm Password:
        <br>
        <input type="text" name="CONFIRM" id="">
        <br>
        Nomor Telepon:
        <br>
        <input type="text" name="TELNUM" id="">
        <br>
        <button type="submit" name= "regis">Register</button>
        Sudah memiliki akun? <input type="submit" name="RegisterBang" style="background-color: transparent; border: none; color: blue; text-decoration: underline;" value="Masuk Sekarang" formaction="index.php">
        <input type="hidden" name="data" value='<?php echo json_encode($data ?? ""); ?>'>
    </form>
</body>
</html>