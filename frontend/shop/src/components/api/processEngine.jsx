import { HttpClient } from "./httpClient.jsx";

const httpClient = new HttpClient;

export class OrderProcessService {
  checkIn(order, cb){
    let orderVal = new ObjectValue(order, "at.free23.order.process.api.Order");
    let request = new SubmitFormRequest({order: orderVal});
    httpClient.post("/order-process/rest/engine/default/process-definition/key/orderProcess/submit-form", request, cb);
  }
  fetchInstanceVariables(instanceId, cb){
    httpClient
      .getWithResponse('/order-process/rest/engine/default/process-instance/'+instanceId+'/variables')
      .then(variables => {
        let cleanedVars = {};
        Object.keys(variables).forEach(key => cleanedVars[key] = variables[key].value);
        return cleanedVars;
      })
      .then(vars => cb(vars))
      .catch(err => console.log('Error reading instance variables '+err));
  }
  fetchInstance(instanceId, cb){
    httpClient.get('/order-process/rest/engine/default/process-instance/'+instanceId, cb);
  }
  fetchTask(instanceId, cb){
    httpClient.get('/order-process/rest/engine/default/task?processInstanceId='+instanceId, cb);
  }
  completeTask(taskId, cb){
    httpClient.postEmpty('/order-process/rest/engine/default/task/'+taskId+'/complete', cb);
  }
}

class SubmitFormRequest {
  constructor(variables){
    this.variables = variables;
  }
}

class ObjectValue{
  constructor(obj, type){
    this.value = JSON.stringify(obj);
    this.type = 'Object';
    this.valueInfo = {
        objectTypeName: type,
        serializationDataFormat: "application/json"
    };
  }
}