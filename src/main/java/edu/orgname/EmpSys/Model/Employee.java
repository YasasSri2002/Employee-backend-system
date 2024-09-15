package edu.orgname.EmpSys.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String empId;
    private String empName;
    private Integer age;
    private String email;
    private String contact;
    private Double salary;
}
