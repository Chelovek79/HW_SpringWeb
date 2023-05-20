package ru.skypro.homework.springweb.service;

import org.springframework.stereotype.Service;
import ru.skypro.homework.springweb.employee.Employee;
import ru.skypro.homework.springweb.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public List<Employee> getAllEmployeeHaveSalaryHigher(int salary) {
        return employeeRepository.getAllEmployeeHaveSalaryHigher(salary);
    }

    @Override
    public void createNewEmployees(List<Employee> employees) {
        employeeRepository.createNewEmployees(employees);
    }

    @Override
    public void changeEmployeeById(int id, Employee employee) {
        employeeRepository.changeEmployeeById(id, employee);
    }

    @Override
    public void deletingEmployeeById(int id) {
        employeeRepository.deletingEmployeeById(id);
    }
}
