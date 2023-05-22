package ru.skypro.homework.springweb.employee;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

    private Integer id;
    private String name;
    private int salary;
    public static int numberOfId = 6;

    @JsonCreator
    public Employee(String name, int salary) {
        this.id = numberOfId + 1;
        this.name = name;
        this.salary = salary;
        ++numberOfId;
    }

    @Override
    public String toString() {
        return id + ". " + name + " Зарплата = " + salary + " руб.";
    }
}
