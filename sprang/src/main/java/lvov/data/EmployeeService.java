/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lvov.data;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author serg
 */@Component
public class EmployeeService implements IEmployeeService{
	@Autowired
	private IDAO<Employee> employeeDAO;
	@Autowired
	private IDAO<Department> departmentDAO;

	@Override
	public List<Employee> getAllEmployee() {
		return employeeDAO.getAll();
	}

	@Override
	public Employee findEmployee(int id) {
		return employeeDAO.find(id);
	}

	@Override
	public void insertEmployee(Employee entity) {
		employeeDAO.insert(entity);
	}

	@Override
	public void deleteEmployee(Employee entity) {
		employeeDAO.delete(entity);
	}
}
