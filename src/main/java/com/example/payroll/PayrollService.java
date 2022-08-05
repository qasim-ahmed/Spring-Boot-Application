package com.example.payroll;

import com.example.payroll.model.Employees;
import helper.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.payroll.repository.EmployeeRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/rest")
public class PayrollService {
    Helper helper = new Helper();
    @Autowired
    EmployeeRepository employeeRepository;
    @RequestMapping("/all")
    public List<Employees> getAllUsers() {
        return employeeRepository.findAll();
    }

    @RequestMapping("/find-by-id")
    public List<Employees> getSingleRecord(@RequestParam(required = true) Integer id) {
        List<Employees> employees =  employeeRepository.findAll();
        return helper.getEmployeeById(id, employees);
    }

    @PostMapping("/add-employee")
    public List<Employees> addNewEmployee(@RequestBody Employees employee) {
        employeeRepository.save(employee);
        return getAllUsers();
    }

    @PostMapping("/update-employee")
    public List<Employees> updateEmployee(@RequestBody Employees employee) {
        AtomicReference<Boolean> updated = new AtomicReference<>(false);
        employeeRepository
                .findById(employee.getId())
                .ifPresent(user -> {
                    user.setName(employee.getName());
                    user.setRole(employee.getRole());
                    employeeRepository.save(user);
                    updated.set(true);
                });
        if (updated.get()) {
            return getAllUsers();
        }
        return helper.printErrorMessage(employee.getId());
    }
}
