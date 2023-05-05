package org.seguros.business;

import org.seguros.exception.BusException;
import org.seguros.exception.MgrException;
import org.seguros.manager.PagosMGR;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PagosBUSImp implements PagosBUS{

    private PagosMGR pagosMGR;

    public PagosBUSImp(PagosMGR pagosMGR) {
        this.pagosMGR = pagosMGR;
    }

    public void generatePagos(String documento, Date fecha) throws BusException {
        try{
            pagosMGR.generatePago(documento,fecha);
        } catch (MgrException e) {
            e.printStackTrace();
            throw new BusException(e);
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new BusException(ex);
        }
    }

    public List<Map<String, Object>>  mostrarPagos() throws BusException {
        List<Map<String,Object>> pagos;
        try {
            pagos = pagosMGR.mostrarPagos();
        } catch (MgrException e) {
            throw new BusException(e);
        }catch (Exception ex) {
            throw new BusException(ex);
        }
        return pagos;
    }

    public List<Map<String, Object>> mostrarPagosFiltrados(int año, int mes, String documento) throws BusException {
        List<Map<String, Object>> pagos;
        try {
            pagos = pagosMGR.mostrarPagosFiltrados(año, mes, documento);
        } catch (MgrException e) {
            throw new BusException(e);
        } catch (Exception ex) {
            throw new BusException(ex);
        }
        return pagos;
    }
}
