<?php

require_once 'vendor/autoload.php'  ;

$es = new ElasticSearch\Client([
    'hosts' => ['127.0.0.1.9200']
]);