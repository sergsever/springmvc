/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lvov.data;

import java.util.List;

/**
 *
 * @author serg
 */
public interface IEmployeeService {
	List<Employee> getAllEmployee();
	Employee findEmployee(int id);
	void insertEmployee(Employee entity);
	void deleteEmployee(Employee entity);
	
}
