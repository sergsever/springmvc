/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lvov.data;

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
@Table(name="Positions", schema="dbo")
public class Position {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int PositionID;
	private String Name;

	/**
	 * @return the PositionID
	 */
	public int getPositionID() {
		return PositionID;
	}

	/**
	 * @param PositionID the PositionID to set
	 */
	public void setPositionID(int PositionID) {
		this.PositionID = PositionID;
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
