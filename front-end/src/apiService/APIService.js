import axios from 'axios';

const API_URL = 'http://localhost:8080/maveninternproject_war_exploded';
export function getContacts() {
        const url = `${API_URL}/company`;
        return axios.get(url).then(response => response.data);
    }

