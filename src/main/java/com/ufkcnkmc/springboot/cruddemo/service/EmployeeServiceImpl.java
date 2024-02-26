package com.ufkcnkmc.springboot.cruddemo.service;

import com.ufkcnkmc.springboot.cruddemo.dao.EmployeeDAO;
import com.ufkcnkmc.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService{


    private EmployeeDAO employeeDAO;


    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO=theEmployeeDAO;
    }//BURASI CONSTRUCTOR ENJEKSİYON KISMI TAM ANLAMADIM AMA ÖĞRENİCEM



    @Override
    public List<Employee> findAll() {
        return employeeDAO.findall();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);

    }
}
