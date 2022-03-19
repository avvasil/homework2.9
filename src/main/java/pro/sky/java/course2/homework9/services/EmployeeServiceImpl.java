package pro.sky.java.course2.homework9.services;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.homework9.model.Employee;
import pro.sky.java.course2.homework9.exceptions.EmployeeAlreadyExistsException;
import pro.sky.java.course2.homework9.exceptions.EmployeeNotFoundException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employeesMap = new HashMap<>();

    @Override
    public Collection<Employee> getListOfEmployees() {
        Collection<Employee> employeeList;
        employeeList = employeesMap.values();
        return employeeList;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int departmentId, int salary) {
        Employee addingEmployee = new Employee(firstName, lastName, departmentId, salary);
        String key = firstName + lastName;
        if (employeesMap.containsKey(key)) {
            throw new EmployeeAlreadyExistsException("Этот работник уже добавлен");
        }
        employeesMap.put(key, addingEmployee);
        return addingEmployee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, int departmentId, int salary) {
        String key = firstName + lastName;
        if (!employeesMap.containsKey(key)) {
            throw new EmployeeNotFoundException("Сотрудник не найден.");
        }
        return employeesMap.remove(key);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, int departmentId, int salary) {
        String key = firstName + lastName;
        if (!employeesMap.containsKey(key)) {
            throw new EmployeeNotFoundException("Сотрудник не найден.");
        }
        return employeesMap.get(key);
    }
}