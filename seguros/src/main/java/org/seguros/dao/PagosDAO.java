package org.seguros.dao;

import org.seguros.exception.DaoException;

import java.sql.Date;

public interface PagosDAO {

    void generarPagos(int nmid, Date fecha) throws DaoException;
}
