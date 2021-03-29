package no.itera.assignment.mapper;

import no.itera.assignment.config.MapperConfiguration;
import no.itera.assignment.domain.dto.EmployeeDto;
import no.itera.assignment.domain.entity.Department;
import no.itera.assignment.domain.entity.Employee;
import no.itera.assignment.domain.entity.EmploymentType;
import no.itera.assignment.domain.entity.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@ContextConfiguration(classes = MapperConfiguration.class)
class MapperTest {

    @Autowired
    private Mapper mapper;

    @Test
    void validate() {
        mapper.validate();
    }

    @DisplayName("When mapping employee, should set every property to DTO")
    @Test
    void testMapping() {
        Department department = new Department();

        department.setId(1);
        department.setName("Development");

        Person person = new Person();
        person.setId(1);
        person.setName("Lukas Maruniak");
        person.setAge(33);

        EmploymentType employmentType = new EmploymentType();
        employmentType.setId(1);
        employmentType.setName("Full-remote");

        Employee employee = new Employee();
        employee.setId(1);
        Instant startDate = LocalDate.of(2021, Month.APRIL, 10).atStartOfDay().toInstant(ZoneOffset.ofHours(2));
        employee.setStartDate(startDate);
        employee.setEndDate(null);
        employee.setPerson(person);
        employee.setDepartment(department);
        employee.setEmploymentType(employmentType);

        // execute
        EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);

        // verify
        assertEquals("Lukas Maruniak", employeeDto.getName());
        assertEquals(33, employeeDto.getAge());
        assertEquals("Development", employeeDto.getDepartmentName());
        assertEquals("Full-remote", employeeDto.getEmploymentTypeName());
        assertEquals(startDate, employeeDto.getStartDate());
        assertNull(employeeDto.getEndDate());
    }

}