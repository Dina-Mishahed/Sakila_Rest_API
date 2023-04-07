package gov.iti.jets.persistence.dao;

import java.util.List;

import gov.iti.jets.persistence.entity.Actor;

public interface ActorDao {
    Actor createActor(Actor actor);
    Actor getActorById(int id);
    Actor updateActor(Actor actor);
    void deleteActor(int id);
    List<Actor> getAllActors();
}
