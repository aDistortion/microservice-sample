import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { OrderProcess } from './process.model';

@Injectable()
export class ProcessService {
  public orderProcess: Observable<OrderProcess>;
  private processPrefix: String = '/api/order-process/rest/engine/default';

  constructor(private httpClient: HttpClient) { }

  init(checkOutId: String): Observable<OrderProcess> {
    console.log(checkOutId);
    const reqOpts = {
      params: new HttpParams().set('processVariables', 'checkOutId_eq_' + checkOutId)
    }
    this.orderProcess = this.httpClient.get<OrderProcess>(this.processPrefix + '/task', reqOpts);
    return this.orderProcess;
  }

}

// TODO:
// /task/{id}/form-variables
// ?variableNames=street,streetNo,zip,city,firstName,lastName,invoice_lastName,invoice_firstName,invoice_street,invoice_streetNo,invoice_city,invoice_zip,differentInvoiceAddress

