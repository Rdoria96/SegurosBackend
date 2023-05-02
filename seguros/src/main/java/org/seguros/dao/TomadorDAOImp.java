package org.seguros.dao;

import org.seguros.mapper.TomadorMapper;
import org.seguros.dto.Tomador;
import org.seguros.exception.DaoException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class TomadorDAOImp implements TomadorDAO{


    private JdbcTemplate jdbcTemplate;

    public TomadorDAOImp(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(Tomador tomador) throws DaoException {
        String insert = "INSERT INTO tomador (documento, tipo_doc, nombre, apellido, direccion, telefono, ocupacion, correo, f_naci) VALUES (?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(insert,
                tomador.getDocumento(),
                tomador.getTipo_doc(),
                tomador.getNombre(),
                tomador.getApellido(),
                tomador.getDireccion(),
                tomador.getTelefono(),
                tomador.getOcupacion(),
                tomador.getCorreo(),
                tomador.getF_naci());
    }

    public void update(Tomador tomador) throws DaoException {
        String update = "UPDATE tomador SET documento=?, tipo_doc=?, nombre=?, apellido=?, direccion=?,telefono=?, ocupacion=?, correo=?, f_naci=? WHERE nmid=?";
        jdbcTemplate.update(update,
                tomador.getDocumento(),
                tomador.getTipo_doc(),
                tomador.getNombre(),
                tomador.getApellido(),
                tomador.getDireccion(),
                tomador.getTelefono(),
                tomador.getOcupacion(),
                tomador.getCorreo(),
                tomador.getF_naci(),
                tomador.getNmid());
    }

    public void delete(int nmid) throws DaoException {
        String delete = "DELETE FROM tomador WHERE nmid = ?";
        try {
            jdbcTemplate.update(delete,nmid);
        }catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Tomador getById(int nmid) throws DaoException {
        String selectById = "SELECT documento, tipo_doc, nombre, apellido, direccion, telefono, ocupacion, correo, f_naci FROM tomador WHERE nmid = ?";
        Tomador tomador = null;
        try {
            tomador = jdbcTemplate.queryForObject(selectById, new Object[]{nmid}, new TomadorMapper());
        }catch(EmptyResultDataAccessException ex){

        }
        return tomador;
    }

    public List<Map<String, Object>> getAll() throws DaoException {
        String select = "SELECT nmid, documento, tipo_doc, nombre, apellido, direccion, telefono, ocupacion, correo, f_naci FROM tomador";
        List<Map<String,Object>> listTomador;
        try {
            listTomador = jdbcTemplate.queryForList(select);

        } catch (Exception e) {
            throw new DaoException(e);
        }
        return listTomador;
    }
}
