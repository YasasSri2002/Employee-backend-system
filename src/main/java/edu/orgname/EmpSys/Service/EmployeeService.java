package edu.orgname.EmpSys.Service;

import edu.orgname.EmpSys.Model.Employee;

import java.util.List;

public interface EmployeeService {

     List<Employee> retrieveAll();

    Employee save(Employee employee);


    Employee update(Employee employee);

    List<Employee> getAllByName(String empName);


    String deleteById(Integer empId);


}
