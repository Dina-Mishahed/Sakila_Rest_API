package gov.iti.jets.service.mapper;

import gov.iti.jets.service.dto.RentalDto;
import gov.iti.jets.persistence.entity.Rental;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.stream.Collectors.toCollection;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel ="cdi")
public interface RentalMapper {
    Rental toEntity(RentalDto rentalDto);

    RentalDto toDto(Rental rental);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Rental partialUpdate(RentalDto rentalDto, @MappingTarget Rental rental);

    default ArrayList<RentalDto> toDTOs(Collection<Rental> Rentals) {
        return Rentals.stream().map(entity -> toDto(entity)).collect(toCollection(ArrayList<RentalDto>::new));
    }

    default ArrayList<Rental> toEntities(Collection<RentalDto> rentalDtoS) {
        return rentalDtoS.stream().map(dto -> toEntity(dto)).collect(toCollection(ArrayList<Rental>::new));
    }
}