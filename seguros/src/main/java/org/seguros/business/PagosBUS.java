package org.seguros.business;

import org.seguros.exception.BusException;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface PagosBUS {
    void generatePagos(String documento, Date fecha) throws BusException;

    List<Map<String, Object>> mostrarPagos() throws BusException;

    List<Map<String, Object>> mostrarPagosFiltrados(int año, int mes, String documento) throws BusException;
}
