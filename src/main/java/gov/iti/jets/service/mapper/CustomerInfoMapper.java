package gov.iti.jets.service.mapper;

import gov.iti.jets.service.dto.CustomerInfoDto;
import gov.iti.jets.persistence.entity.Customer;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.stream.Collectors.toCollection;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel ="cdi")
public interface CustomerInfoMapper {
    Customer toEntity(CustomerInfoDto customerInfoDto);

    CustomerInfoDto toDto(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer partialUpdate(CustomerInfoDto customerInfoDto, @MappingTarget Customer customer);

    default ArrayList<CustomerInfoDto> toDTOs(Collection<Customer> customers) {
        return customers.stream().map(entity -> toDto(entity)).collect(toCollection(ArrayList<CustomerInfoDto>::new));
    }

    default ArrayList<Customer> toEntities(Collection<CustomerInfoDto> customerInfoDtoS) {
        return customerInfoDtoS.stream().map(dto -> toEntity(dto)).collect(toCollection(ArrayList<Customer>::new));
    }
}