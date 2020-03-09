# UniBan Copy

Just a plugin allow you upload your UniBan list to remote web server.

## Nginx Rewrite
````
location /banlist/get {
   try_files /banlist/list.txt $uri;
}
````

And sub url "https://example.com/banlist".

## BEWARE
HIDE YOUR PHP FILE WITH A RANDOM NAME