package gov.iti.jets.mapper;

import gov.iti.jets.dto.ActorFormDto;
import gov.iti.jets.persistence.entity.Actor;
import org.mapstruct.*;

//The @Mapper annotation is used to configure the mapping behavior.
//        The unmappedTargetPolicy attribute is set to ReportingPolicy.IGNORE,
//        which means that any unmapped properties between the source and target objects will be
//        ignored during the mapping process. The componentModel attribute is set to MappingConstants.
//        ComponentModel.CDI,
//        which means that the mapper implementation will be generated as a CDI bean.
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "cdi")
public interface ActorFormMapper {
    Actor toEntity(ActorFormDto actorFormDto);

    ActorFormDto toDto(Actor actor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Actor partialUpdate(ActorFormDto actorFormDto, @MappingTarget Actor actor);
}