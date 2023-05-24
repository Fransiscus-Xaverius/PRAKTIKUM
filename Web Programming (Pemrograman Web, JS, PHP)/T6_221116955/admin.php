<?php

    require_once('start.php');

    if(isset($_POST["logout"])){
        header("location: index.php");
    }

    if(isset($_POST["user"])){
        header("location: users.php");
    }

    if(isset($_POST["rooms"])){
        header("location: rooms.php");
    }


?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="admin.css">
    <title>Document</title>
</head>
<body class=".bg-dark.bg-gradient">
    <div class="container">
        <div class="text-white text-capitalize font-weight-bold" style="width: 40rem; font-size: 40px; text-align:center">
            Welcome Admin. <br>
            Pick a page.
        </div>
        <form action="" class="ihateCSS" method="POST">
            <button type="submit" class="btn btn-primary" name="user">Users</button>
            <button type="submit" class="btn btn-danger" name="rooms">Rooms</button>
            <button type="submit" class="btn btn-secondary" name="logout">Log Out</button>
        </form>
    </div>
</body>
</html>