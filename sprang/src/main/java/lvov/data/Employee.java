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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 *
 * @author serg
 */
@Entity(name="Employee")
@Table(name="Employee", schema="dbo")
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int EmployeeID;
	private String FirstName;
	private String LastName;
	private String MiddleName;
	@ManyToOne
	@JoinColumn(name="PositionID")
	private Position Position;
	@ManyToOne
	@JoinColumn(name="DepartmentID")
	private Department Department;

	/**
	 * @return the FirstName
	 */
	public String getFirstName() {
		return FirstName;
	}

	/**
	 * @param FirstName the FirstName to set
	 */
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	/**
	 * @return the LastName
	 */
	public String getLastName() {
		return LastName;
	}

	/**
	 * @param LastName the LastName to set
	 */
	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	/**
	 * @return the MiddleName
	 */
	public String getMiddleName() {
		return MiddleName;
	}

	/**
	 * @param MiddleName the MiddleName to set
	 */
	public void setMiddleName(String MiddleName) {
		this.MiddleName = MiddleName;
	}
}
