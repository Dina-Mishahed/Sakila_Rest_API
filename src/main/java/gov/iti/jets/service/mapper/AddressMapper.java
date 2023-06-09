package gov.iti.jets.service.mapper;

import gov.iti.jets.service.dto.AddressDto;
import gov.iti.jets.persistence.entity.Address;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel ="cdi")
public interface AddressMapper {
    Address toEntity(AddressDto addressDto);

    AddressDto toDto(Address address);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Address partialUpdate(AddressDto addressDto, @MappingTarget Address address);
}