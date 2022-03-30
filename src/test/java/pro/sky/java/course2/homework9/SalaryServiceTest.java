package pro.sky.java.course2.homework9;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.homework9.model.Employee;
import pro.sky.java.course2.homework9.services.EmployeeServiceImpl;
import pro.sky.java.course2.homework9.services.SalaryServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class SalaryServiceTest {

    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private SalaryServiceImpl salaryService;

    @Test
    public void findMaxSalaryPersonInDepartment() {
        Employee employee1 = new Employee("Иван", "Иванов", 1, 1000);
        Employee employee2 = new Employee("Сергей", "Сергеев", 3, 2000);
        Employee employee3 = new Employee("Фёдор", "Фёдоров", 3, 3000);

        List<Employee> actual = new ArrayList<>();

        actual.add(employee1);
        actual.add(employee2);
        actual.add(employee3);

        Mockito.when(employeeService.getListOfEmployees()).thenReturn(actual);
        assertEquals(employee3, salaryService.findMaxSalaryPersonInDepartment(3));
    }

    @Test
    public void findMinSalaryPersonInDepartment() {
        Employee employee1 = new Employee("Иван", "Иванов", 1, 1000);
        Employee employee2 = new Employee("Сергей", "Сергеев", 3, 2000);
        Employee employee3 = new Employee("Фёдор", "Фёдоров", 3, 3000);

        List<Employee> actual = new ArrayList<>();

        actual.add(employee1);
        actual.add(employee2);
        actual.add(employee3);

        Mockito.when(employeeService.getListOfEmployees()).thenReturn(actual);
        assertEquals(employee2, salaryService.findMinSalaryPersonInDepartment(3));
    }

    @Test
    public void listOfAllEmployeesInDepartment() {
        Employee employee1 = new Employee("Иван", "Иванов", 1, 1000);
        Employee employee2 = new Employee("Сергей", "Сергеев", 3, 2000);
        Employee employee3 = new Employee("Фёдор", "Фёдоров", 3, 3000);

        List<Employee> actual = new ArrayList<>();
        int departmentId = 3;

        actual.add(employee1);
        actual.add(employee2);
        actual.add(employee3);

        Mockito.when(employeeService.getListOfEmployees()).thenReturn(actual);
        assertEquals(employeeService.getListOfEmployees()
                .stream().filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.toList()), salaryService.listOfEmployeesInDepartment(3));
    }

    @Test
    public void whenDepartmentIdIsInvalid() {
        Employee employee1 = new Employee("Иван", "Иванов", 1, 1000);
        Employee employee2 = new Employee("Сергей", "Сергеев", 3, 2000);
        Employee employee3 = new Employee("Фёдор", "Фёдоров", 3, 3000);

        List<Employee> actual = new ArrayList<>();
        int departmentId = 3;

        actual.add(employee1);
        actual.add(employee2);
        actual.add(employee3);

        Mockito.when(employeeService.getListOfEmployees()).thenReturn(actual);
        assertEquals(employeeService.getListOfEmployees()
                .stream().filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.toList()), salaryService.listOfEmployeesInDepartment(3453));

    }
    @Test
    public void whenDepartmentIdIsAbsent() {
        Employee employee1 = new Employee("Иван", "Иванов", 1, 1000);
        Employee employee2 = new Employee("Сергей", "Сергеев", 3, 2000);
        Employee employee3 = new Employee("Фёдор", "Фёдоров", 3, 3000);

        List<Employee> actual = new ArrayList<>();
        int departmentId = 0;

        actual.add(employee1);
        actual.add(employee2);
        actual.add(employee3);

        Mockito.when(employeeService.getListOfEmployees()).thenReturn(actual);
        assertNotNull(departmentId);
        assertEquals(employeeService.getListOfEmployees()
                .stream().filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.toList()), salaryService.listOfEmployeesInDepartment(0));
    }
}


