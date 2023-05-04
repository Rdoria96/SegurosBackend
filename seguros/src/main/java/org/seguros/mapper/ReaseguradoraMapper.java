package org.seguros.mapper;

import org.seguros.dto.Reaseguradora;
import org.seguros.dto.Tomador;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReaseguradoraMapper  implements RowMapper<Reaseguradora> {

    public Reaseguradora mapRow(ResultSet rs, int rowNum) throws SQLException {
        Reaseguradora resultrea = new Reaseguradora();
        resultrea.setNit(rs.getString("nit"));
        resultrea.setRazon_social(rs.getString("razon_social"));
        resultrea.setMonto_seguro(rs.getDouble("monto_seguro"));
        resultrea.setPorcentaje_cober(rs.getDouble("porcentaje_cober"));

        return resultrea;
    }
}
