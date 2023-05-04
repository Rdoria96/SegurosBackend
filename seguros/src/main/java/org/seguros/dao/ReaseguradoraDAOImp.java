package org.seguros.dao;

import org.seguros.dto.Reaseguradora;
import org.seguros.dto.Tomador;
import org.seguros.exception.DaoException;
import org.seguros.mapper.ReaseguradoraMapper;
import org.seguros.mapper.TomadorMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
@Repository
public class ReaseguradoraDAOImp  implements  ReaseguradoraDAO{

    private JdbcTemplate jdbcTemplate;

    public ReaseguradoraDAOImp(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(Reaseguradora reaseguradora) throws DaoException {
        String insert = "INSERT INTO reaseguradora(\n" +
                "\tnit, razon_social, monto_seguro, porcentaje_cober)\n" +
                "\tVALUES (?, ?, ?, ?);";
        jdbcTemplate.update(insert,
                reaseguradora.getNit(),
                reaseguradora.getRazon_social(),
                reaseguradora.getMonto_seguro(),
                reaseguradora.getPorcentaje_cober());
    }

    public void update(Reaseguradora reaseguradora) throws DaoException {
        String update = "UPDATE reaseguradora\n" +
                "\tSET  nit=?, razon_social=?, monto_seguro=?, porcentaje_cober=?\n" +
                "\tWHERE nmid = ?;";
        jdbcTemplate.update(update,
                reaseguradora.getNit(),
                reaseguradora.getRazon_social(),
                reaseguradora.getMonto_seguro(),
                reaseguradora.getPorcentaje_cober(),
                reaseguradora.getNmid());

    }

    public void delete(int nmid) throws DaoException {
        String delete = "DELETE FROM reaseguradora\n" +
                "\tWHERE nmid = ?;";
        try {
            jdbcTemplate.update(delete,nmid);
        }catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Reaseguradora getById(int nmid) throws DaoException {
        String selectById = "SELECT nmid, nit, razon_social, monto_seguro, porcentaje_cober\n" +
                "\tFROM reaseguradora WHERE nmid =?; ";
        Reaseguradora reaseguradora = null;
        try {
            reaseguradora = jdbcTemplate.queryForObject(selectById, new Object[]{nmid}, new ReaseguradoraMapper());
        }catch(EmptyResultDataAccessException ex){

        }
        return reaseguradora;
    }

    public List<Map<String, Object>> getAll() throws DaoException {
        String select = "SELECT nmid, nit, razon_social, monto_seguro, porcentaje_cober\n" +
                "\tFROM reaseguradora;";
        List<Map<String,Object>> listReaseguradora;
        try {
            listReaseguradora = jdbcTemplate.queryForList(select);

        } catch (Exception e) {
            throw new DaoException(e);
        }
        return listReaseguradora;
    }

}
