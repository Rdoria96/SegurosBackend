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
        String SELECTBYID = "SELECT tipo_siniestro,\n" +
                "\t f_siniestro, \n" +
                "\t lugar,\n" +
                "\t nmid_tomador\n"+
                "FROM public.siniestro \n" +
                "\t WHERE nmid = ?";
        Siniestro siniestro = null;
        try {
            siniestro = jdbcTemplate.queryForObject(SELECTBYID, new Object[]{nmid}, new SiniestroMapper());
        }catch(DataAccessException ex){

        }
        return siniestro;
    }
    public List<Map<String, Object>> getAll() throws DaoException {
        String SELECT = "SELECT \n" +
                "\tS.nmid, \n" +
                "\tS.tipo_siniestro,\n" +
                "\tS.f_siniestro, \n" +
                "\tS.lugar,\n" +
                "\tT.nmid AS id_tomador,\n" +
                "    \tT.documento,\n" +
                "    \tT.tipo_doc,\n" +
                "    \tT.nombre,\n" +
                "    \tT.apellido,\n" +
                "    \tT.direccion,\n" +
                "    \tT.telefono,\n" +
                "    \tT.ocupacion,\n" +
                "    \tT.correo,\n" +
                "    \tT.f_naci\n" +
                "FROM siniestro S\n" +
                "    INNER JOIN tomador T\n" +
                "    ON S.nmid_tomador = T.nmid;";
        List<Map<String,Object>> listSiniestro;
        try {
            listSiniestro = jdbcTemplate.queryForList(SELECT);

        } catch (Exception e) {
            throw new DaoException(e);
        }
        return listSiniestro;
    }
}
