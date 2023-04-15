 package gov.iti.jets.persistence.util;

 import jakarta.persistence.EntityManagerFactory;
 import jakarta.persistence.Persistence;
public class HibernateEntityManagerFactory {

    private static EntityManagerFactory entityManagerFactory;

    private HibernateEntityManagerFactory() {}

    public static synchronized EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit-sakila");
        }
        return entityManagerFactory;
    }

    public static void closeEntityManagerFactory() {
        entityManagerFactory.close();
    }
}
