package org.seguros.business;

import org.seguros.exception.BusException;
import org.seguros.exception.MgrException;
import org.seguros.manager.PagosMGR;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
@Transactional
public class PagosBUSImp implements PagosBUS{

    private PagosMGR pagosMGR;

    public PagosBUSImp(PagosMGR pagosMGR) {
        this.pagosMGR = pagosMGR;
    }

    public void generatePagos(int nmid, Date fecha) throws BusException {
        try{
            pagosMGR.generatePago(nmid,fecha);
        } catch (MgrException e) {
            throw new BusException(e);
        }catch (Exception ex) {
            throw new BusException(ex);
        }
    }
}
