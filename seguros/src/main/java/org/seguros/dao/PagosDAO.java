package org.seguros.dao;

import org.seguros.dto.Pagos;
import org.seguros.exception.DaoException;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface PagosDAO {

    void generarPagos(int nmid, Date fecha) throws DaoException;

    List<Map<String, Object>> gellApp() throws DaoException;

    int getPagosByDoc(String documento, Date fecha ) throws DaoException;

    int getIdTomador(String documento) throws DaoException;

    List<Map<String, Object>> getByYearMont(int año, int mes, String documento) throws DaoException;
}
