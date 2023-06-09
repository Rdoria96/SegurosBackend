package org.seguros.mapper;

import org.seguros.business.BeneficiarioBUS;
import org.seguros.dto.Beneficiario;
import org.seguros.dto.Tomador;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BeneficiarioMapper implements RowMapper<Beneficiario> {
    @Override
    public Beneficiario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Tomador tom = new Tomador();
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setTipo_doc(rs.getString("tipo_doc"));
        beneficiario.setDocumento(rs.getString("documento"));
        beneficiario.setNombre(rs.getString("nombre"));
        beneficiario.setApellido(rs.getString("apellido"));
        beneficiario.setF_naci(rs.getDate("f_naci"));
        beneficiario.setParentezco(rs.getString("parentezco"));
        beneficiario.setOcupacion(rs.getString("ocupacion"));
        beneficiario.setDireccion(rs.getString("direccion"));
        beneficiario.setTelefono(rs.getString("telefono"));
        beneficiario.setCorreo(rs.getString("correo"));
        beneficiario.setPorcentaje_afi(rs.getDouble("porcentaje_afi"));
        beneficiario.setNombre_banco(rs.getString("nombre_banco"));
        beneficiario.setNumero_cuenta(rs.getString("numero_cuenta"));
        tom.setNmid(rs.getInt("nmid_tomador"));
        beneficiario.setTomador(tom);
        return beneficiario;
    }
}

