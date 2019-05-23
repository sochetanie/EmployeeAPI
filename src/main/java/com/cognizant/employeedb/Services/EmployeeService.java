package com.cognizant.employeedb.Services;

import com.cognizant.employeedb.Entities.Employee;
import com.cognizant.employeedb.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Iterable<Employee> getAllEmployees() {
      return this.repository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
      return this.repository.save(employee);
    }

    public Optional<Employee> getEmployeeById(long id) {
      return this.repository.findById(id);
    }

  public boolean delete(Long id){
    if (repository.findById(id).isPresent()) {
      repository.deleteById(id);
      return true;
    }
    return false;
  }

  public Optional<Employee> update(Long id, Employee newEmployee) {
    return repository.findById(id)
        .map(employee -> {
          employee.setName(newEmployee.getName());
          employee.setAddress(newEmployee.getAddress());
          employee.setPhoneNumber(newEmployee.getPhoneNumber());
          employee.setJobTitle(newEmployee.getJobTitle());
          employee.setHireDate(newEmployee.getHireDate());
          return repository.save(employee);
        });
  }

}