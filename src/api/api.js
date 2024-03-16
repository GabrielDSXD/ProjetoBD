import axios from 'axios'

const api_url = 'http://localhost:8080/'

const api = axios.create({
    baseURL: api_url
  });

  /*
  instance.get('produtos/listar').then(function (response) {
    console.log(response.data);
    console.log(response.status);
    console.log(response.statusText);
    console.log(response.headers);
    console.log(response.config);
  });
  */

  export default api
