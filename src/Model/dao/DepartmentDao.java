package Model.dao;

import java.util.List;

import Model.entities.Department;

public interface DepartmentDao {
    void insert(Department obj);
    void update(Department obj);
    void deleById(Integer id);
    Department findBy(Integer id);
    List<Department> findAll();

}
