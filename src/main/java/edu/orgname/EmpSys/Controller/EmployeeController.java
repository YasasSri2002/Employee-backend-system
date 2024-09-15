package edu.orgname.EmpSys.Controller;


import edu.orgname.EmpSys.Model.Employee;
import edu.orgname.EmpSys.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;


    @PostMapping()
    public Employee persist(@RequestBody Employee employee){
         return employeeService.save(employee);
    }

    @GetMapping("/all")
    public List<Employee> retrieveAll(){
        return employeeService.retrieveAll();
    }

    @PutMapping("/update")
    public Employee update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

    @GetMapping("/by-name/{empName}")
    public List<Employee> retrieveAllByName(@PathVariable String empName){
        return employeeService.getAllByName(empName);
    }

    @DeleteMapping("/by-id")
    public Map<String, String> deleteById(@RequestParam Integer empId){

        return Collections.singletonMap("DELETE",employeeService.deleteById(empId));

    }



}
