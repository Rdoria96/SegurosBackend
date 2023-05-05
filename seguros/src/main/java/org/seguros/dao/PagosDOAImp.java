package org.seguros.dao;

import org.seguros.exception.DaoException;
import org.seguros.mapper.PagosMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Repository
public class PagosDOAImp implements PagosDAO{

    private JdbcTemplate jdbcTemplate;

    public PagosDOAImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void generarPagos(int nmid, Date fecha) throws DaoException {
        String sql = "call proc_liquidacion_seguro(?,?)";
        try {
            jdbcTemplate.update(sql, nmid, fecha);
        }catch (Exception e){
            throw new DaoException(e);
        }
    }

    public List<Map<String, Object>> gellApp() throws DaoException {
        String select = "SELECT CONCAT(T.tipo_doc,' - ',T.documento) AS documento,\n" +
                "CONCAT(T.nombre,' ',T.apellido) AS nombretom,\n" +
                "P.nmid, P.f_pago, P.cuotas, P.valor_cmes, P.nmid_seguro \n" +
                "FROM pagos P\n" +
                "INNER JOIN seguro S \n" +
                "ON P.nmid_seguro = S.nmid\n" +
                "INNER JOIN tomador T\n" +
                "ON S.nmid_tomador = T.nmid\n" +
                "ORDER BY P.nmid DESC";
        List<Map<String,Object>> listPagos;
        try{
            listPagos = jdbcTemplate.queryForList(select);
        }catch (Exception e){
            throw new DaoException(e);
        }
        return listPagos;
    }

    public int getPagosByDoc(String documento, Date fecha) throws DaoException {
        String sql = "SELECT 1 as resultado FROM pagos P INNER JOIN seguro S ON P.nmid_seguro = S.nmid INNER JOIN tomador T ON S.nmid_tomador = T.nmid WHERE T.documento ='1234568' AND P.f_pago ='2023-05-04' LIMIT 1";
        int pagos = 0;
        try {;
            System.out.println("astes "+pagos);
            pagos = jdbcTemplate.queryForObject(sql, new Object[]{documento,fecha}, Integer.class);
            System.out.println("despues "+pagos);
            System.out.println("pago "+jdbcTemplate.queryForObject(sql, new Object[]{fecha,documento}, Integer.class));

        }catch (DataAccessException ex) {

        }catch (Exception e){
            throw new DaoException(e);
        }
        return pagos;
    }

    public int getIdTomador(String documento) throws DaoException {
        String sql = "SELECT T.nmid FROM tomador T WHERE T.documento = ?";
        int idTomador = 0;
        try {
            idTomador = jdbcTemplate.queryForObject(sql, new Object[]{documento}, Integer.class);
        }catch (DataAccessException ex) {

        }catch (Exception e){
            throw new DaoException(e);
        }
        return idTomador;
    }

    public List<Map<String, Object>> getByYearMont(int año, int mes, String documento) throws DaoException {
        String sql = "SELECT P.f_pago, P.cuotas, P.valor_cmes, P.nmid_seguro, T.nmid \n" +
                "FROM pagos \n" +
                "P INNER JOIN seguro S \n" +
                "ON P.nmid_seguro = S.nmid \n" +
                "INNER JOIN tomador T \n" +
                "ON S.nmid_tomador = T.nmid \n" +
                "WHERE EXTRACT(YEAR FROM P.f_pago) = ? \n" +
                "AND EXTRACT(MONTH FROM P.f_pago) = ? \n" +
                "AND T.documento = ?;";
        List<Map<String, Object>> lista = null;
        try {
            Object[] params = new Object[] {año, mes, documento};
            lista = jdbcTemplate.queryForList(sql,params);
        }catch (DataAccessException ex) {

        }catch (Exception e){
            e.printStackTrace();
            throw new DaoException(e);
        }
        return lista;
    }

}
