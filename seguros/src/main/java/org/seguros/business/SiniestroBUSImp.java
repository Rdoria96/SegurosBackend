package org.seguros.business;

import org.seguros.dto.Siniestro;
import org.seguros.dto.Tomador;
import org.seguros.exception.BusException;
import org.seguros.exception.MgrException;
import org.seguros.manager.SiniestroMGR;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SiniestroBUSImp implements SiniestroBUS {

    private SiniestroMGR siniestroMGR;
    public SiniestroBUSImp(SiniestroMGR siniestroMGR) {

        this.siniestroMGR = siniestroMGR;
    }
    public void createSiniestro(Siniestro sin) throws BusException {

        try {
            siniestroMGR.saveOrInsert(sin);
        } catch (MgrException e) {
            throw new BusException(e);
        }catch (Exception ex) {
            throw new BusException(ex);
        }
    }

    @Override
    public void eleiminarSiniestros(int nmid) throws BusException {
        try {
            siniestroMGR.delete(nmid);
        } catch (MgrException e) {
            throw new BusException(e);
        }catch (Exception ex) {
            throw new BusException(ex);
        }
    }

    public List<Map<String,Object>> mostrarSiniestros() throws BusException {
        List<Map<String,Object>> siniestros;

        try {
            siniestros = siniestroMGR.getAll();
        } catch (MgrException e) {
            throw new BusException(e);
        }catch (Exception ex) {
            throw new BusException(ex);
        }
        return siniestros;
    }
}
