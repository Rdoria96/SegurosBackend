package org.seguros.business;

import org.seguros.dto.Tomador;
import org.seguros.exception.BusException;
import org.seguros.exception.MgrException;
import org.seguros.manager.TomadorMGR;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TomadorBUSImp implements TomadorBUS{

    private TomadorMGR tomadorMGR;

    public TomadorBUSImp(TomadorMGR tomadorMGR) {
        this.tomadorMGR = tomadorMGR;
    }

    public void createTomador(Tomador tom) throws BusException {

        try {
            tomadorMGR.saveOrInsert(tom);
        } catch (MgrException e) {
            throw new BusException(e);
        }catch (Exception ex) {
            throw new BusException(ex);
        }
    }

    public void eleiminarTomador(int nmid) throws BusException {

        try {
            tomadorMGR.delete(nmid);
        } catch (MgrException e) {
            throw new BusException(e);
        }catch (Exception ex) {
            throw new BusException(ex);
        }
    }

    public List<Map<String,Object>> mostrarTomadores() throws BusException {
        List<Map<String,Object>> tomadores;

        try {
            tomadores = tomadorMGR.getAll();
        } catch (MgrException e) {
            throw new BusException(e);
        }catch (Exception ex) {
            throw new BusException(ex);
        }
        return tomadores;
    }
}
