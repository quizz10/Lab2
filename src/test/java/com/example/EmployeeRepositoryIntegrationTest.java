package com.example;

import com.example.integration.EmployeeRepositoryIntegration;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class EmployeeRepositoryIntegrationTest {

    @Test
    public void testFindAll() {
        List<Employee> employees = new ArrayList<>();
        EmployeeRepositoryIntegration employeeRepo = new EmployeeRepositoryIntegration(employees);
        Employee emp1 = new Employee("1", 1300.0);
        Employee emp2 = new Employee("2", 1500.0);
        employees.addAll(asList(emp1, emp2));
        assertThat(employeeRepo.findAll()).containsExactly(emp1, emp2);
    }

    @Test
    void testSave() {
        List<Employee> employees = new ArrayList<>();
        EmployeeRepositoryIntegration employeeRepo = new EmployeeRepositoryIntegration(employees);
        Employee savedEmployee = employeeRepo.save(new Employee("1", 500.0));
        assertThat(employees).containsExactly(savedEmployee);
    }

    @Test void testSaveWhenEmployeeAlreadyExists() {
        Employee emp1 = new Employee("1", 5000.0);
        Employee emp2 = new Employee("2", 6000.0);
        List<Employee> employees = new ArrayList<>(asList(emp1, emp2));
        EmployeeRepositoryIntegration employeeRepo = new EmployeeRepositoryIntegration(employees);

        Employee overWriter = employeeRepo.save(new Employee("2",7000.0));
        assertThat(employees).containsExactly(emp1, overWriter);

    }

}