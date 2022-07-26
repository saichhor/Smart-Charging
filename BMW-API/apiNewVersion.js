import API from '@mihaiblaga89/bmw-connecteddrive-api';

await API.init({
    region: 'eu',
    username: '[email protected]',
    password: 'mySuperPassword',
});

const vehicles = await API.getVehicles();

const vehicleStatus = await vehicles[0].getStatus();