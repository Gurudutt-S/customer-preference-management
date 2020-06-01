import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Customer } from '../model/customer-preference';
import { CustomerPreferenceService } from '../service/customer-preference.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  idForm: FormGroup;

  constructor(private router: Router, private formBuilder: FormBuilder, private customerService: CustomerPreferenceService) { }

  ngOnInit() {
    this.idForm = this.formBuilder.group({
      custId: ['', Validators.required]
    })
  }

  login() {
    let cid = this.idForm.get('custId').value;
    this.customerService.getCustomerPrefernceById(cid).subscribe(customer => {
      if (customer) {
        // console.log(customer);
        localStorage.removeItem('cusId');
        localStorage.setItem('cusId', cid);
        this.router.navigate(["customer-preference"]);
      }
    },
      error => {
        alert("customer not found..! please contact representative");
        this.router.navigate(["home"]);
      }
    );
  }


}
