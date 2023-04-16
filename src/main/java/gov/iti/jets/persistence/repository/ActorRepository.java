package gov.iti.jets.persistence.repository;

import java.util.List;

import gov.iti.jets.persistence.dao.ActorDao;
import gov.iti.jets.persistence.daoImp.ActorDaoImp;
import gov.iti.jets.persistence.entity.Actor;
import gov.iti.jets.service.dto.ActorDto;

public class ActorRepository implements ActorDao {
    private ActorDaoImp actorDaoImp;

    public ActorRepository() {
        actorDaoImp = new ActorDaoImp();
    }

    @Override
    public Boolean createActor(ActorDto actorDto) {
        return actorDaoImp.createActor(actorDto);
    }

    @Override
    public ActorDto getActorById(int id) {
        return actorDaoImp.getActorById(id);
    }

    @Override
    public Boolean updateActor(ActorDto actorDto) {
        return  actorDaoImp.updateActor(actorDto);
    }

    @Override
    public void deleteActor(int id) {
        actorDaoImp.deleteActor(id);
    }

    @Override
    public List<ActorDto> getAllActors() {
        return actorDaoImp.getAllActors();
    }
}
