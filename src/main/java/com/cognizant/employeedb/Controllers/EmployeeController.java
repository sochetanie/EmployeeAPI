package com.galvanize.employeedb.Controllers;

import com.galvanize.employeedb.Entities.Employee;
import com.galvanize.employeedb.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public Iterable<Employee> all(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/")
    public Employee save(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public Optional<Employee> getById(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Optional<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee newEmployee) {
      return employeeService.update(id, newEmployee);
    }

    @DeleteMapping("/{id}")
    public boolean deleteEmployee(@PathVariable Long id){
      return employeeService.delete(id);
    }
}
