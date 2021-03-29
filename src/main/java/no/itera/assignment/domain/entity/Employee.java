package no.itera.assignment.domain.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table
@Getter
@Setter
public class Employee {

    @Id
    @Column(name="person_id")
    private int id;

    @Column
    private Instant startDate;

    @Column
    private Instant endDate;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "employment_type_id", referencedColumnName = "id")
    private EmploymentType employmentType;
}
