package pro.sky.java.course2.homework9.controllers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.homework9.exceptions.EmployeeAlreadyExistsException;
import pro.sky.java.course2.homework9.model.Employee;
import pro.sky.java.course2.homework9.services.EmployeeServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping(path = "/list")
    public Collection<Employee> getListOfEmployees() {
        return employeeServiceImpl.getListOfEmployees();
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("departmentId") int departmentId,
                                @RequestParam("salary") int salary) {
        if (StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName)) { //I'm not sure, that checking here is correct. Maybe it should be done in EmployeeServiceImpl?
            Employee employee = new Employee(StringUtils.capitalize(firstName),
                                             StringUtils.capitalize(lastName), departmentId, salary);
            employeeServiceImpl.addEmployee(firstName, lastName, departmentId, salary);
            return employee;
        } else
            throw new EmployeeAlreadyExistsException("Некорректное имя пользователя.");
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("departmentId") int departmentId,
                                   @RequestParam("salary") int salary) {
        if (StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName)) {
            Employee removedEmployee = new Employee(firstName, lastName, departmentId, salary);
            employeeServiceImpl.removeEmployee(firstName, lastName, departmentId, salary);
            return removedEmployee;
        } else
            throw new EmployeeAlreadyExistsException("Некорректное имя пользователя.");
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("departmentId") int departmentId,
                                 @RequestParam("salary") int salary) {
        if (StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName)) {
            Employee foundEmployee = new Employee(firstName, lastName, departmentId, salary);
            employeeServiceImpl.findEmployee(firstName, lastName, departmentId, salary);
            return foundEmployee;
        } else
            throw new EmployeeAlreadyExistsException("Некорректное имя пользователя.");
    }
}

