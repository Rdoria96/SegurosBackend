package org.seguros.manager;

import org.seguros.dao.SiniestroDAO;
import org.seguros.dao.TomadorDAO;
import org.seguros.dto.Siniestro;
import org.seguros.dto.Tomador;
import org.seguros.exception.DaoException;
import org.seguros.exception.MgrException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SiniestroMGRImp implements SiniestroMGR {
    private SiniestroDAO siniestroDAO;

    public SiniestroMGRImp(SiniestroDAO siniestroDAO) {

        this.siniestroDAO = siniestroDAO ;
    }

    @Override
    public void saveOrInsert(Siniestro sin) throws MgrException {
        try {
            Siniestro siniestro = siniestroDAO.getById(sin.getNmid());
            if(siniestro == null){
                siniestroDAO.insert(sin);
            }else {
                siniestroDAO.update(sin);
            }
        } catch (DaoException e) {
            throw new MgrException(e);
        }catch (Exception ex){
            throw new MgrException(ex);
        }
    }

    @Override
    public void delete(int nmid) throws MgrException {
        try {
            Siniestro siniestro = siniestroDAO.getById(nmid);
            if(siniestro == null){
                System.out.println("El Siniestro no existe");
            }else {
                siniestroDAO.delete(nmid);
            }
        } catch (DaoException e) {
            throw new MgrException(e);
        }catch (Exception ex){
            throw new MgrException(ex);
        }
    }

    public List<Map<String, Object>> getAll() throws MgrException {
        List<Map<String,Object>>  siniestros;
        try {
            siniestros = siniestroDAO.getAll();
        } catch (DaoException e){
            throw new MgrException(e);
        }catch (Exception ex){
            throw new MgrException(ex);
        }
        return siniestros;
    }
}
