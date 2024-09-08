package aula_06.model.dao;

import java.util.List;

import aula_06.model.entities.Department;

public interface DepartmentDao {

	void insert(Department d);

	void update(Department d);

	void deleteById(Integer id);

	Department findById(Integer id);

	List<Department> findAll();

}
