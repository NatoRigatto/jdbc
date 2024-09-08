package aula_06.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import aula_04.db.DB;
import aula_05.db.DbException;
import aula_06.model.dao.SellerDao;
import aula_06.model.entities.Department;
import aula_06.model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection conn;

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement(
					"SELECT seller.*, department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.id = ?");

			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {

				Department d = new Department();
				d.setId(rs.getInt("DepartmentId"));
				d.setName(rs.getString("DepName"));

				Seller s = new Seller();
				s.setId(rs.getInt("Id"));
				s.setName(rs.getString("Name"));
				s.setEmail(rs.getString("Email"));
				s.setBaseSalary(rs.getDouble("BaseSalary"));
				s.setBirthdate(rs.getDate("BirthDate"));
				s.setDepartment(d);

				return s;

			} else {
				return null;
			}

		} catch (SQLException e) {
			
			throw new DbException(e.getMessage());
			
		} finally {

			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
