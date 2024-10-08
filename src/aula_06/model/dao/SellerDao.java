package aula_06.model.dao;

import java.util.List;

import aula_06.model.entities.Department;
import aula_06.model.entities.Seller;

public interface SellerDao {
	
	void insert(Seller s);

	void update(Seller s);

	void deleteById(Integer id);

	Seller findById(Integer id);
	
	List<Seller> findByDepartment(Department d);

	List<Seller> findAll();

}
