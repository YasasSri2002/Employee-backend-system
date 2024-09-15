package edu.orgname.EmpSys.Repository;

import edu.orgname.EmpSys.Entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity,Integer> {

    Iterable<EmployeeEntity> findAllByEmpName(String empName);


}
