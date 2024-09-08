package aula_06.application;

import java.util.Date;

import aula_06.model.dao.DaoFactory;
import aula_06.model.dao.SellerDao;
import aula_06.model.entities.Department;
import aula_06.model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Department d = new Department(1, "Xablau");
		
		Seller s = new Seller(1, "Caga Tronco", "cagatronco@gmail.com", new Date(), 2000.0, d);
		System.out.println(s);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
	}

}
