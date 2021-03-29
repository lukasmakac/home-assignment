package no.itera.assignment.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@EqualsAndHashCode(of = {"name", "age"})
public class EmployeeDto {

    private String name;
    private int age;
    private String departmentName;
    private String employmentTypeName;
    private Instant startDate;
    private Instant endDate;

    @JsonIgnore
    public boolean isActive() {
        return endDate == null;
    }
}
