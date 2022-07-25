var XMLHttpRequest = require('xhr2');
var request = new XMLHttpRequest();

var userName = "Experte";
var passWord = "Experte1234";

function authenticateUser(user, password)
{
    var token = user + ":" + password;

    var hash = btoa(token);

    return "Basic " + hash;
}

function setBatteryLevel(value){
    var ausgabetext = "";

    request.open("GET", "https://dns.loxonecloud.com/504F94A0EC9E/jdev/sps/io/Akkustand/" + value.toString());
    request.setRequestHeader("Authorization", authenticateUser(userName, passWord));
    request.addEventListener('load', function (event) {
         if (request.status >= 200 && request.status < 300) {
             ausgabetext = request.responseText.toString();
         } else {
             ausgabetext = request.statusText.toString() + " - " + request.responseText.toString();
         }

    });
    request.send();
    return ausgabetext;
}

for (i = 0; i <= 100; i++) {
    setTimeout(setBatteryLevel(i), 1000);
}