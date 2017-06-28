
const headers = {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
}

const baseUrl = "http://shop.sample.com";

export class HttpClient{
  get(url, cb){
    fetch(baseUrl + url, {method: 'GET'})
    .then(response => response.json())
    .then(res => cb(res))
    .catch(err => console.log('Error reading response '+err));
  }
  getWithResponse(url){
    return (fetch(baseUrl + url, {method: 'GET'})
    .then(response => response.json()));
  }

  post(url, payload, cb){
    fetch(baseUrl + url,{
          headers: headers,
          method: "POST",
          body: JSON.stringify(payload)})
    .then(response => response.json())
    .then(res => cb(res))
    .catch(err => console.log('Error posting request '+err));
  }

  postEmpty(url, cb){
    fetch(baseUrl + url,{
          headers: headers,
          method: "POST"})
    .then(response => response.json())
    .then(res => cb(res))
    .catch(err => console.log('Error posting request '+err));
  }
}