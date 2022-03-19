package pro.sky.java.course2.homework9.services;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.homework9.model.Employee;
import pro.sky.java.course2.homework9.exceptions.EmployeeNotFoundException;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SalaryServiceImpl implements SalaryService {

    private final EmployeeService employeeService;

    public SalaryServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMaxSalaryPersonInDepartment(int departmentId) {

        return employeeService.getListOfEmployees().stream().
                filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(e -> (int) e.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findMinSalaryPersonInDepartment(int departmentId) {
        return employeeService.getListOfEmployees().stream().
                filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(e -> (int) e.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> listOfEmployeesInDepartment(int departmentId) {
        return employeeService.getListOfEmployees().stream().
                filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> listOfAllEmployeesInDepartment() {
        return employeeService.getListOfEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
