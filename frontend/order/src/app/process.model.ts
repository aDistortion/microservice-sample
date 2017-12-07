
export class OrderProcess {
  public variables: Map<String, Object>;

  constructor(public processInstanceId: String, public taskDefinitionKey: String) { }
}
