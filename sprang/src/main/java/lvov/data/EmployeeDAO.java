/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lvov.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author serg
 */
@Component
//@Transactional
public class EmployeeDAO implements IDAO<Employee> {

	

	EntityManagerFactory emf;
	
	private static Logger log = Logger.getLogger("dao");
	@Autowired
	public void setEmf(EntityManagerFactory emf){
		log.info("dao:setEmf");
		this.emf = emf;
		entitymanager = emf.createEntityManager();
		
	}

	private EntityManager entitymanager;
	
	public EmployeeDAO(){
		log.info("dao:constr:");
//			this.emf = Persistence.createEntityManagerFactory("sprang");
//			this.entitymanager = emf.createEntityManager();
	}
	
	
	
	public String getState(){
		return new String("factory:" + (this.entitymanager == null));
	}	

	@Override
	public List<Employee> getAll() {
		log.info("dao:getall:");
		System.out.println("dao:getall:");
		List<Employee> res = null;
		res = entitymanager.createQuery("select e from Employee e").getResultList();
		return res;
	}

	@Override

	public void insert(Employee entity) {
		entitymanager.getTransaction().begin();
		entitymanager.persist(entity);
		entitymanager.flush();
		entitymanager.getTransaction().commit();
		
	}

	@Override
	public Employee find(int id) {
		Employee res = entitymanager.find(Employee.class, id);
		return res;
	}

	@Override
	public void delete(Employee entity) {
		log.info("EmployeeDAO:delete:");
		int id = entity.EmployeeID;
		entitymanager.clear();
		Employee emp = entitymanager.find(Employee.class, id);
		entitymanager.getTransaction().begin();
		entitymanager.remove(emp);
		entitymanager.flush();
		entitymanager.getTransaction().commit();
		
	}

}
