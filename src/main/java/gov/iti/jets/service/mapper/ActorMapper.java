//package gov.iti.jets.service.mapper;
//
//import gov.iti.jets.service.dto.ActorDto;
//import gov.iti.jets.persistence.entity.Actor;
//import org.mapstruct.*;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//import static java.util.stream.Collectors.toCollection;
//
//@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel ="cdi")
//public interface ActorMapper {
//    Actor toEntity(ActorDto actorDto);
//
//    ActorDto toDto(Actor actor);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Actor partialUpdate(ActorDto actorDto, @MappingTarget Actor actor);
//
//    default ArrayList<ActorDto> toDTOs(Collection<Actor> actors) {
//        return actors.stream().map(entity -> toDto(entity)).collect(toCollection(ArrayList<ActorDto>::new));
//    }
//
//    default ArrayList<Actor> toEntities(Collection<ActorDto> actorDtoS) {
//        return actorDtoS.stream().map(dto -> toEntity(dto)).collect(toCollection(ArrayList<Actor>::new));
//    }
//}