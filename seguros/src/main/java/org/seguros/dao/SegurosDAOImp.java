package org.seguros.dao;

import org.seguros.dto.Seguro;
import org.seguros.exception.DaoException;
import org.seguros.mapper.SegurosMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SegurosDAOImp implements SegurosDAO{

    private JdbcTemplate jdbcTemplate;

    public SegurosDAOImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

     private static  final String INSERT = "INSERT INTO public.seguro(\n" +
             "\t tipo_seguro, valor, descripcion, f_inicial, f_final, nmid_tomador, nmid_reaseguradora)\n" +
             "\tVALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final  String UPDATE = "UPDATE public.seguro\n" +
            "\tSET tipo_seguro=?, valor=?, descripcion=?, f_inicial=?, f_final=?, nmid_tomador=?, nmid_reaseguradora=?\n" +
            "\tWHERE nmid=?";

    private static final String DELETE = "DELETE FROM public.seguro WHERE nmid=?";

    private  static  final  String SELECTBYID = "SELECT nmid, tipo_seguro, valor, descripcion, f_inicial, f_final, nmid_tomador, nmid_reaseguradora\n" +
            "\tFROM public.seguro WHERE nmid=?";

    private static  final  String SELECT = "SELECT s.nmid,s.tipo_seguro, s.valor, s.descripcion,\n" +
            "            s.f_inicial,s.f_final, t.documento, r.razon_social \n" +
            "            FROM seguro s INNER JOIN tomador t ON  s.nmid_tomador = t.nmid\n" +
            "            INNER JOIN reaseguradora r ON s.nmid_reaseguradora = r.nmid ORDER BY nmid ASC";


    public void insert(Seguro seguro) throws DaoException{
        jdbcTemplate.update(INSERT,
                seguro.getTipo_seguro(),
                seguro.getValor(),
                seguro.getDescripcion(),
                seguro.getF_inicial(),
                seguro.getF_final(),
                seguro.getTomador().getNmid(),
                seguro.getReaseguradora().getNmid());
    }

    public void update(Seguro seguro) throws DaoException{
        jdbcTemplate.update(UPDATE,
                seguro.getTipo_seguro(),
                seguro.getValor(),
                seguro.getDescripcion(),
                seguro.getF_inicial(),
                seguro.getF_final(),
                seguro.getTomador().getNmid(),
                seguro.getReaseguradora().getNmid(),
                seguro.getNmid());
    }

    public void delete(int nmid) throws DaoException{
        try {
            jdbcTemplate.update(DELETE,nmid);
        }catch (Exception ex){
            throw  new DaoException(ex);
        }
    }

    public Seguro getById(int nmid) throws DaoException{
        Seguro seguro = null;
        try {
           seguro = jdbcTemplate.queryForObject(SELECTBYID, new Object[]{nmid},new SegurosMapper());
        }catch (DataAccessException ex){

        }
        return seguro;
    }

    public List<Map<String, Object>> getAll() throws DaoException {
        List<Map<String,Object>> listSeguro;
        try {
            listSeguro = jdbcTemplate.queryForList(SELECT);
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return listSeguro;
    }

}
