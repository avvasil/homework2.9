package pro.sky.java.course2.homework9.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.homework9.model.Employee;
import pro.sky.java.course2.homework9.services.SalaryService;
import pro.sky.java.course2.homework9.services.SalaryServiceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("departments")

public class SalaryController {
    private final SalaryService salaryService;

    public SalaryController(SalaryServiceImpl salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping("/max-salary")
    public Employee findMaxSalaryPersonInDepartment(@RequestParam int departmentId) {
        return salaryService.findMaxSalaryPersonInDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee findMinSalaryPersonInDepartment(@RequestParam int departmentId) {
        return salaryService.findMinSalaryPersonInDepartment(departmentId);
    }

    @GetMapping(path = "/all", params = {"departmentId"})
    public Collection<Employee> listOfEmployeesInDepartment(@RequestParam int departmentId) {
        return salaryService.listOfEmployeesInDepartment(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> listOfAllEmployeesInDepartment() {
        return salaryService.listOfAllEmployeesInDepartment();
    }
}
