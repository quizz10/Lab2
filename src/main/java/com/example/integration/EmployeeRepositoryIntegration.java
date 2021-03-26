package com.example.integration;

import com.example.Employee;
import com.example.EmployeeRepository;

import java.util.List;
import java.util.ListIterator;

public class EmployeeRepositoryIntegration implements EmployeeRepository {

    public List<Employee> employees;
    public EmployeeRepositoryIntegration(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public List<Employee> findAll() {

        return employees;
    }

    @Override
    public Employee save(Employee e) {
        ListIterator<Employee> listIterator = employees.listIterator();

        while (listIterator.hasNext()) {
            if (listIterator.next().getId().equals(e.getId())) {
                listIterator.set(e);
                return e;
            }
        }
        employees.add(e);
        return e;
    }
}
