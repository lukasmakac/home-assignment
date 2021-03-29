package no.itera.assignment.mapper;

import no.itera.assignment.domain.dto.EmployeeDto;
import no.itera.assignment.domain.entity.Employee;
import org.modelmapper.PropertyMap;

public class EmployeePropertyMap extends PropertyMap<Employee, EmployeeDto> {
    @Override
    protected void configure() {
        map().setName(source.getPerson().getName());
        map().setAge(source.getPerson().getAge());
        map().setDepartmentName(source.getDepartment().getName());
        map().setEmploymentTypeName(source.getEmploymentType().getName());
    }
}
