import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ProcessBarComponent } from './process-bar/process-bar.component';
import { ProcessService } from './process.service';
import { CheckOutComponent } from './check-out/check-out.component';

const appRoutes: Routes = [
  {
    path: ':checkOutId', component: CheckOutComponent,
//    path: ':checkOutId/address', component: AddressForm
  }
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ProcessBarComponent,
    CheckOutComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true }
    )
  ],
  providers: [
    ProcessService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
