package no.itera.assignment.repository;

import no.itera.assignment.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.person.id = :personId")
    Optional<Employee> findByPersonId(@Param("personId") Integer personId);

    @Query("SELECT e FROM Employee e WHERE e.endDate is null")
    List<Employee> findActive();
}
