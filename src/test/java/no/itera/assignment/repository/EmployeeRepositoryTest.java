package no.itera.assignment.repository;

import no.itera.assignment.domain.entity.Employee;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void findByPersonId() {
        Employee employee = employeeRepository.findByPersonId(1).orElse(null);

        assertThat(employee).isNotNull();
        assertThat(employee.getPerson()).isNotNull();

        assertThat(employee.getPerson().getAge()).isEqualTo(23);
        assertThat(employee.getPerson().getName()).isEqualTo("Hasnain Frame");
    }

    @Test
    void findActive() {
        List<Employee> activeEmployees = employeeRepository.findActive();

        assertThat(activeEmployees).isNotEmpty();
        assertThat(activeEmployees).hasSize(17);
        assertThat(activeEmployees).allMatch(e -> e.getEndDate() == null);
    }
}