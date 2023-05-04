package org.seguros.manager;

import org.seguros.dao.SegurosDAO;
import org.seguros.dto.Seguro;
import org.seguros.exception.DaoException;
import org.seguros.exception.MgrException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Component
public class SegurosMGRImp implements SegurosMGR{

    private SegurosDAO segurosDAO;

    public SegurosMGRImp (SegurosDAO segurosDAO){
        this.segurosDAO = segurosDAO;
    }

    public void saveUpdate(Seguro seguro) throws MgrException {
     try {
         Seguro seguro1 = segurosDAO.getById(seguro.getNmid());
         if (seguro1 == null){
             segurosDAO.insert(seguro);
         }else {
             segurosDAO.update(seguro);
         }
     }catch (DaoException e){
         throw new MgrException(e);
     }
    }

    public void delete(int nmid)throws MgrException{
        try {
            Seguro seguro = segurosDAO.getById(nmid);
            if (seguro == null){
                System.out.println("El nmid no existe!");
            }else {
                segurosDAO.delete(nmid);
            }
        }catch (DaoException e){
            e.printStackTrace();
            throw new MgrException(e);
        }
    }

    public List<Map<String,Object>> getAll() throws  MgrException {
        List<Map<String,Object>>  seg;
        try {
            seg = segurosDAO.getAll();
        } catch (DaoException e){
            throw new MgrException(e);
        }catch (Exception ex){
            throw new MgrException(ex);
        }
        return seg;
    }
}
