/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.dao.ICatalogItem;

/**
 *
 * @author u14138
 */
public class SystemService {

    public static HashMap<String, Integer> sequence = new HashMap<>();
    public static HashMap<String, Integer> tempSequence = new HashMap<>();
    public static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("PU_MobileShoppingCart");
    }

    public static EntityManager createEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void loadCatalog(EntityManager em, Map<Integer, String> map, String queryName) {
        Query q = em.createNamedQuery(queryName);
        List<ICatalogItem> list = q.getResultList();

        for (ICatalogItem item : list)
            map.put(item.getItemId(), item.getItemDescription());
    }
    
    public static Integer findMapKey(Map<Integer, String> map, String value) {
        for (Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equals(value))
                return entry.getKey();
        }
        
        return null;
    }
    
    public static String getDBValue(String value) {
        return value == null || value.isEmpty() ? null : value;
    }

    public static int generateID(String entity) {
        if (!sequence.containsKey(entity)) {
            sequence.put(entity, 1);
        } else {
            sequence.put(entity, sequence.get(entity) + 1);
        }

        return sequence.get(entity);
    }

    public static int generateTempID(String entity) {
        if (!tempSequence.containsKey(entity)) {
            tempSequence.put(entity, -1);
        } else {
            tempSequence.put(entity, tempSequence.get(entity) - 1);
        }

        return tempSequence.get(entity);
    }

    public static Date getDate() {
        Calendar c = Calendar.getInstance();
        return c.getTime();
    }
}
