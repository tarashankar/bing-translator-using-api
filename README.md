# bing-translator-using-api

Automated using selenium.

In this repository, following things are automated:-

1. Get the translated words from website. (input is getting from input1.csv, and output is created to opfromweb.csv)
2. Get the translated words from bing api without using token. (input is getting from input1.csv, and output is created to opfromapi.csv)
3. Get the translated words from bing api from generated token by making http web service. (input is getting from input1.csv, and output is created to opfromhttp.csv)
4. Now, using testNG I have compared both the output files from web and through http request.
5. You can change the words and languages in input.csv to check your own input.


software recomendations:-
jdk 8
selenium jar file, microsoft translator dependency
