# UniBan Copy

Just a plugin allow you upload your UniBan list to remote web server.

## REWRITE
````
location /banlist/get {
   try_files /banlist/list.txt $uri;
}
````

And sub url "https://example.com/banlist".

## BEWARE
HIDE YOUR PHP FILE WITH A RANDOM NAME

## DEMO
https://api.mcsunnyside.com/game/mojang/minecraft/banlist/sunnyside/get
