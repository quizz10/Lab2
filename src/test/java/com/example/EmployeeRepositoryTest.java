package com.example;

import java.util.List;

public class EmployeeRepositoryTest implements EmployeeRepository {
    @Override
    public List<Employee> findAll() {
        Employee emp1 = new Employee("Test1", 5000.0);
        Employee emp2 = new Employee("Test2", 6000.0);
        Employee emp3 = new Employee("Test3", 7000.0);
        return List.of(emp1,emp2, emp3);
    }

    @Override
    public Employee save(Employee e) {
        return null;
    }
}
