package org.seguros.business;

import org.seguros.dto.Reaseguradora;
import org.seguros.dto.Tomador;
import org.seguros.exception.BusException;
import org.seguros.exception.MgrException;
import org.seguros.manager.ReaseguradoraMGR;
import org.seguros.manager.TomadorMGR;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Service
@Transactional
public class ReaseguradoraBUSImp implements ReaseguradoraBUS {

    private ReaseguradoraMGR reaseguradoraMGR;

    public ReaseguradoraBUSImp(ReaseguradoraMGR reaseguradoraMGR)
    {
        this.reaseguradoraMGR = reaseguradoraMGR;
    }

    public void createReaseguradora(Reaseguradora rea) throws BusException {

        try {
            reaseguradoraMGR.saveOrInsert(rea);
        } catch (MgrException e) {
            throw new BusException(e);
        }catch (Exception ex) {
            throw new BusException(ex);
        }
    }

    public void eleiminarReaseguradora(int nmid) throws BusException {

        try {
            reaseguradoraMGR.delete(nmid);
        } catch (MgrException e) {
            throw new BusException(e);
        }catch (Exception ex) {
            throw new BusException(ex);
        }
    }

    public List<Map<String,Object>> mostrarReaseguradoras() throws BusException {
        List<Map<String,Object>> reaseguradoras;

        try {
            reaseguradoras = reaseguradoraMGR.getAll();
        } catch (MgrException e) {
            throw new BusException(e);
        }catch (Exception ex) {
            throw new BusException(ex);
        }
        return reaseguradoras;
    }
}
