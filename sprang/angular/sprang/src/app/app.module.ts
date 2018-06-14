import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ListComponent } from './list/list.component';
import { ListRowComponent } from './list-row/list-row.component';
import { EmpService } from './emp.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    ListRowComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule//,
//    EmpService
  ],
  providers: [HttpClient, ],
  bootstrap: [AppComponent]
})
export class AppModule { }
