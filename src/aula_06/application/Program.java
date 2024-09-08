package aula_06.application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import aula_06.model.dao.DaoFactory;
import aula_06.model.dao.SellerDao;
import aula_06.model.entities.Department;
import aula_06.model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

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
		
		System.out.println();
		
		System.out.println("=== TEST 4: seller insert ===");
		
		Seller newSeller = new Seller(null, "Blim Blau", "blimblau@gmail.com", new Date(), 4000.0, d);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println();
		
		System.out.println("=== TEST 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Xablau");
		seller.setEmail("xablau@gmail.com");
		sellerDao.update(seller);
		System.out.println("Updated completed!");
		
		System.out.println();
		
		System.out.println("=== TEST 5: seller update ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Deleted completed!");
		
		sc.close();
		
	}

}
