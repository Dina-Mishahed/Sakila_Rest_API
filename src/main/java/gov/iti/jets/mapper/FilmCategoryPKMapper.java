package gov.iti.jets.mapper;

import gov.iti.jets.persistence.entity.FilmCategoryPK;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel ="cdi")
public interface FilmCategoryPKMapper {
    FilmCategoryPK toEntity(FilmCategoryPK filmCategoryPK);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmCategoryPK partialUpdate(FilmCategoryPK filmCategoryPKDto, @MappingTarget FilmCategoryPK filmCategoryPK);
}