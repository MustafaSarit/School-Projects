<?php
header('Content-Type: text/event-stream');
header('Cache-Control: no-cache');

date_default_timezone_set('Europe/Prague');
$id=date('u') % 10000;
while(true) {
  $time = date('c');
  echo "retry: 1000\n";
  echo "id: " . ($id++) . "\n";
  echo "event: time_change\n";
  echo "data: $time\n\n";
  ob_flush();
  flush();
  sleep(1);
}
?> 
