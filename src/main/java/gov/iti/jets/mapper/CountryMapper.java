package gov.iti.jets.mapper;

import gov.iti.jets.dto.ActorDto;
import gov.iti.jets.dto.CountryDto;
import gov.iti.jets.persistence.entity.Actor;
import gov.iti.jets.persistence.entity.Country;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.stream.Collectors.toCollection;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel ="cdi")
public interface CountryMapper {
    Country toEntity(CountryDto countryDto);

    CountryDto toDto(Country country);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Country partialUpdate(CountryDto countryDto, @MappingTarget Country country);

    default ArrayList<CountryDto> toDTOs(Collection<Country> countries) {
        return countries.stream().map(entity -> toDto(entity)).collect(toCollection(ArrayList<CountryDto>::new));
    }

    default ArrayList<Country> toEntities(Collection<CountryDto> countryDtoS) {
        return countryDtoS.stream().map(dto -> toEntity(dto)).collect(toCollection(ArrayList<Country>::new));
    }
}