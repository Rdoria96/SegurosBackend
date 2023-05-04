package org.seguros.mapper;
import org.seguros.dto.Reaseguradora;
import org.seguros.dto.Seguro;
import org.seguros.dto.Tomador;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SegurosMapper implements RowMapper<Seguro> {
    @Override
    public Seguro mapRow(ResultSet rs, int rowNum) throws SQLException {

        Seguro seguro = new Seguro();
        Tomador tomador = new Tomador();
        Reaseguradora reaseguradora = new Reaseguradora();
        seguro.setTipo_seguro(rs.getString("tipo_seguro"));
        seguro.setValor(rs.getDouble("valor"));
        seguro.setDescripcion(rs.getString("descripcion"));
        seguro.setF_inicial(rs.getDate("f_inicial"));
        seguro.setF_final(rs.getDate("f_final"));
        tomador.setNmid(rs.getInt("nmid_tomador"));
        seguro.settomador(tomador);
        reaseguradora.setNmid(rs.getInt("nmid_reaseguradora"));
        seguro.setreaseguradora(reaseguradora);
        return seguro;
    }
}
