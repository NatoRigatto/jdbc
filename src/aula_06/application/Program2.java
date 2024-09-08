package aula_06.application;

import java.util.List;

import aula_06.model.dao.DaoFactory;
import aula_06.model.dao.DepartmentDao;
import aula_06.model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ===");
		Department d = departmentDao.findById(2);
		System.out.println(d);
		
		System.out.println();
		
		System.out.println("=== TEST 2: department findAll ===");
		List<Department> departmentList = departmentDao.findAll();
		for(Department departments : departmentList) {
			System.out.println(departments);
		}
		
	}

}
