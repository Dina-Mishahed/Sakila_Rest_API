package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.entity.City;
import gov.iti.jets.persistence.entity.Country;
import gov.iti.jets.persistence.util.HibernateEntityManagerFactory;
import gov.iti.jets.service.dto.CityDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class BaseDAO <E extends Object>{
    public  <T> T executeWithEntityManager(Function<EntityManager, T> function) {
        EntityManager entityManager = null;
        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
            T result = function.apply(entityManager);
            entityManager.getTransaction().commit();
            return result;
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    public <T> T get(Class<T> entityType, String idFieldName, int id) {
        return executeWithEntityManager(entityManager -> {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(entityType);
            Root<T> root = cq.from(entityType);
            cq.where(cb.equal(root.get(idFieldName), id));
            TypedQuery<T> query = entityManager.createQuery(cq);
            return query.getSingleResult();
        });
    }
    public <T> List<T> getAll(Class<T> entityType) {
        return executeWithEntityManager(entityManager -> {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(entityType);
            Root<T> root = cq.from(entityType);
            TypedQuery<T> query = entityManager.createQuery(cq);
            return query.getResultList();
        });
    }

//    public <T> void insert(Class<T> entityType, T entity) {
//        try {
//            if (entity == null) {
//                throw new IllegalArgumentException("Entity cannot be null");
//            }
//            executeWithEntityManager(entityManager -> {
//                entityManager.getTransaction().begin();
//                entityManager.persist(entity);
//                entityManager.getTransaction().commit();
//                return true;
//            });
//        } catch (IllegalArgumentException e) {
//            throw new IllegalArgumentException("IllegalArgumentException....");
//        } catch (PersistenceException e) {
//            throw new PersistenceException("PersistenceException.....");
//        }
//    }

    public <T> Boolean update(Class<T> entityType,T entity) throws Exception {
        try{
            return executeWithEntityManager(entityManager -> {
                entityManager.getTransaction().begin();
                entityManager.merge(entity);
                entityManager.getTransaction().commit();
                return true;
            });
        }catch(IllegalArgumentException |PersistenceException e ){
            throw new Exception("Exception.....");
        }

    }
//    public <T, E> List<T> getList(Class<T> returnEntityType, Class<E> entityType, String idFieldName, int id) {
//        return executeWithEntityManager(entityManager -> {
//            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//            CriteriaQuery<T> cq = cb.createQuery(returnEntityType);
//            Root<T> root = cq.from(returnEntityType);
//            Join<T, E> join = root.join(idFieldName);
//            Predicate joinPredicate = cb.equal(join.get(idFieldName), id);
//            cq.select(root).where(joinPredicate);
//            TypedQuery<T> query = entityManager.createQuery(cq);
//            return query.getResultList();
//        });
//    }
    public <T, E> List<T> getListByJoin(Class<T> returnEntityType, Class<E> entityType, String idFieldName, int id) {
        return executeWithEntityManager(entityManager -> {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(returnEntityType);
            Root<T> root = cq.from(returnEntityType);
            Join<T, E> join = root.join(idFieldName);
            Predicate joinPredicate = cb.equal(join.get(idFieldName), id);
            cq.select(root).where(joinPredicate);
            TypedQuery<T> query = entityManager.createQuery(cq);
            return query.getResultList();
        });
    }



}
