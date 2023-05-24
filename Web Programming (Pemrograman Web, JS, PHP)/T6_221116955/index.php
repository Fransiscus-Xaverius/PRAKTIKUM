<?php

    require_once('start.php');

    if(isset($_POST["login"])){
        $username = $_POST["loguser"];
        $password = $_POST["logPass"];
        if($username == ""||$password == ""){
            echo "<script>alert('Semua Field Harus diisi.')</script>";
        }
        else{
            if($username == "admin" && $password == "nimda"){
                header("location: admin.php");
            }
            else{
                $select = ("SELECT * from customer where username='$username'");
                $userQuery = mysqli_query($conn, $select);
                if(mysqli_num_rows($userQuery)){
                    $user = $userQuery->fetch_assoc();
                    if($user["password"]==$password){
                        echo "<script>alert('Berhasil Login')</script>";
                        $_SESSION["user"]=$user;
                        header("location: selectroom.php");
                    }
                    else{
                        echo "<script>alert('Username/Password Salah')</script>";
                    }
                }
                else{
                    echo "<script>alert('Username Tersebut Tidak terdaftar.')</script>";
                }

            }
        }
    }

    if(isset($_POST["regis"])){
        $username = $_POST["RegisUser"];
        $password = $_POST["RegisPass"];
        $email = $_POST["email"];
        $ConfirmPass = $_POST["ConfirmPass"];

        if($username == ""|| $password== ""||$email== ""||$ConfirmPass== ""){
            echo "<script>alert('Semua Field harus diisi.')</script>";
        }
        else{
            $select = ("SELECT * from customer where username='$username'");
            $userQuery = mysqli_query($conn, $select);
            if(mysqli_num_rows($userQuery)){
                echo "<script>alert('Username Tersebut sudah terdaftar!')</script>";
            }
            else{
                if($username=="admin"){
                    echo "<script>alert('Username tidak boleh admin!')</script>";
                }
                else{
                    if($password!=$ConfirmPass){
                        echo "<script>alert('Password dan Confirm password harus sama!')</script>";
                    }
                    else{
                        $selectEmail = ("SELECT * from customer where email='$email'");
                        $emailQuery = mysqli_query($conn, $selectEmail);
                        if(mysqli_num_rows($emailQuery)){
                            echo "<script>alert('Email Tersebut sudah digunakan!')</script>";
                        }
                        else{
                            $insert = "Insert into customer (username, password, email) values('$username', '$password', '$email')";

                            if ($conn->query($insert) === TRUE) {
                                echo "<script>alert('Berhasil Register!')</script>";
                            } 
                            else {
                            echo "Error: " . $insert . "<br>" . $conn->error;
                            }
                        }
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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<style>

body{
    background-color: black;
    margin: 0px;
    padding: 0px;
}

.container {
    width : 40%;
    height: 700px;
    border-radius: 25px;
    background-color: rgba(255, 255, 255, 0.70); 
    margin: 60px auto; 
}

.content {
    width: 40%;
    height: 650px;
    text-align: center;
    font-size: 20px;
    margin: auto;
}

</style>
<body>
    
    <div class="container">
        <div class="content">
        <h1>Login</h1>
    <br>
    <form action="" method="POST">
        Username : 
        <input type="text" name="loguser" id="loguser">
        <br>
        Password :
        <input type="text" name="logPass" id="logPass">
        <br>
        <input type="submit" class="btn btn-secondary" name="login" value="Login">
    </form>
    <br>
    <br>
    <h1>Register</h1>
    <form action="" method="POST">
        Username : 
        <input type="text" name="RegisUser" id="RegisUser">
        <br>
        Email :
        <input type="text" name="email" id="email">
        <br>
        Password :
        <input type="text" name="RegisPass" id="RegisPass">
        <br>
        Confirm Password :
        <input type="text" name="ConfirmPass" id="ConfirmPass">
        <br>
        <input type="submit" class="btn btn-secondary" name="regis" value="Register">
    </form>
        </div>
    </div>
</body>
</html>