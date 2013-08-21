package com.danone.bonafont.batch.dao.imp.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.danone.bonafont.batch.dao.GenericDAO;

/**
 * @author Eduardo Rodriguez
 *
 */
@PersistenceContext(unitName="interfaces")  
public class GenericDAOJPAImpl<T, PK extends Serializable> extends  
        JpaDaoSupport implements GenericDAO<T, PK> {  
  
    @Transactional  
    public void insert(T t) {  
        getJpaTemplate().persist(t);  
    }  
  
    @Transactional(readOnly = true)  
    public T findByPK(Class<T> typeClass, PK id) {  
        return getJpaTemplate().find(typeClass, id);  
    }  
  
    @Transactional(readOnly = true)  
    @SuppressWarnings("unchecked")  
    public List<T> getAll(Class<T> typeClass) {  
  
        final StringBuilder sql = new StringBuilder("select c from ").append(  
                typeClass.getSimpleName()).append(" c");  
        return (List<T>) getJpaTemplate().find(sql.toString());  
  
    }  
  
    @Transactional  
    public void remove(T object) {  
        getJpaTemplate().remove(getJpaTemplate().merge(object));  
    }  
  
    @Transactional  
    public void update(T object) {  
        getJpaTemplate().merge(object);  
    }  
  
    @SuppressWarnings("unchecked")  
    @Transactional(readOnly = true)  
    public List<T> getPaginated(Class<T> typeClass, int startPosition,  
            int maxResult) {  
        final StringBuilder sql = new StringBuilder("select c from ").append(  
                typeClass.getSimpleName()).append(" c");  
        final Query query = getJpaTemplate().getEntityManagerFactory()  
                .createEntityManager().createQuery(sql.toString());  
        query.setFirstResult(startPosition);  
        query.setMaxResults(maxResult);  
  
        return (List<T>) query.getResultList();  
    }  
  
    @SuppressWarnings("unchecked")  
    @Transactional(readOnly = true)  
    public List<T> getOrderedPaginated(Class<T> typeClass, int startPosition,  
            int maxResult, String order, int dir) {  
        String direccion = "ASC";  
        if (dir == 2) {  
            direccion = "DESC";  
        }  
        final StringBuilder sql = new StringBuilder("select c from ")  
                .append(typeClass.getSimpleName()).append(" c order by ")  
                .append(order).append(" ").append(direccion);  
        final Query query = getJpaTemplate().getEntityManager().createQuery(  
                sql.toString());  
        query.setFirstResult(startPosition);  
        query.setMaxResults(maxResult);  
  
        return (List<T>) query.getResultList();  
    }  
  
}