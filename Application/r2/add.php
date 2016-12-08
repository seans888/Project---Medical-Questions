 

<!doctype html>
<html>
<head></head>
<body>
    <form action="add.php" method="post" autocomplete="off">
        <label>
            Title
            <input type="text" name="title">
        </label>
        <label>
            <textarea name="body" rows="8"></textarea>
        </label>
        <label>
            Keywords
            <input type="text" name="keywords" placeholder="comma, separated">
        </label>
        <input type="submit" value="add">
    </form>
</body>
</html>