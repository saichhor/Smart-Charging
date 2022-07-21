var XMLHttpRequest = require('xhr2');
var request = new XMLHttpRequest();

request.open("GET","https://dns.loxonecloud.com/504F94A0EC9E/jdev/sps/io/Akkustand/75");
request.addEventListener('load', function(event) {
    if (request.status >= 200 && request.status < 300) {
        console.log(request.responseText);
    } else {
        console.warn(request.statusText, request.responseText);
    }
});
request.send();