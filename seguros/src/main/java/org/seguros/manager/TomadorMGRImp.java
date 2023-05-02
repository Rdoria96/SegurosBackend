package org.seguros.manager;

;
import org.seguros.dao.TomadorDAO;
import org.seguros.dto.Tomador;
import org.seguros.exception.DaoException;
import org.seguros.exception.MgrException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class TomadorMGRImp implements TomadorMGR{

    private TomadorDAO tomadorDAO;

    public TomadorMGRImp(TomadorDAO tomadorDAO) {
        this.tomadorDAO = tomadorDAO;
    }

    public void saveOrInsert(Tomador tom) throws MgrException {
        try {
            Tomador tomador = tomadorDAO.getById(tom.getNmid());
            if(tomador == null){
                tomadorDAO.insert(tom);
            }else {
                tomadorDAO.update(tom);
            }
        } catch (DaoException e) {
            throw new MgrException(e);
        }catch (Exception ex){
            throw new MgrException(ex);
        }
    }

    public void delete(int nmid) throws  MgrException {
        try {
            Tomador tomador = tomadorDAO.getById(nmid);
            if(tomador == null){
                System.out.println("El tomador no existe");
            }else {
                tomadorDAO.delete(nmid);
            }
        } catch (DaoException e) {
            throw new MgrException(e);
        }catch (Exception ex){
            throw new MgrException(ex);
        }
    }

    public List<Map<String,Object>> getAll() throws  MgrException {
        List<Map<String,Object>>  tomadores;
        try {
            tomadores = tomadorDAO.getAll();
        } catch (DaoException e){
            throw new MgrException(e);
        }catch (Exception ex){
            throw new MgrException(ex);
        }
        return tomadores;
    }
}
