package no.itera.assignment.mapper;

import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

public class Mapper extends ModelMapper {

    @PostConstruct
    protected void configure() {
        addMappings(new EmployeePropertyMap());
    }

    /**
     * Maps List of source objects
     * @param source List of objects to be mapped
     * @param targetClass Target class
     * @return List of mapped objects
     */
    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> this.map(element, targetClass))
                .collect(Collectors.toList());
    }

}
