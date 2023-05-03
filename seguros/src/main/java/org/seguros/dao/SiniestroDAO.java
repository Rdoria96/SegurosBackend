package org.seguros.dao;

import org.seguros.dto.Siniestro;
import org.seguros.exception.DaoException;

import java.util.List;
import java.util.Map;

public interface SiniestroDAO {
    void insert(Siniestro siniestro) throws DaoException;
    void update(Siniestro siniestro) throws DaoException;
    void delete(int nmid) throws DaoException;
    Siniestro getById(int nmid) throws DaoException;

    List<Map<String,Object>> getAll() throws DaoException;
}
