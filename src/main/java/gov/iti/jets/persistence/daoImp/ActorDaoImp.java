package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.dao.ActorDao;
import gov.iti.jets.persistence.entity.Actor;
import gov.iti.jets.persistence.util.HibernateEntityManagerFactory;
import gov.iti.jets.service.dto.ActorDto;
import gov.iti.jets.service.mapper.ActorMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;




public class ActorDaoImp implements ActorDao {
    private ActorMapper actorMapper;
    public ActorDaoImp(){
        actorMapper = Mappers.getMapper(ActorMapper.class);
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
        EntityManager entityManager = null;

        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);
            Root<Actor> root = cq.from(Actor.class);
            cq.where(cb.equal(root.get("actorId"), id));
            TypedQuery<Actor> query = entityManager.createQuery(cq);
            ActorDto actorDto =  actorMapper.toDto(query.getSingleResult());
            return actorDto;
        } catch (NoResultException e) {
            return null;
        }finally{
            entityManager.close();
        }
    }

    @Override
    public Boolean updateActor(ActorDto actorDto) {
        EntityManager entityManager = null;

        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            Actor actor = actorMapper.toEntity(actorDto);
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
        EntityManager entityManager = null;

        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);
            Root<Actor> root = cq.from(Actor.class);
            cq.select(root);

            TypedQuery<Actor> query = entityManager.createQuery(cq);
            List<Actor> actors = query.getResultList();
            List<ActorDto> actorDtos = new ArrayList<>();
            for (Actor actor : actors) {
                ActorDto actorDto = actorMapper.toDto(actor);
                actorDtos.add(actorDto);
            }
            return actorDtos;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }finally{
            entityManager.close();
        }
    }
}
