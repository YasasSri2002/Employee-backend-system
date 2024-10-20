package edu.orgname.EmpSys.Service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.orgname.EmpSys.Entity.EmployeeEntity;
import edu.orgname.EmpSys.Model.Employee;
import edu.orgname.EmpSys.Repository.EmployeeRepository;
import edu.orgname.EmpSys.Service.EmployeeService;
import edu.orgname.EmpSys.exception.EmployeeAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;

    private final ObjectMapper mapper;


    @Override
    public List<Employee> retrieveAll() {
        Iterable<EmployeeEntity> employees = employeeRepository.findAll();

        List<Employee> employeeList= new ArrayList<>();
        employees.forEach(employeeEntity -> employeeList.add(mapper.convertValue(employeeEntity, Employee.class)));
        return employeeList;
    }

    @Override
    public Employee save(Employee employee) {
        Optional<EmployeeEntity> byEmail = employeeRepository.findByEmail(employee.getEmail());

        if(byEmail.isPresent()){
            throw new EmployeeAlreadyExistException(
                    "Employee Already Exist with the email"+employee.getEmail()){

            };
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmpName(employee.getEmpName());
        employeeEntity.setAge(employee.getAge());
        employeeEntity.setEmail(employee.getEmail());
        employeeEntity.setContact(employee.getContact());
        employeeEntity.setSalary(employee.getSalary());

        EmployeeEntity save = employeeRepository.save(mapper.convertValue(employee, EmployeeEntity.class));
        return mapper.convertValue(save,Employee.class);


    }

    @Override
    public Employee update(Integer empId , Employee employee) {
        return mapper.convertValue(
                employeeRepository.save(mapper.convertValue
                        (employee, EmployeeEntity.class)),
                Employee.class);
    }

    @Override
    public List<Employee> getAllByName(String empName) {
        Iterable<EmployeeEntity> allByEmpName = employeeRepository.findAllByEmpName(empName);

        List<Employee> employeeList= new ArrayList<>();
        allByEmpName.forEach(employeeEntity -> employeeList.add(mapper.convertValue(employeeEntity, Employee.class)));

        return employeeList;

    }

    @Override
    public String deleteById(Integer empId) {
        if(employeeRepository.existsById(empId)){
            employeeRepository.deleteById(empId);
            return "SUCCESS";
        }
        return "FAILED";

    }



}
