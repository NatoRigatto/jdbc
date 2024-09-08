package aula_06.model.dao;

import aula_06.model.entities.Seller;

public interface SellerDao {
	
	void insert(Seller s);

	void update(Seller s);

	void deleteById(Integer id);

	Seller findById(Integer id);

	Seller findAll();

}
