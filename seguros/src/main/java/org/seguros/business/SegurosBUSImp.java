package org.seguros.business;

import org.seguros.dto.Seguro;
import org.seguros.exception.BusException;
import org.seguros.exception.MgrException;
import org.seguros.manager.SegurosMGR;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SegurosBUSImp implements SegurosBUS{

    private SegurosMGR segurosMGR;

    public SegurosBUSImp (SegurosMGR segurosMGR){
        this.segurosMGR = segurosMGR;
    }

    public void  crearSeguro(Seguro seguro) throws BusException{
        try {
            segurosMGR.saveUpdate(seguro);
        }catch (MgrException e){
            throw  new BusException(e);
        }catch (Exception e){
            throw new BusException(e);
        }
    }

    public void EliminarSeguro(int nmid) throws BusException{
        try {
            segurosMGR.delete(nmid);
        }catch (MgrException e){
            throw new BusException(e);
        }catch (Exception e){
            throw new BusException(e);
        }
    }


    public List<Map<String,Object>> mostrarSeguros() throws BusException {
        List<Map<String,Object>> Seguros;

        try {
            Seguros = segurosMGR.getAll();
        } catch (MgrException e) {
            throw new BusException(e);
        }catch (Exception ex) {
            throw new BusException(ex);
        }
        return Seguros;
    }

}
