package org.seguros.mapper;

import org.seguros.dto.Siniestro;
import org.seguros.dto.Tomador;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SiniestroMapper implements RowMapper<Siniestro> {
    @Override
    public Siniestro mapRow(ResultSet rs, int rowNum) throws SQLException {
        Siniestro resultsin = new Siniestro();
        resultsin.setTipo_siniestro(rs.getString("tipo_siniestro"));
        resultsin.setF_siniestro(rs.getDate("f_siniestro"));
        resultsin.setLugar(rs.getString("lugar"));
        Tomador obj = new Tomador();
        obj.setNmid(rs.getInt("nmid_tomador"));
        resultsin.setTomador(obj);


        return resultsin;
    }
}
