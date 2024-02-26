package com.ufkcnkmc.springboot.cruddemo.dao;

import com.ufkcnkmc.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findall();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
