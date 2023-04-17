package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.entity.City;
import gov.iti.jets.persistence.util.HibernateEntityManagerFactory;
import gov.iti.jets.service.dto.CityDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

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
//    public  <T> T get(Class C, String s,int id){
//        return executeWithEntityManager(entityManager -> {
//            CriteriaBuilder cb = ((EntityManager) entityManager).getCriteriaBuilder();
//            CriteriaQuery<T> cq = cb.createQuery(T.class);
//            Root<C> root = cq.from(C);
//            cq.where(cb.equal(root.get(s), id));
//            TypedQuery<T> query = ((EntityManager) entityManager).createQuery(cq);
//            C obj = query.getSingleResult();
//            return obj;
//        });
//    }
}
