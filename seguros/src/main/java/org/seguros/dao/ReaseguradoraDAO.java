package org.seguros.dao;

import org.seguros.dto.Reaseguradora;
import org.seguros.dto.Tomador;
import org.seguros.exception.DaoException;

import java.util.List;
import java.util.Map;

public interface ReaseguradoraDAO {

    void insert(Reaseguradora reaseguradora) throws DaoException;

    void update(Reaseguradora reaseguradora) throws DaoException;

    void delete(int nmid) throws DaoException;

    Reaseguradora getById(int nmid) throws DaoException;

    List<Map<String,Object>> getAll() throws DaoException;



}
