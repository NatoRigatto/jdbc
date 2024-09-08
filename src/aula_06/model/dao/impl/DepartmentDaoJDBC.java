package aula_06.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aula_06.db.DB;
import aula_06.db.DbException;
import aula_06.model.dao.DepartmentDao;
import aula_06.model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {
	
	Connection conn = null;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department d) {
		
	}

	@Override
	public void update(Department d) {
		
	}

	@Override
	public void deleteById(Integer id) {
		
	}

	@Override
	public Department findById(Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * FROM department WHERE Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				Department d = instantiateDepartment(rs);
				return d;
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
		return null;
	}

	@Override
	public List<Department> findAll() {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
		
			st = conn.prepareStatement("SELECT * FROM department");
			rs = st.executeQuery();
			
			List<Department> departmentList = new ArrayList<>();
			
			while(rs.next()) {
				
				Department d = instantiateDepartment(rs);
				departmentList.add(d);
				
			}
			
			return departmentList;
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		
	}
	
	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department d = new Department();
		d.setId(rs.getInt("Id"));
		d.setName(rs.getString("Name"));
		return d;
	}

}
