package aula_06.application;

import java.util.List;

import aula_06.model.dao.DaoFactory;
import aula_06.model.dao.SellerDao;
import aula_06.model.entities.Department;
import aula_06.model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println();
		
		System.out.println("=== TEST 2: seller findByDepartment ===");
		Department d = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(d);
		for(Seller s : list) {
			System.out.println(s);
		}
		
		System.out.println();
		
		System.out.println("=== TEST 3: seller findAll ===");
		list = sellerDao.findAll();
		for(Seller s : list) {
			System.out.println(s);
		}
		
	}

}
