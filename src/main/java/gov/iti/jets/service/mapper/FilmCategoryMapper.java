package gov.iti.jets.service.mapper;

import gov.iti.jets.service.dto.FilmCategoryDto;
import gov.iti.jets.persistence.entity.FilmCategory;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel ="cdi", uses = {FilmCategoryPKMapper.class})
public interface FilmCategoryMapper {
    FilmCategory toEntity(FilmCategoryDto filmCategoryDto);

    FilmCategoryDto toDto(FilmCategory filmCategory);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmCategory partialUpdate(FilmCategoryDto filmCategoryDto, @MappingTarget FilmCategory filmCategory);
}