package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.dao.ActorDao;
import gov.iti.jets.persistence.dao.FilmDao;
import gov.iti.jets.persistence.entity.*;
import gov.iti.jets.persistence.util.HibernateEntityManagerFactory;
import gov.iti.jets.service.dto.ActorDto;
import gov.iti.jets.service.dto.FilmActorDto;
import gov.iti.jets.service.dto.RentalDto;
import gov.iti.jets.service.mapper.ActorMapper;
import gov.iti.jets.service.mapper.FilmActorMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.Root;
import org.mapstruct.factory.Mappers;
import java.util.Date;
import java.util.List;




public class ActorDaoImp extends BaseDAO implements ActorDao {
    private ActorMapper actorMapper;
    private Actor actor;
    private FilmActorMapper filmActorMapper;
    public ActorDaoImp(){
        actorMapper = Mappers.getMapper(ActorMapper.class);
        filmActorMapper = Mappers.getMapper(FilmActorMapper.class);
    }
    @Override
    public Boolean createActor(ActorDto actorDto) {
        EntityManager entityManager = null;
        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            if(actorDto.getLastUpdate() == null){
                actorDto.setLastUpdate(new Date());
            }
            Actor actor = actorMapper.toEntity(actorDto);
            entityManager.getTransaction().begin();
            entityManager.persist(actor);
            entityManager.getTransaction().commit();
            HibernateEntityManagerFactory.getEntityManagerFactory();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }finally{
            entityManager.close();
        }
        return true;
    }

    @Override
    public ActorDto getActorById(int id) {
        actor = getById(id);
        return actorMapper.toDto(actor);
    }

    @Override
    public Boolean updateActor(int id,ActorDto actorDto) {
        EntityManager entityManager = null;
        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            Actor actor = actorMapper.toEntity(actorDto);
            actor.setActorId((short) id);
            entityManager.getTransaction().begin();
            entityManager.merge(actor);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }finally{
            entityManager.close();
        }
    }

    @Override
    public void deleteActor(int id) {
        EntityManager entityManager = null;

        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaDelete<Actor> cd = cb.createCriteriaDelete(Actor.class);
            Root<Actor> root = cd.from(Actor.class);
            cd.where(cb.equal(root.get("actorId"), id));
            entityManager.createQuery(cd).executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }finally{
            entityManager.close();
        }
    }

    @Override
    public List<ActorDto> getAllActors() {
        List<Actor> actorList = getAll(Actor.class);
        List<ActorDto> actorDtoList = actorList.stream().map((actor -> actorMapper.toDto(actor))).toList();
        return actorDtoList;
    }

    @Override
    public List<FilmActorDto> getFilmListByActor(int id) {
        actor = getById(id);
        List<FilmActor> filmActorList = actor.getFilmActorList();
        List<FilmActorDto> filmActorDtos = filmActorList.stream().map((filmActor -> filmActorMapper.toDto(filmActor))).toList();
        return filmActorDtos;
    }
    private Actor getById(int id){
        return (Actor) get(Actor.class,"actorId",id);
    }

}
