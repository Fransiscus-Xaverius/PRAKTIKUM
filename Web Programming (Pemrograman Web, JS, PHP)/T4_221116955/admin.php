<?php

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
    <h1>Welcome, Admin</h1>
    <br>
    <form action="" method="POST">
        <button type="submit">Logout</button>
        <br>
        Users
        <table border = "1">

        </table>
        <input type="hidden" name="data" value='<?php echo json_encode($data ?? ""); ?>'>
    </form>

</body>
</html>