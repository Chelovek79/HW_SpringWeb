package ru.skypro.homework.springweb.service;

import ru.skypro.homework.springweb.employee.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployeeHaveSalaryHigher(int salary);

    void createNewEmployees(List<Employee> employees);

    void changeEmployeeById(int id, Employee employee);

    void deletingEmployeeById(int id);

}