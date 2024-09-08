package aula_06.application;

import java.util.List;

import aula_06.model.dao.DaoFactory;
import aula_06.model.dao.DepartmentDao;
import aula_06.model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ===");
		Department d1 = departmentDao.findById(2);
		System.out.println(d1);
		
		System.out.println();
		
		System.out.println("=== TEST 2: department findAll ===");
		List<Department> departmentList = departmentDao.findAll();
		for(Department departments : departmentList) {
			System.out.println(departments);
		}
		
		System.out.println();
		
		System.out.println("=== TEST 3: department insert ===");
		Department d2 = new Department(null, "Food");
		departmentDao.insert(d2);
		System.out.println("Inserted! New id = " + d2.getId());
		
		System.out.println();
		
		System.out.println("=== TEST 4: department update ===");
		Department d3 = departmentDao.findById(6);
		d3.setName("Sport");
		departmentDao.update(d3);
		System.out.println("Updated completed!");
		
	}

}
