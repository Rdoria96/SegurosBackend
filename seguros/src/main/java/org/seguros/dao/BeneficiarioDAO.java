package org.seguros.dao;

import org.seguros.dto.Beneficiario;
import org.seguros.exception.DaoException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BeneficiarioDAO {
    public void insert(Beneficiario beneficiario) throws DaoException;

    public void update(Beneficiario beneficiario) throws DaoException;

    public void delete(int nmid) throws DaoException;

    public List<Map<String, Object>> getAll() throws DaoException;

    public Beneficiario getById(int nmid) throws DaoException;
}

