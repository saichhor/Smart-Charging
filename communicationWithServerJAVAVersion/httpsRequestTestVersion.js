import XMLHttpRequest from 'xhr2';

var request = new XMLHttpRequest();

var userName = "Experte";
var passWord = "Experte1234";

function authenticateUser(user, password) {
    var token = user + ":" + password;

    var hash = btoa(token);

    return "Basic " + hash;
}

function setBatteryLevel(value) {
    var ausgabetext = "";

    (async () => {

        request.open("GET", "https://dns.loxonecloud.com/504F94A0EC9E/jdev/sps/io/Akkustand/" + value.toString());
        request.setRequestHeader("Authorization", authenticateUser(userName, passWord));
        request.addEventListener('load', function (event) {
            if (request.status >= 200 && request.status < 300) {
                ausgabetext = (request.responseText).toString();
                process.exit(1);
            } else {
                ausgabetext = request.statusText.toString() + " - " + request.responseText.toString();
                process.exit(1);
            }

        });
        request.send();

    })();

    return ausgabetext

}

for (var i = 0; i <= 100; i++) {
    console.log(setBatteryLevel(i).toString());
}