package com.ufkcnkmc.springboot.cruddemo.dao;

import com.ufkcnkmc.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;


    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }


    @Override
    public List<Employee> findall() {

        //ilk önce sorgu olulturuyoruz
        TypedQuery<Employee> theQuery= entityManager.createQuery("from Employee ", Employee.class);

        //sorguyu uyguklayıp getResultu getir

        List<Employee> employees= theQuery.getResultList();

        //en son olarak da employeesleri döndürüyotuz

        return employees;
    }

    @Override
    public Employee findById(int theId) {

        //çalışanları getir
        Employee theEmployee=entityManager.find(Employee.class,theId);

        //çalışanları döndür
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        Employee dbEmployee=entityManager.merge(theEmployee);

        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {

        Employee theEmployee = entityManager.find(Employee.class,theId);

        entityManager.remove(theEmployee);

    }
}
