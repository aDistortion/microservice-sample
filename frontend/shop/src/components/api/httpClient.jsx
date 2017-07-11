// @flow
const headers: Object = {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
}

const baseUrl: string = "http://shop.sample.com";

export class HttpClient{
  get(url: string, cb: (res: Object) => mixed): void{
    fetch(baseUrl + url, {method: 'GET'})
    .then(response => response.json())
    .then((res: Object) => cb(res))
    .catch((err: string) => console.log('Error reading response '+err));
  }

  getWithResponse(url: string): Promise<Object>{
    return (fetch(baseUrl + url, {method: 'GET'})
    .then(response => response.json()));
  }

  post(url: string, payload: Object, cb: (res: Object) => mixed): void{
    fetch(baseUrl + url,{
          headers: headers,
          method: "POST",
          body: JSON.stringify(payload)})
    .then(response => response.json())
    .then((res: Object) => cb(res))
    .catch((err: string) => console.log('Error posting request '+err));
  }

}