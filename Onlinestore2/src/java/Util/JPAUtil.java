
package Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final String PERSISTENCE_UNIT = "OnlineStorePU";
    private static ThreadLocal<EntityManager> threadLocal;
    private static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        threadLocal = new ThreadLocal<EntityManager>();
    }


    public static EntityManager getEntityManager() {
        if (threadLocal.get() == null) {
            threadLocal.set(factory.createEntityManager());
        }
        return threadLocal.get();
    }

    /**
     * Responsavel por fechar a EntityManager.
     */
    public static void closeEntityManager() {
        EntityManager em = threadLocal.get();
        if (em != null) {
            threadLocal.remove();
            em.close();
        }
    }
    
}