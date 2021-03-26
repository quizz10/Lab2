package com.example;

import com.example.integration.EmployeeRepositoryIntegration;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeManagerIT {

    @Test
    void integrationTest() {

        Employee e1 = new Employee("1", 1000.0);
        Employee e2 = new Employee("2", 1000.0);
        Employee e3 = new Employee("3", 1000.0);
        List<Employee> employees = new ArrayList<>(List.of(e1, e2, e3));
        BankService bankService = new BankServiceTest();
        EmployeeRepository employeeRepository = new EmployeeRepositoryIntegration(employees);
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);
        // TODO Act
        var actual = employeeManager.payEmployees();
        // TODO Assert
        assertThat(actual).isEqualTo(3);

    }
}
