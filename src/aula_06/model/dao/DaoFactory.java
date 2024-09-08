package aula_06.model.dao;

import aula_06.db.DB;
import aula_06.model.dao.impl.DepartmentDaoJDBC;
import aula_06.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}

}
