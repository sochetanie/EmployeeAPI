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
      return repository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
      return repository.save(employee);
    }

    public Optional<Employee> getEmployeeById(long id) {
      return repository.findById(id);
    }

  public boolean delete(Long id){
    if (repository.findById(id).isPresent()) {
      repository.deleteById(id);
      return true;
    }
    return false;
  }

  public Optional<Employee> update(Long id, Employee newEmployee) {
    Optional<Employee> employee = repository.findById(id);
    if(employee.isPresent()){
      Employee emp = employee.get();
      if(newEmployee.getName() != null){
        emp.setName(newEmployee.getName());
      }
      if(newEmployee.getAddress() != null){
        emp.setAddress(newEmployee.getAddress());
      }
      if(newEmployee.getPhoneNumber() != null){
        emp.setPhoneNumber(newEmployee.getPhoneNumber());
      }
      if(newEmployee.getJobTitle() != null){
        emp.setJobTitle(newEmployee.getJobTitle());
      }
      if(newEmployee.getHireDate() != null){
        emp.setHireDate(newEmployee.getHireDate());
      }
      repository.save(emp);
      return Optional.of(emp);
    }
    return Optional.empty();
  }

}
