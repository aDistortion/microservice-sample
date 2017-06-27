
export class HttpClient{
  constructor(props){
    this.props = props;
  }
  get(url, cb){
    fetch(url, {method: 'GET'})
    .then(response => response.json())
    .then(res => cb(res))
    .catch(err => console.log('Error reading response '+err));
  }
}