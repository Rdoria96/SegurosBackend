package org.seguros.manager;

import org.seguros.dao.PagosDAO;
import org.seguros.dto.Pagos;
import org.seguros.exception.DaoException;
import org.seguros.exception.MgrException;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.Map;


@Component
public class PagosMGRImp implements PagosMGR{

    private PagosDAO pagosDAO;

    public PagosMGRImp(PagosDAO pagosDAO) {
        this.pagosDAO = pagosDAO;
    }

    public void generatePago(String documento, Date fecha) throws MgrException {
        try {
            int pagos = pagosDAO.getPagosByDoc(documento, fecha);
            if(pagos == 0){
                int idtomador = pagosDAO.getIdTomador(documento);
                pagosDAO.generarPagos(idtomador,fecha);
                System.out.println("El pago generado");
            }else{
                System.out.println("El pago ya existe");
            }
        } catch (DaoException e) {
            e.printStackTrace();
            throw new MgrException(e);
        }catch (Exception ex){
            ex.printStackTrace();
            throw new MgrException(ex);
        }
    }

    public List<Map<String, Object>> mostrarPagos() throws MgrException {
        List<Map<String,Object>>  pagos;
        try {pagos = pagosDAO.gellApp();
        }catch (DaoException e) {
            throw new MgrException(e);
        }catch (Exception ex){
            throw new MgrException(ex);
        }
        return pagos;
    }

    public List<Map<String, Object>> mostrarPagosFiltrados(int año, int mes, String documento) throws MgrException {
        List<Map<String,Object>>  pagos;
        try {pagos = pagosDAO.getByYearMont(año, mes,documento);
        }catch (DaoException e) {
            throw new MgrException(e);
        }catch (Exception ex){
            throw new MgrException(ex);
        }
        return pagos;
    }
}
