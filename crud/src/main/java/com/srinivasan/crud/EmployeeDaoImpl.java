package com.srinivasan.crud;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Employee emp){
        String sql = "INSERT INTO employees(id,name,dept) VALUES(?,?,?)";
        jdbcTemplate.update(sql, emp.getId(), emp.getName(), emp.getDept());
        System.out.println("Employee Inserted");
    }

    @Override
    public Employee getById(int id) {
        String sql = "SELECT * FROM employees WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee e = new Employee();   // ✅ Create new Employee
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setDept(rs.getString("dept"));
                return e;
            }
        }, id);
    }

    @Override
    public List<Employee> getAll() {
        String sql = "SELECT * FROM employees";  // ✅ Correct variable
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Employee e = new Employee();
            e.setId(rs.getInt("id"));
            e.setName(rs.getString("name"));
            e.setDept(rs.getString("dept"));
            return e;
        });
    }

    @Override
    public void update(Employee emp){
        String sql = "UPDATE employees SET name=?, dept=? WHERE id=?";
        jdbcTemplate.update(sql, emp.getName(), emp.getDept(), emp.getId());
        System.out.println("Employee Updated");
    }

    @Override
    public void delete(int id){
        String sql = "DELETE FROM employees WHERE id=?";
        jdbcTemplate.update(sql, id);
        System.out.println("Employee Deleted");
    }
}
