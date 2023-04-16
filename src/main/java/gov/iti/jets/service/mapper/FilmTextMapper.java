package gov.iti.jets.service.mapper;

import gov.iti.jets.service.dto.FilmTextDto;
import gov.iti.jets.persistence.entity.FilmText;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel ="cdi")
public interface FilmTextMapper {
    FilmText toEntity(FilmTextDto filmTextDto);

    FilmTextDto toDto(FilmText filmText);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmText partialUpdate(FilmTextDto filmTextDto, @MappingTarget FilmText filmText);
}