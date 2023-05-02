package org.seguros.business;

import org.seguros.exception.BusException;

import java.sql.Date;

public interface PagosBUS {
    void generatePagos(int nmid, Date fecha) throws BusException;
}
