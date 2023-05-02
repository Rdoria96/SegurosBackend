package org.seguros.mapper;

import org.seguros.dto.Tomador;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TomadorMapper implements RowMapper<Tomador> {
    @Override
    public Tomador mapRow(ResultSet rs, int rowNum) throws SQLException {
        Tomador resulttom = new Tomador();
        resulttom.setDocumento(rs.getString("documento"));
        resulttom.setTipo_doc(rs.getString("tipo_doc"));
        resulttom.setNombre(rs.getString("nombre"));
        resulttom.setApellido(rs.getString("apellido"));
        resulttom.setDireccion(rs.getString("direccion"));
        resulttom.setTelefono(rs.getString("telefono"));
        resulttom.setCorreo(rs.getString("correo"));
        resulttom.setF_naci(rs.getDate("f_naci"));

        return resulttom;
    }
}
