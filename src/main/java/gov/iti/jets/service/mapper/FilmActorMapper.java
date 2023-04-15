//package gov.iti.jets.service.mapper;
//
//import gov.iti.jets.service.dto.FilmActorDto;
//import gov.iti.jets.persistence.entity.FilmActor;
//import org.mapstruct.*;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//import static java.util.stream.Collectors.toCollection;
//
//@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel ="cdi", uses = {FilmActorPKMapper.class})
//public interface FilmActorMapper {
//    FilmActor toEntity(FilmActorDto filmActorDto);
//
//    FilmActorDto toDto(FilmActor filmActor);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    FilmActor partialUpdate(FilmActorDto filmActorDto, @MappingTarget FilmActor filmActor);
//
//    default ArrayList<FilmActorDto> toDTOs(Collection<FilmActor> filmActors) {
//        return filmActors.stream().map(entity -> toDto(entity)).collect(toCollection(ArrayList<FilmActorDto>::new));
//    }
//
//    default ArrayList<FilmActor> toEntities(Collection<FilmActorDto> filmActorDtos) {
//        return filmActorDtos.stream().map(dto -> toEntity(dto)).collect(toCollection(ArrayList<FilmActor>::new));
//    }
//}