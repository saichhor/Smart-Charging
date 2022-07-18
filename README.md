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
  HTTPS request should be sent to a digital input (in the Loxone Config). <br />
- Structure of the HTTPS request: "https://[host+port]/jdev/sps/io/[name]/[value]"
- 