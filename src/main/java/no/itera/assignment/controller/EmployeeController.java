package no.itera.assignment.controller;

import no.itera.assignment.domain.dto.EmployeeDto;
import no.itera.assignment.domain.entity.Employee;
import no.itera.assignment.mapper.Mapper;
import no.itera.assignment.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final Mapper mapper;
    private final EmployeeRepository employeeRepository;

    public EmployeeController(Mapper mapper, EmployeeRepository employeeRepository) {
        this.mapper = mapper;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{personId}")
    public EmployeeDto fetchEmployeeByPersonId(@PathVariable Integer personId) {
        return mapper.map(employeeRepository.findByPersonId(personId).orElse(null), EmployeeDto.class);
    }

    @GetMapping("/active")
    public List<EmployeeDto> fetchAllActiveEmployees() {
        return mapper.mapList(employeeRepository.findActive(), EmployeeDto.class);
    }

    @GetMapping("/active/by-department")
    public Map<String, List<EmployeeDto>> fetchActiveEmployeesByDepartment() {
        List<Employee> activeEmployees = employeeRepository.findActive();

        return activeEmployees.stream().collect(
                Collectors.toMap(
                        e -> e.getDepartment().getName(),               // key property for the map
                        e -> {                                          // value -> list with single entry
                            List<EmployeeDto> dtoList = new ArrayList<>();
                            dtoList.add(mapper.map(e, EmployeeDto.class));
                            return dtoList;
                        }, (a, b) -> {                                  // merge function - combine two array lists
                            a.addAll(b);
                            return a;
                        })
        );
    }

}
