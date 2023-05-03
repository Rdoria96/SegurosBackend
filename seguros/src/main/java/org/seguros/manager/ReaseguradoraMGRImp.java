package org.seguros.manager;

import org.seguros.dao.ReaseguradoraDAO;
import org.seguros.dto.Reaseguradora;
import org.seguros.exception.DaoException;
import org.seguros.exception.MgrException;

import java.util.List;
import java.util.Map;

public class ReaseguradoraMGRImp implements ReaseguradoraMGR {

    private ReaseguradoraDAO reaseguradoraDAO;

    public ReaseguradoraMGRImp(ReaseguradoraDAO reaseguradoraDAO) {
        this.reaseguradoraDAO = reaseguradoraDAO;
    }

    public void saveOrInsert(Reaseguradora rea) throws MgrException {
        try {
            Reaseguradora reaseguradora = reaseguradoraDAO.getById(rea.getNmid());
            if(reaseguradora == null){
                reaseguradoraDAO.insert(rea);
            }else {
                reaseguradoraDAO.update(rea);
            }
        } catch (DaoException e) {
            throw new MgrException(e);
        }catch (Exception ex){
            throw new MgrException(ex);
        }
    }

    public void delete(int nmid) throws  MgrException {
        try {
            Reaseguradora reaseguradora  = reaseguradoraDAO.getById(nmid);
            if(reaseguradora == null){
                System.out.println("LA reaseguradora no existe");
            }else {
                reaseguradoraDAO.delete(nmid);
            }
        } catch (DaoException e) {
            throw new MgrException(e);
        }catch (Exception ex){
            throw new MgrException(ex);
        }
    }

    public List<Map<String,Object>> getAll() throws  MgrException {
        List<Map<String,Object>>  reaseguradoras;
        try {
            reaseguradoras = reaseguradoraDAO.getAll();
        } catch (DaoException e){
            throw new MgrException(e);
        }catch (Exception ex){
            throw new MgrException(ex);
        }
        return reaseguradoras;
    }
}
