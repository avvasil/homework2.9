package pro.sky.java.course2.homework9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.homework9.exceptions.EmployeeAlreadyExistsException;
import pro.sky.java.course2.homework9.exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.homework9.model.Employee;
import pro.sky.java.course2.homework9.services.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class EmployeeServiceTest {

    private Employee employee1;
    private Employee employee2;
    private Employee employee3;
    private EmployeeServiceImpl employees;

    @BeforeEach
    public void setUp() {

        employee1 = new Employee("Иван", "Иванов", 1, 1000);
        employee2 = new Employee("Сергей", "Сергеев", 2, 2000);
        employee3 = new Employee("Фёдор", "Фёдоров", 3, 3000);

        employees = new EmployeeServiceImpl();

    }

    @Test
    public void getAllEmployees() {


        employees.addEmployee("Иван", "Иванов", 1, 1000);
        employees.addEmployee("Сергей", "Сергеев", 2, 2000);
        employees.addEmployee("Фёдор", "Фёдоров", 3, 3000);

        Collection<Employee> expected = employees.getListOfEmployees();

        Collection<Employee> actual = new ArrayList<>();

        actual.add(employee1);
        actual.add(employee2);
        actual.add(employee3);

        assertEquals(actual, expected);

    }

    @Test
    public void addEmployeeWorkFine() {

        assertEquals(employee1, employees.addEmployee("Иван", "Иванов", 1, 1000));

    }

    @Test
    public void addEmployeeFailed() {

        assertEquals(employee2, employees.addEmployee("Иван", "Иванов", 1, 1000));

    }

    @Test
    public void shouldReturnEmployeeAlreadyExistsExceptionWhenAdding() {

        employees.addEmployee("Иван", "Иванов", 1, 1000);

        assertThrows(EmployeeAlreadyExistsException.class, () -> employees.addEmployee("Иван", "Иванов", 1, 1000));
    }


    @Test
    public void removeEmployeeWorkFine() {

        employees.addEmployee("Иван", "Иванов", 1, 1000);

        assertEquals(employee1, employees.removeEmployee("Иван", "Иванов", 1, 1000));

    }

    @Test
    public void removeEmployeeFailed() {

        employees.addEmployee("Иван", "Иванов", 1, 1000);

        assertEquals(employee3, employees.removeEmployee("Иван", "Иванов", 1, 2000));

    }

    @Test
    public void shouldReturnEmployeeNotFoundExceptionWhenRemoving() {

        employees.addEmployee("Иван", "Иванов", 1, 1000);

        assertThrows(EmployeeNotFoundException.class, () -> employees.removeEmployee("Сергей", "Сергеев", 2, 2000));
    }


    @Test
    public void findEmployeeWorkFine() {

        employees.addEmployee("Иван", "Иванов", 1, 1000);

        assertEquals(employee1, employees.findEmployee("Иван", "Иванов", 1, 1000));

    }

    @Test
    public void findEmployeeFailed() {

        employees.addEmployee("Иван", "Иванов", 1, 1000);

        assertEquals(employee2, employees.findEmployee("Иван", "Иванов", 1, 2000));

    }

    @Test
    public void shouldReturnEmployeeNotFoundExceptionWhenFinding() {

        employees.addEmployee("Иван", "Иванов", 1, 1000);

        assertThrows(EmployeeNotFoundException.class, () -> employees.removeEmployee("Сергей", "Сергеев", 2, 2000));
    }
}
