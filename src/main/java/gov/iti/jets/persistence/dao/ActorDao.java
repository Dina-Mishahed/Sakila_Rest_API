package gov.iti.jets.persistence.dao;

import java.util.List;

import gov.iti.jets.persistence.entity.Actor;
import gov.iti.jets.service.dto.ActorDto;

public interface ActorDao {
    Boolean createActor(ActorDto actorDto);
    ActorDto getActorById(int id);
    Actor updateActor(Actor actor);
    void deleteActor(int id);
    List<ActorDto> getAllActors();
}
