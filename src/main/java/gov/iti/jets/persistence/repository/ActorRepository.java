package gov.iti.jets.persistence.repository;

import java.util.List;

import gov.iti.jets.persistence.dao.ActorDao;
import gov.iti.jets.persistence.daoImp.ActorDaoImp;
import gov.iti.jets.persistence.entity.Actor;
import gov.iti.jets.service.dto.ActorDto;

public class ActorRepository implements ActorDao {
    private ActorDaoImp actorDao;

    public ActorRepository() {
        actorDao = new ActorDaoImp();
    }

    @Override
    public Boolean createActor(ActorDto actorDto) {
        return null;
    }

    @Override
    public ActorDto getActorById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActorById'");
    }

    @Override
    public Boolean updateActor(ActorDto actorDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateActor'");
    }

    @Override
    public void deleteActor(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteActor'");
    }

    @Override
    public List<ActorDto> getAllActors() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllActors'");
    }
}
