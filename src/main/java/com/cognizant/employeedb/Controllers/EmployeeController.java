package com.galvanize.employeedb.Controllers;

import com.galvanize.employeedb.Entities.Employee;
import com.galvanize.employeedb.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Map;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:4200")
@Api(value="Employee Management System", description="Operations pertaining to employee in Employee Management System")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

  @ApiOperation(value = "View a list of available employees", response = List.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successfully retrieved list"),
      @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
      @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
  })
  @GetMapping("/all")
    public List<Employee> all(){
        return employeeService.getAllEmployees();
    }

  @ApiOperation(value = "Add an employee")
  @PostMapping("/")
  public Employee save(@ApiParam(value = "Employee object store in database table", required = true) @Valid @RequestBody Employee employee) {
    return employeeService.saveEmployee(employee);
    }

  @ApiOperation(value = "Get an employee by Id")
  @GetMapping("/{id}")
  public Optional<Employee> getById(@PathVariable("id") Long id) {
      return employeeService.getEmployeeById(id);
  }

  @ApiOperation(value = "Update an employee")
  @PutMapping("/{id}")
  public Optional<Employee> updateEmployee(@ApiParam(value = "Employee Id to update employee object", required = true) @PathVariable(value = "id") Long id, @ApiParam(value = "Update employee object", required = true) @Valid @RequestBody Employee employeeDetails) {
    return employeeService.update(id, employeeDetails);
  }

  @ApiOperation(value = "Delete an employee")
  @DeleteMapping("/{id}")
  public boolean deleteEmployee(@ApiParam(value = "Employee Id from which employee object will delete from database table", required = true) @PathVariable(value = "id") Long id) {
    return employeeService.delete(id);
  }
}
