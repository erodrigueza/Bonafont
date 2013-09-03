package com.danone.bonafont.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.danone.bonafont.batch.dao.ArchivoDAO;
import com.danone.bonafont.batch.model.Archivo;

/**
 * @author Eduardo Rodriguez
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"/launch-context.xml"})  
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class ArchivoDAOJPAImplTest {

	@Resource
	ArchivoDAO archivoDAO;  
      
    @Test
    public void crudArchivo(){  
    	System.err.println("Inicia prueba..!!");
        Archivo archivo = new Archivo();
        archivo.setCh_nombre("TestDao.xml");
        archivo.setDa_registro(new Date());
        archivo.setNu_id_estatus(1001);
        archivo.setNu_id_tipo(1);
        
        archivoDAO.insert(archivo);  
          
        assertEquals(new Long(1), archivo.getNu_id_archivo());  
          
        Archivo archivoRecuperado = archivoDAO.findByPK(Archivo.class, archivo.getNu_id_archivo());  
        archivoRecuperado.setCh_nombre("Final.xml");;  
          
        archivoDAO.update(archivoRecuperado);  
          
        archivoRecuperado = archivoDAO.findByPK(Archivo.class, archivoRecuperado.getNu_id_archivo());  
        assertEquals("Final.xml", archivoRecuperado.getCh_nombre());  
          
        archivoDAO.remove(archivoRecuperado);  
          
    }  
}
