# smart-charging

## 14.7.2022
- Created Git-Repository
- Created Test File for HTTP-Request

## 15.7.2022
- HTTP-Request on Test-API
- Read the documentation and made simple requests
- Studied the Loxone api

## 18.07.2022
- Noticed that we had not to do the "Setting up a connection" task
  under the Link: <br /> 
  https://www.loxone.com/dede/wp-content/uploads/sites/2/2022/06/1300_Communicating-with-the-Miniserver.pdf
  <br />
  We started to take a cloer look into the Loxone "lxcommunicator" Folders <br />
  that we downloaded from GitHub under: <br />
  https://github.com/Loxone/lxcommunicator <br/>
  We made the steps under this Link. Before we had to download "node.js" for Windows to use it in CLion. <br />
  https://nodejs.org/en/download/
- In the next step we dealt with where we put the URL in the test example.
  <br /> After a long search we found it in the "index.js" in the test folder on line 67.
  <br /> There we then changed the URl to the hostname and the username and password
  that of the mini server.
- We talked to an internal software developer how best to do it now
  should do. We found out that the "lxcommunicator" is superfluous there
  For starters, we only send data from Aichhorn to its BMW cloud connection via a simple
  HTTPS request should be sent to a digital input (in the Loxone-Config). <br />
>- Request:<br>https://[host+port]/jdev/sps/io/[name]/[value]
>- Or when the above-mentioned link does not work use the following link:<br />
   https://dns.loxonecloud.com/[seriennummer]/jdev/sps/io/[name]/[value]
- The next step is to add a few digital inputs to the Loxone-Config and to simulate 
  the charge level and the remaining range
- We made a new site in the Loxone-Config and added a digital input that we named "Akkustand"
  <br /> which shows the percentage of the battery as a slider.
- We made a new folder named "communicationWithServer" in which we (task we have to
  do today or tomorrow) send a HTTPS-Request, as shown above, to the digital input
  to set his value.

## 19.07.2022
- We tried to get a connection, with the link mentioned above, in postman.
  <br /> The result: we got a 403 code which means:
  <br /> "403 Forbidden, if the element exists, but your user has no access (Loxone user permissions)"
- We tried to figure it out, we did not manage it until yet.

## 20.07.2022
- We started to test the link "https://dns.loxonecloud.com/[seriennummer]/jdev/sps/io/Akkustand/75" <br />
  in a browser, but we got the error "excess on dns.loxonecloud.com was denied".
- After talking with an external employee we found the problem.
  <br /> As expected our miniserver was not registered. To activate CloudDNS at Loxone <br />
  you <b>HAVE TO!!!</b> register your miniserver on their website. <br />
  --> after that you get automatically access to it and you can communicate with the link 
  mentioned above
- I tried it with the link mentioned above. 
  <br /> The result: <br />
  --> In Postman the url does not work but after unplugging the miniserver and changing the settings
  <br /> in the config in the "external connection"-section to "connection with REMOTE CONTROLL"
  <br /> I got asked in the browser to please enter my username and password and suddenly the slider
  <br /> named "Akkustand" got the value 75 which I sent in the url.
>- Responde from the browser: <br>{"LL": { "control": "dev/sps/io/Akkustand/75", "value": "75.000", "Code": "200"}}
  <br /> --> IT WORKS!!!

## 21.07.2022
- In school Mr. Tarta and Spahr tried to build a connection with the miniserver.
  They tried so many things but could not get a connection. They had to change the location.
  Meanwhile Mr. Aichhorn tried to implement some methods with which you can run a c++ application.
  He tried so many things but at the end it does not work. He spoke with our internal supervisor
  and now we can make it in Java. For the communication with the server, in Java, we made a new project
  loaded our old one from GitHub und made a new folder called "communicationWithServerJAVAVersion"
  in which we send a https-request to the server. We are also trying to send our login values
  within the url so we do not have to login manually anymore.
- Current status <b>NOW</b> httpsRequest.js puts out a html report.
- Now it says us a 401 code as expected because we have to authorize our self with the username
  and the password but we still do not know how to send them with the url in the correct way
  so the browser does not ask us anymore.

## 22.07.2022
- In the morning we got a new message from our internal supervisor because of the problem
  with the authentication on the miniserver.
- To get this going we have to do activate the following things in the "Settings"
  section, under the url of the request:
  1. Automatically follow redirects
  2. Follow original HTTP-Method
  3. Follow Authorization Header
- Then we have to go to the "Authorization" section and set the "Type" to "Basic Auth".
  <br> --> Now we can set username and a password.
- After a little-bit of searching I found some code on stackoverflow to send
  the username and the password within the header of the request.
- The result: --> <b>It works perfectly</b>
  <br> The battery level changes on the app and we do not have to type in the
  authentication information anymore. Everything runs automatically.
>-If we did not mentioned it to get the green run symbol in IntelliJ you have to
  run it first in the "Terminal": <br/><b>node httpsRequest.js</b>
