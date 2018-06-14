import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import {Component} from '@angular/core'

@Injectable({
  providedIn: 'root'
})
@Injectable()
export class Employee{
  public FirstName:string;
  public LastName:string;
  constructor(first:string, last:string){
    this.FirstName = first;
    this.LastName = last;
  }
}
@Injectable()
export class EmpService {

  private http:HttpClient
  constructor(http: HttpClient) { 
    this.http = http;
  }
  getEmps(): Employee[]{
    var list;
    this.http.get<Employee[]>('/getEmps').subscribe(data =>{
      console.log('get emps:' + data);
      list = data;
    });
    return list;
  }
}
