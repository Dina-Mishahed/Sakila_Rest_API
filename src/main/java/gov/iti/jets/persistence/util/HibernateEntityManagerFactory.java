 package gov.iti.jets.persistence.util;

 import jakarta.persistence.EntityManagerFactory;
 import jakarta.persistence.Persistence;
public class HibernateEntityManagerFactory {

    private static EntityManagerFactory entityManagerFactory;

    private HibernateEntityManagerFactory() {

    }
    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            System.out.println("HibernateEntityManagerFactory Null.................................");
            try{
                entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
                System.out.println("corect");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return entityManagerFactory;
    }

    public static void closeEntityManagerFactory() {
        entityManagerFactory.close();
    }
}
