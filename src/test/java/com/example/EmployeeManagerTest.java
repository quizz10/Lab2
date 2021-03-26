package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


//Vi behöver tester för metoden payEmployees i klassen EmployeeManager i paketet
// com.example. Klassen har 2 beroenden på interface som inte finns tillgängliga när vi kör unit
// tester. Vi behöver alltså skapa testdoubles för dessa klasser för att kunna köra tester.
// Gör minst ett test som använder en test double som du skapat själv. En test double
// klass placerar vi I test/java foldern.
// Gör minst ett test som använder mockito för att lösa problemet.
// Skriv de tester som behövs för att få 100% kodtäckning av metoden.
class EmployeeManagerTest {
    @Test
    void testPayEmployees() {
        //TODO Arrange
        BankService bankService = new BankServiceTest();
        EmployeeRepository employeeRepository = new EmployeeRepositoryTest();
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);
        // TODO Act
        var actual = employeeManager.payEmployees();
        // TODO Assert
        assertThat(3).isEqualTo(actual);

    }

    @Test void testPayEmployeesThrowsAnException() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1",1000));
        var bankService = mock(BankService.class);
        var employeeRepository = mock(EmployeeRepository.class);

        doThrow(RuntimeException.class).when(bankService).pay("1",1000);
        when(employeeRepository.findAll()).thenReturn(employeeList);
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);
        employeeManager.payEmployees();

        assertThat(employeeList.get(0).isPaid()).isFalse();
        assertThat(employeeManager.payEmployees()).isEqualTo(0);
    }

}

