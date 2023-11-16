import axios from 'axios';

const client = axios.create({
    baseURL: 'https://www.cheapshark.com/api/1.0',
})

export default client;