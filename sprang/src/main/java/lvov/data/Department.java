/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lvov.data;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author serg
 */
@Entity
@Table(name="Departments", schema="dbo")
public class Department implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int DepartmentID;
	private String Name;

	/**
	 * @return the DepartmentID
	 */
	public int getDepartmentID() {
		return DepartmentID;
	}

	/**
	 * @param DepartmentID the DepartmentID to set
	 */
	public void setDepartmentID(int DepartmentID) {
		this.DepartmentID = DepartmentID;
	}

	/**
	 * @return the Name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param Name the Name to set
	 */
	public void setName(String Name) {
		this.Name = Name;
	}
	
}
