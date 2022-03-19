package pro.sky.java.course2.homework9.services;

import pro.sky.java.course2.homework9.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface SalaryService {
    Employee findMaxSalaryPersonInDepartment(int departmentId);

    Employee findMinSalaryPersonInDepartment(int departmentId);

    Collection<Employee> listOfEmployeesInDepartment(int departmentId);

    Map<Integer, List<Employee>> listOfAllEmployeesInDepartment();

}
