package org.seguros.dao;

import org.seguros.dto.Tomador;
import org.seguros.exception.DaoException;

import java.util.List;
import java.util.Map;

public interface ReaseguradoraDAO {

    void insert(Tomador tomador) throws DaoException;

    void update(Tomador tomador) throws DaoException;

    void delete(int nmid) throws DaoException;

    Tomador getById(int nmid) throws DaoException;

    List<Map<String,Object>> getAll() throws DaoException;



}
