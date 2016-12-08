<?php

require_once 'init.php';
?>


<!doctype html>
<html>
<head></head>
<body>
    <form action="ask.php" method="get" autocomplete="off">
        <label>
            What is your question?
            <input type="text" name="q">
        </label>
        <input type="submit" value="go!">
    </form>
</body>
</html>