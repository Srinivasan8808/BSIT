package com.srinivasan.crud;

import java.util.List;

public interface EmployeeDao {
    void insert(Employee emp);
    Employee getById(int id);
    List<Employee> getAll();
    void update(Employee emp);
    void delete(int id);
}
