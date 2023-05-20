package ru.skypro.homework.springweb.repository;

import ru.skypro.homework.springweb.employee.Employee;

import java.util.List;

public interface EmployeeRepository {

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployeeHaveSalaryHigher(int salary);

    void createNewEmployees(List<Employee> employees);

    void changeEmployeeById(int id, Employee employee);

    void deletingEmployeeById(int id);

}
