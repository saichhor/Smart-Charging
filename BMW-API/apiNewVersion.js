/* eslint-disable no-console */
import API from '@mihaiblaga89/bmw-connecteddrive-api';

const username = "aichhorn.stif@gmail.com";
const password = "netfoX-roxxuc-3tabqi";

await API.init({
    region: 'eu',
    username: username,
    password: password,
    debug: true,
});

const currentVehicles = await API.getVehicles();
console.log('currentVehicles', currentVehicles);