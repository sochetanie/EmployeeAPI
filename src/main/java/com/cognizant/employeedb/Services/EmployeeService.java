package com.galvanize.employeedb.Services;

import com.galvanize.employeedb.Entities.Employee;
import com.galvanize.employeedb.Repositories.EmployeeRepository;
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

  public Optional<Employee> update(Long id, Employee employee){
    Optional<Employee> empOptional = repository.findById(id);
    if (empOptional.isPresent()) {
      Employee emp = empOptional.get();
      if (employee.getName() != null) {
        emp.setName(employee.getName());
      }
      if (employee.getAddress() != null) {
        emp.setAddress(employee.address());
      }
      if (employee.getCity() != null) {
        emp.setCity(employee.city());
      }
      if (employee.getState() != null) {
        emp.setState(employee.state());
      }
      if (employee.getZip() != null) {
        emp.setZip(employee.zip());
      }
      if (employee.getPhoneNumber() != null) {
        emp.setPhoneNumber(employee.phoneNumber());
      }
      if (employee.getJobTitle() != null) {
        emp.setJobTitle(employee.jobTitle());
      }

      repository.save(emp);
      return Optional.of(emp);
    }
    return Optional.empty();
  }

}