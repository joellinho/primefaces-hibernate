/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.parameter.SortParam;

/**
 *
 * @author u14138
 */
public class BaseService {

    public static String addParamToBuilder(StringBuilder builder, Integer paramCount, boolean isLastParam) {
        String paramName = "f" + paramCount.toString();
        builder.append(":");
        builder.append(paramName);

        if (!isLastParam) {
            builder.append(",");
        } else {
            builder.append(")");
        }

        return paramName;
    }

    public static void addSortToBuilder(StringBuilder builder, SortParam sort) {
        builder.append(" ORDER BY ");
        builder.append(sort.getField());

        if (!sort.isAscending()) {
            builder.append(" DESC");
        }
    }

    public static void setQueryParams(Query q, Map<String, Object> queryParams) {
        for (Entry<String, Object> entry : queryParams.entrySet()) {
            q.setParameter(entry.getKey(), entry.getValue());
        }
    }

    private EntityManager entityManager;

    protected void initConnection() {
        if (entityManager == null) {
            entityManager = SystemService.createEntityManager();
        }
    }

    protected void closeConnection() {
        if (entityManager != null) {
            entityManager.close();
            entityManager = null;
        }
    }

    protected void initTransaction() {
        initConnection();
        entityManager.getTransaction().begin();
    }

    protected void commitTransaction() {
        entityManager.getTransaction().commit();
        closeConnection();
    }

    protected void rollbackTransaction() {
        entityManager.getTransaction().rollback();
        closeConnection();
    }

    protected Object findById(Class entityClass, int id) {
        return findById(entityClass, id, false);
    }

    protected Object findById(Class entityClass, int id, boolean connectionExists) {
        if (!connectionExists) {
            initConnection();
        }

        Object result = entityManager.find(entityClass, id);

        if (!connectionExists) {
            closeConnection();
        }

        return result;
    }

    protected void setParams(Query q, Map<String, Object> params) {
        if (params != null && !params.isEmpty()) {
            for (Entry<String, Object> entry : params.entrySet()) {
                q.setParameter(entry.getKey(), entry.getValue());
            }
        }
    }

    protected List getResultList(String queryName, Map<String, Object> params) {
        return getResultList(queryName, params, false);
    }

    protected List getResultList(String queryName, Map<String, Object> params, boolean connectionExists) {
        if (!connectionExists) {
            initConnection();
        }

        Query q = entityManager.createNamedQuery(queryName);
        setParams(q, params);
        List result = q.getResultList();

        if (!connectionExists) {
            closeConnection();
        }

        return result;
    }

    protected Object getSingleResult(String queryName, Map<String, Object> params) {
        return getSingleResult(queryName, params, false);
    }

    protected Object getSingleResult(String queryName, Map<String, Object> params, boolean connectionExists) {
        if (!connectionExists) {
            initConnection();
        }

        Query q = entityManager.createNamedQuery(queryName);
        setParams(q, params);
        List list = q.getResultList();
        Object result = list == null || list.isEmpty() ? null : list.get(0);

        if (!connectionExists) {
            closeConnection();
        }

        return result;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
