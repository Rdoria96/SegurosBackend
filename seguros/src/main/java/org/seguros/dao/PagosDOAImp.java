package org.seguros.dao;

import com.fasterxml.jackson.databind.DatabindException;
import org.seguros.exception.DaoException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public class PagosDOAImp implements PagosDAO{

    private JdbcTemplate jdbcTemplate;

    public PagosDOAImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void generarPagos(int nmid, Date fecha) throws DaoException {
        String sql = "call proc_liquidacion_seguro(?,?)";
        jdbcTemplate.update(sql,nmid,fecha);
    }
}
