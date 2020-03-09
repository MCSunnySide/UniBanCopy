<?php
$content = $_POST['list'];
$file = fopen("list.txt", "w") or die("Unable to open file!");
fwrite($file, $content);
fclose($file);
die(200);
