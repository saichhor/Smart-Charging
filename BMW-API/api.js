import fetch from 'node-fetch';
import {Headers} from "node-fetch";

let headers = new Headers();

headers.set('Authorization', 'Basic ' + Buffer.from("postman" + ":" + "password").toString('base64'));

const response = await fetch('https://postman-echo.com/basic-auth',
    {
        method: 'GET',
        headers: headers,
    });
const data = await response.json();


console.log(data);
