package com.danone.bonafont.batch.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Eduardo Rodriguez
 *
 */
public interface GenericDAO <T, PK extends Serializable> {  
	  
    List<T> getAll(Class<T> typeClass);  
  
    T findByPK(Class<T> typeClass, PK id);  
  
    void update(T object);
    
    void update(List<T> objects);
  
    void remove(T object);  
  
    void insert(T object);  
      
    List<T> getPaginated(Class<T> typeClass, int startPosition, int maxResult);  
      
    List<T> getOrderedPaginated(Class<T> typeClass, int startPosition, int maxResult, String order, int dir);  
  
}  
