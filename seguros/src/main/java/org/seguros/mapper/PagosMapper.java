package org.seguros.mapper;

import org.seguros.dao.PagosDAO;
import org.seguros.dto.Pagos;
import org.seguros.dto.Seguro;
import org.seguros.dto.Tomador;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PagosMapper implements RowMapper<Pagos> {
    @Override
    public Pagos mapRow(ResultSet rs, int rowNum) throws SQLException {
        Pagos resulpago = new Pagos();
        Seguro seguro = new Seguro();
        resulpago.setF_pago(rs.getDate("f_pago"));
        resulpago.setCuotas(rs.getInt("cuotas"));
        resulpago.setValor_cmes(rs.getDouble("valor_cmes"));
        seguro.setNmid(rs.getInt("nmid_seguro"));
        resulpago.setSeguro(seguro);
        return resulpago;
    }
}
