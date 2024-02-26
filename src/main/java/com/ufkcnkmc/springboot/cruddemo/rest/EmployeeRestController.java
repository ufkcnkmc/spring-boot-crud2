package com.ufkcnkmc.springboot.cruddemo.rest;

import com.ufkcnkmc.springboot.cruddemo.entity.Employee;
import com.ufkcnkmc.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // BURASI SERVİCE KATMANI YOKKEN KULLANDIĞIMIZ ŞEKİL

    /*private EmployeeDAO employeeDAO;

    public EmployeeRestController(EmployeeDAO theEmployeeDAO){
        employeeDAO=theEmployeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> findall(){
        return employeeDAO.findall();
    }*/

    private EmployeeService employeeService;

    public EmployeeRestController (EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee>findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee==null){

            throw new RuntimeException("Calisan bulunamadi"+employeeId);

        }
        return theEmployee;

    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);

        if(tempEmployee==null){

            throw new RuntimeException("Calisanin id'si bulunamadi"+employeeId);

        }
        employeeService.deleteById(employeeId);

        return "Calisan silindi id'si:" +employeeId;

    }




}
