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
- Im nächsten Schritt beschäftigten wir uns damit, wo wir die URL im Testbeispiel angeben.
  <br /> Nach längerem suchen fanden wir es dann in der "index.js" im Testordner auf Zeile 67.
  <br /> Dort haben wir dann die URl auf den Hostnamen geändert und den Benutzernamen und das Passwort
  das des Miniservers.