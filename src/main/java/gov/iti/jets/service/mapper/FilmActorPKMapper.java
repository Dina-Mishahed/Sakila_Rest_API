package gov.iti.jets.service.mapper;

import gov.iti.jets.persistence.entity.FilmActorPK;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel ="cdi")
public interface FilmActorPKMapper {
    FilmActorPK toEntity(FilmActorPK filmActorPK);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmActorPK partialUpdate(FilmActorPK filmActorPKDto, @MappingTarget FilmActorPK filmActorPK);
}