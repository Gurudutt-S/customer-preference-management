import { Injectable } from '@angular/core';
import { Customer } from '../model/customer-preference';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerPreferenceService {

  httpUrl = "http://localhost:8765/";

  constructor(private httpClient: HttpClient) { }

  getCustomerPrefernceById(custId: number): Observable<Customer> {
    return this.httpClient.get<Customer>(this.httpUrl + "get-customer-id-service/cts/superstore/customer/" + custId);
  }

  updateCustomerPreference(customer: Customer): Observable<Customer> {
    return this.httpClient.put<Customer>(this.httpUrl + "customer-preference-service/cts/superstore/customer/", customer);
  }

}
