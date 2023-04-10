package gov.iti.jets.mapper;

import gov.iti.jets.dto.CustomerFormDto;
import gov.iti.jets.persistence.entity.Address;
import gov.iti.jets.persistence.entity.Customer;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel ="cdi")
public interface CustomerFormMapper {
    Customer toEntity(CustomerFormDto customerFormDto);

    CustomerFormDto toDto(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer partialUpdate(CustomerFormDto customerFormDto, @MappingTarget Customer customer);

    Address toAddressEntity(CustomerFormDto customerFormDto);

//    AddingCustomerDto toDto(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Address partialUpdate(CustomerFormDto customerFormDto, @MappingTarget Address address);
}