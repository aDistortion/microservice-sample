// @flow
import { HttpClient } from "./httpClient.jsx";

const httpClient = new HttpClient;

export class OrderProcessService {
  checkIn(order: Object, cb: (res: Object) => mixed){
    let orderVal = new ObjectValue(order, "at.free23.order.process.api.Order");
    let request = new SubmitFormRequest({order: orderVal});
    httpClient.post("/order-process/rest/engine/default/process-definition/key/orderProcess/submit-form", request, cb);
  }
  fetchInstanceVariables(instanceId: number, cb: (res: Object) => mixed){
    httpClient
      .getWithResponse('/order-process/rest/engine/default/process-instance/'+instanceId+'/variables')
      .then(variables => {
        let cleanedVars = {};
        Object.keys(variables).forEach(key => cleanedVars[key] = variables[key].value);
        return cleanedVars;
      })
      .then(vars => cb(vars))
      .catch((err: string) => console.log('Error reading instance variables '+err));
  }
  fetchInstance(instanceId: number, cb: (res: Object) => mixed){
    httpClient.get('/order-process/rest/engine/default/process-instance/'+instanceId, cb);
  }
  fetchTask(instanceId: number, cb: (res: Object) => mixed){
    httpClient.get('/order-process/rest/engine/default/task?processInstanceId='+instanceId, cb);
  }
  completeTask(taskId: number, cb: (res: Object) => mixed){
    httpClient.post('/order-process/rest/engine/default/task/'+taskId+'/complete', {variables: {} }, cb);
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