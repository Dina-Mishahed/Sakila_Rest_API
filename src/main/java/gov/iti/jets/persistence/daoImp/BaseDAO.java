package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.util.HibernateEntityManagerFactory;
import jakarta.persistence.EntityManager;

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
}
