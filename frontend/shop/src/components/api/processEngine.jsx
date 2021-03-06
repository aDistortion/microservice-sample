// @flow
import { HttpClient } from "./httpClient.jsx";

export class OrderProcessService {
  
  httpClient: HttpClient;

  constructor(){
    let host = "http://shop.sample.com/api";
    if(process.env.NODE_ENV !== "production"){
      host = "http://localhost:8084";
    }
    this.httpClient = new HttpClient(host+"/order-process/rest/engine/default");
  }

  checkIn(order: Object, cb: (res: Object) => mixed){
    let orderVal = new ObjectValue(order, "at.free23.order.process.api.Order");
    let request = new SubmitFormRequest({order: orderVal});
    this.httpClient.post("/process-definition/key/orderProcess/submit-form", request, cb);
  }
  fetchInstanceVariables(instanceId: number, cb: (res: Object) => mixed){
    this.httpClient
      .getWithResponse('/process-instance/'+instanceId+'/variables')
      .then(variables => {
        let cleanedVars = {};
        Object.keys(variables).forEach(key => cleanedVars[key] = variables[key].value);
        return cleanedVars;
      })
      .then(vars => cb(vars))
      .catch((err: string) => console.log('Error reading instance variables '+err));
  }
  fetchInstance(instanceId: number, cb: (res: Object) => mixed){
    this.httpClient.get('/process-instance/'+instanceId, cb);
  }
  fetchTask(instanceId: number, cb: (res: Object) => mixed){
    this.httpClient.get('/task?processInstanceId='+instanceId, cb);
  }
  completeTask(taskId: number, cb: (res: Object) => mixed){
    this.httpClient.post('/task/'+taskId+'/complete', {variables: {} }, cb);
  }
}

class SubmitFormRequest {
  variables: Object;

  constructor(variables: Object){
    this.variables = variables;
  }
}

class ObjectValue{
  value: string;
  type: string;
  valueInfo: {
    objectTypeName: string,
    serializationDataFormat: string };

  constructor(obj: Object, type: string){
    this.value = JSON.stringify(obj);
    this.type = 'Object';
    this.valueInfo = {
        objectTypeName: type,
        serializationDataFormat: "application/json"
    };
  }
}