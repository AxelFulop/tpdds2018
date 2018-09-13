package Servicios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Session {
   static EntityManagerFactory d = Persistence.createEntityManagerFactory("db");
    static EntityManager em = d.createEntityManager();
    static EntityTransaction transaction = em.getTransaction();

    public static EntityManager getSession(){
        return em;
    }
    public static void beginTransaction(){
        transaction.begin();
    }
    public static void rollbackTransaction(){
        transaction.rollback();
    }
    public static void commitTransaction(){
        transaction.commit();
    }

}
