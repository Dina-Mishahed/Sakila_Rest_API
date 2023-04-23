package gov.iti.jets.persistence.repository;

import java.util.List;

import gov.iti.jets.persistence.dao.ActorDao;
import gov.iti.jets.persistence.daoImp.ActorDaoImp;
import gov.iti.jets.service.dto.ActorDto;
import gov.iti.jets.service.dto.FilmActorDto;

public class ActorRepository implements ActorDao {
    private ActorDao actorDaoImp;

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
    public Boolean updateActor(int id,ActorDto actorDto) {
        return  actorDaoImp.updateActor( id,actorDto);
    }

    @Override
    public void deleteActor(int id) {
        actorDaoImp.deleteActor(id);
    }

    @Override
    public List<ActorDto> getAllActors() {
        return actorDaoImp.getAllActors();
    }

    @Override
    public List<FilmActorDto> getFilmListByActor(int id) {
        return actorDaoImp.getFilmListByActor(id);
    }

    @Override
    public List<ActorDto> getActorByName(String name) {
        return actorDaoImp.getActorByName(name);
    }
}
