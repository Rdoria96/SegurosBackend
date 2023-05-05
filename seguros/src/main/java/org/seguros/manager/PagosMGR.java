package org.seguros.manager;

import org.seguros.exception.DaoException;
import org.seguros.exception.MgrException;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface PagosMGR {

    void generatePago(String documento, Date fecha) throws MgrException;

    List<Map<String, Object>> mostrarPagos() throws MgrException;

    public List<Map<String, Object>> mostrarPagosFiltrados(int año, int mes, String documento) throws MgrException;
}
