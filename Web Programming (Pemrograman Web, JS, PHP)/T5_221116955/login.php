<?php

    require_once("start.php");
    
    if(isset($_POST["login"])){
        $username = $_POST["username"];
        $password = $_POST["password"];
        if($username==""||$password==""){
            alert('Field Username dan Password harus diisi..');
        }
        else if($username=="admin"&&$password=="nimda"){
            alert("Welcome Admin.");
            header("location: admin.php");
        }
        else{
            $exist = false;
            $auth = false;
            foreach ($_SESSION["user"] as $user) {
                if($user["username"]==$username){
                    $exist = true;
                    if($user["password"]==$password){
                        $_SESSION["target"]=$user;
                        alert("Berhasil login.");
                        header("location: ");
                        $auth = true;
                    }
                }
            }
            if(!$exist){
                alert('Username tersebut belum terdaftar.');
            }
            if(!$auth){
                alert("Username/Password Tidak sesuai");
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
    <title>Document</title>
    <link rel="stylesheet" href="style.css?v=<?php echo time(); ?>">
</head>
<body>
    <div class="center">
        <h1 class="title">LOGIN PORTAL PULICI</h1>
        <form action=""method="POST">
            <div class="textfield">
                <input type="text" name="username" id="username">
                <span></span>
                <label>
                    USERNAME
                </label>
            </div>
            <div class="textfield">
                <input type="text" name="password" id="password">
                <span></span>
                <label>
                    PASSWORD
                </label>
            </div>
            <button class="tombol" type="submit" name="login" value="Login">
                Login
            </button>
            <button type="submit" name="back" value="Back" class="tombol">Back</button>
        </form>
    </div>
</body>
</html>