package no.itera.assignment.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
public class Person {
    @Id
    private int id;

    @Column
    private String name;

    @Column
    private Integer age;
}
