package edu.orgname.EmpSys.Repository;

import edu.orgname.EmpSys.Entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity,Integer> {

    Iterable<EmployeeEntity> findAllByEmpName(String empName);

    Optional<EmployeeEntity> findByEmail(String email);
}
