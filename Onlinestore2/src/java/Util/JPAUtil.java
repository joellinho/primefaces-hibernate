/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory emf;
    private static ThreadLocal<EntityManager> managerEM;
    private static ThreadLocal<EntityTransaction> managerET;


    public static void init(String nameBD) {
        emf = Persistence.createEntityManagerFactory(nameBD);
        System.out.println("Abriu conexão!");
        managerEM = new ThreadLocal<EntityManager>();
        managerET = new ThreadLocal<EntityTransaction>();
    }


    public static EntityManager getEntityManager() {
        if (managerEM.get() == null) {
            managerEM.set(emf.createEntityManager());
        }
        return managerEM.get();
    }   


    public static EntityTransaction getTransaction() {
        if (managerET.get() == null) {
            managerET.set(getEntityManager().getTransaction());
        }

        return managerET.get();
    }
    
     public static void closeEntityManagerFactory() {
        emf.close();
    }
     public static void closeEntityManager() {
        EntityManager entityManager = managerEM.get();
        if (entityManager != null) {
            entityManager.close();
            managerEM.set(null);
        }
    }

    public static void commit() {
        if (!managerET.get().isActive()) {
            managerET.get().begin();
        }
        managerET.get().commit();
    }

    public static void rollback() {
        if (!managerET.get().isActive()) {
          managerET.get().begin();
        }
        managerET.get().rollback();
    }
    
}