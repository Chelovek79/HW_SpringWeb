package ru.skypro.homework.springweb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.springweb.employee.Employee;
import ru.skypro.homework.springweb.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
        int idEmployee = Integer.parseInt(id);
        return employeeService.getEmployeeById(idEmployee);
    }

    @GetMapping("/salaryHigherThan")
    public List<Employee> getAllEmployeeHaveSalaryHigher(@RequestParam("salary") Integer salary) {
        return employeeService.getAllEmployeeHaveSalaryHigher(salary);
    }

    @PostMapping("/addList/")
    public void createNewEmployees(@RequestBody List<Employee> employees) {
        employeeService.createNewEmployees(employees);
    }

    @PostMapping("/addOne/")
    public void createNewOne(@RequestBody Employee employee) {
        employeeService.createNewOne(employee);
    }

    @PutMapping("/{id}")
    public void changeEmployeeById(@PathVariable String id, @RequestBody Employee employee) {
        int idEmployee = Integer.parseInt(id);
        employeeService.changeEmployeeById(idEmployee, employee);
    }

    @DeleteMapping("/{id}")
    public void deletingEmployeeById(@PathVariable String id) {
        int idEmployee = Integer.parseInt(id);
        employeeService.deletingEmployeeById(idEmployee);
    }
}
