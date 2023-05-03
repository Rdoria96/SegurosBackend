package org.seguros.dao;

import org.seguros.dto.Seguro;
import org.seguros.exception.DaoException;
import java.util.List;
import java.util.Map;


public interface SegurosDAO {
   public void insert(Seguro seguro) throws DaoException;
    public void update(Seguro seguro) throws DaoException;
    public void delete(int nmid) throws DaoException;
    public Seguro getById(int nmid) throws DaoException;
    public List<Map<String, Object>> getAll() throws DaoException;
}
