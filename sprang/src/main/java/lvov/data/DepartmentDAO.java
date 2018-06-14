/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lvov.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author serg
 */
@Component
public class DepartmentDAO implements IDAO<Department> {

	private EntityManagerFactory emf;
	private EntityManager entitymanager;
	
	public void setEmf(EntityManagerFactory emf){
		this.emf = emf;
		entitymanager = emf.createEntityManager();
	}
	
	@Override
	public List<Department> getAll() {
		List<Department> res = this.entitymanager.createQuery("select d from Department d").getResultList();
		return res;
	}

	@Override
	public void insert(Department entity) {
		entitymanager.getTransaction().begin();
		entitymanager.persist(entity);
		entitymanager.flush();
		entitymanager.getTransaction().commit();
	}

	@Override
	public Department find(int id) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void delete(Department entity) {
		entitymanager.getTransaction().begin();
		entitymanager.remove(entity);
		entitymanager.getTransaction().commit();
	}
	
}
