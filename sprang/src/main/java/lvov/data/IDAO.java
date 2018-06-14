/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lvov.data;

import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author serg
 */
@Repository
public interface IDAO<T extends Serializable> {
	public List<T> getAll();
	public void insert(T entity);
	public T find(int id);
	public void delete(T entity);
	
}
