package aula_06.application;

import aula_06.model.dao.DaoFactory;
import aula_06.model.dao.SellerDao;
import aula_06.model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(3);
		
		System.out.println("=== TEST 1: seller findById ===");
		System.out.println(seller);
		
	}

}
