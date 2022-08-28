/* eslint-disable no-console */
import API from '@mihaiblaga89/bmw-connecteddrive-api';

const username = "stefan.spahr44@gmail.com";
const password = "stefan0607.";

await API.init({
    region: 'eu',
    username: username,
    password: password,
    debug: true,
});

const vehicles = await API.getVehicles();

const vehicleStatus = await vehicles[0].getStatus();