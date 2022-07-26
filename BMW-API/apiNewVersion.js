/* eslint-disable no-console */
import API from '@mihaiblaga89/bmw-connecteddrive-api';

await API.init({
    region: 'eu',
    username: 'aichhorn.stif@gmail.com',
    password: 'netfoX-roxxuc-3tabqi',
    debug: true,
});

const currentVehicles = await API.getVehicles();
console.log('currentVehicles', currentVehicles);