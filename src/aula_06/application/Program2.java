package aula_06.application;

import aula_06.model.dao.DaoFactory;
import aula_06.model.dao.DepartmentDao;
import aula_06.model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Department d = departmentDao.findById(2);
		System.out.println(d);
		
	}

}
