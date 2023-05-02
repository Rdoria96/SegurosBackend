package org.seguros.manager;

import org.seguros.dao.PagosDAO;
import org.seguros.exception.DaoException;
import org.seguros.exception.MgrException;
import org.springframework.stereotype.Component;

import java.sql.Date;


@Component
public class PagosMGRImp implements PagosMGR{

    private PagosDAO pagosDAO;

    public PagosMGRImp(PagosDAO pagosDAO) {
        this.pagosDAO = pagosDAO;
    }

    public void generatePago(int nmid, Date fecha) throws MgrException {
        try {
            pagosDAO.generarPagos(nmid,fecha);
        } catch (DaoException e) {
            throw new MgrException(e);
        }catch (Exception ex){
            throw new MgrException(ex);
        }
    }
}
