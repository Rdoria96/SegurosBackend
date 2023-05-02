package org.seguros.manager;

import org.seguros.exception.DaoException;
import org.seguros.exception.MgrException;

import java.sql.Date;

public interface PagosMGR {

    void generatePago(int nmid, Date fecha) throws MgrException;
}
