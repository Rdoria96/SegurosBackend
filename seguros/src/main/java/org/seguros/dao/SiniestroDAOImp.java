package org.seguros.dao;

import org.seguros.dto.Siniestro;
import org.seguros.exception.DaoException;
import org.seguros.mapper.SiniestroMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class SiniestroDAOImp implements SiniestroDAO {
    private JdbcTemplate jdbcTemplate;
    public SiniestroDAOImp(DataSource dataSource) {

        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public void insert(Siniestro siniestro) throws DaoException {
        String INSERT = "INSERT INTO public.siniestro(\n" +
                "\t tipo_siniestro, f_siniestro, lugar, nmid_tomador)\n" +
                "\tVALUES (?, ?, ?, ?)";
        jdbcTemplate.update(INSERT,
                siniestro.getTipo_siniestro(),
                siniestro.getF_siniestro(),
                siniestro.getLugar(),
                siniestro.getTomador().getNmid());
    }
    public void update(Siniestro siniestro) throws DaoException {
        String UPDATE = "UPDATE public.siniestro\n" +
                "\tSET  tipo_siniestro=?, f_siniestro=?, lugar=?, nmid_tomador=? \n" +
                "\tWHERE nmid=?;";
        jdbcTemplate.update(UPDATE,
                siniestro.getTipo_siniestro(),
                siniestro.getF_siniestro(),
                siniestro.getLugar(),
                siniestro.getTomador().getNmid(),
                siniestro.getNmid()
               );
    }
    public void delete(int nmid) throws DaoException {
        String DELETE = "DELETE FROM siniestro WHERE nmid = ?";
        try {
            jdbcTemplate.update(DELETE, nmid);
        }catch (Exception e) {
            throw new DaoException(e);
        }
    }
    public Siniestro getById(int nmid) throws DaoException {
        String SELECTBYID = "SELECT \n" +
                "s.nmid, \n" +
                "s.tipo_siniestro, \n" +
                "s.f_siniestro, \n" +
                "s.lugar, \n" +
                "s.nmid_tomador \n" +
                "FROM public.siniestro s WHERE s.nmid = ? ";
        Siniestro siniestro = null;
        try {
            siniestro = jdbcTemplate.queryForObject(SELECTBYID, new Object[]{nmid}, new SiniestroMapper());
        }catch(DataAccessException ex){

        }
        return siniestro;
    }
    public List<Map<String, Object>> getAll() throws DaoException {
        String SELECT = "SELECT \n" +
                "s.nmid, \n" +
                "s.tipo_siniestro, \n" +
                "s.f_siniestro, \n" +
                "s.lugar,\n" +
                "t.nmid as nmid_tomador,\n" +
                "t.documento,\n" +
                "t.tipo_doc,\n" +
                "t.nombre,\n" +
                "t.apellido,\n" +
                "t.direccion,\n" +
                "t.telefono,\n" +
                "t.ocupacion,\n" +
                "t.correo,\n" +
                "t.f_naci\n" +
                "FROM siniestro s inner join tomador t on s.nmid_tomador = t.nmid ORDER BY s.nmid DESC";
        List<Map<String,Object>> listSiniestro;
        try {
            listSiniestro = jdbcTemplate.queryForList(SELECT);

        } catch (Exception e) {
            throw new DaoException(e);
        }
        return listSiniestro;
    }
}
