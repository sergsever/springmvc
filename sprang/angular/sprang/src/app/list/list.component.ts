import { Component, OnInit, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Employee} from '../emp.service';
import {EmpService} from '../emp.service';
import { HttpClientModule, HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
  providers: [EmpService]
})

@Injectable()
export class ListComponent implements OnInit {

  columns:string[];
  rows:Employee[];

  constructor(private service : EmpService ) { }

  ngOnInit() {
    this.columns = ["Имя", "Фамилия"];
    var service:EmpService;
    this.rows = service.getEmps();

  }

}
