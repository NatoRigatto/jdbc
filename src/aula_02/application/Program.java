package aula_02.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import aula_02.db.DB;

public class Program {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;

		try {

			conn = DB.getConnection();

			st = conn.prepareStatement(
					"INSERT INTO seller" 
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, "Juvenal Antena");
			st.setString(2, "juvenal@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("13/04/1951").getTime()));
			st.setDouble(4, 5000.0);
			st.setInt(5, 2);

			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! Id: " + id);
				}
			}
			else {
				System.out.println("No rows affected!");
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}

	}

}
