package ru.skypro.homework.springweb.repository;

import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.springweb.employee.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee(1, "Савченко А.А.", 55_000),
            new Employee(2, "Васильева Е.А.", 60_000),
            new Employee(3, "Антошина О.В.", 70_000),
            new Employee(4, "Тропников С.Г.", 70_000),
            new Employee(5, "Елизарова С.Н.", 80_000),
            new Employee(6, "Каратаев И.Н.", 45_000)));

    @Override
    public Employee getEmployeeById(int id) {
        haveIdOrNot(id);
        return employeeList.stream()
                .filter(x -> x.getId() == id)
                .findAny().get();
    }

    @Override
    public List<Employee> getAllEmployeeHaveSalaryHigher(int salary) {
        return employeeList.stream()
                .filter(x -> x.getSalary() > salary)
                .collect(Collectors.toList());
    }

    @Override
    public void createNewEmployees(List<Employee> employees) {
        employeeList.addAll(employees);
    }

    @Override
    public void createNewOne(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public void changeEmployeeById(int id, Employee employee) {
        haveIdOrNot(id);
        employeeList.stream()
                .filter(x -> x.getId() == id)
                .map(e -> {
                            e.setName(employee.getName());
                            e.setSalary(employee.getSalary());
                            return e;
                        }
                )
                .collect(Collectors.toList());
    }

    @Override
    public void deletingEmployeeById(int id) {
        haveIdOrNot(id);
        employeeList.removeIf(em -> em.getId() == id);
    }

    @SneakyThrows
    public void haveIdOrNot(int id) {
        if (employeeList.stream()
                .noneMatch(e -> e.getId() == id)) {
            throw new Exception("Работника с таким табельным номером не существует.");
        }
    }
}
