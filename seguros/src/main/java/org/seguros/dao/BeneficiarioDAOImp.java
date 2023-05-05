package org.seguros.dao;

import org.seguros.dto.Beneficiario;
import org.seguros.dto.Tomador;
import org.seguros.mapper.BeneficiarioMapper;
import org.seguros.mapper.TomadorMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.seguros.exception.DaoException;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.time.chrono.JapaneseDate;
import java.util.List;
import java.util.Map;


@Repository
public class BeneficiarioDAOImp implements BeneficiarioDAO{
    private JdbcTemplate jdbcTemplate;

    public BeneficiarioDAOImp(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }



    public void insert(Beneficiario ben) throws DaoException {
       String insert = "INSERT INTO public.beneficiario( tipo_doc,documento, nombre, apellido, f_naci, parentezco,ocupacion,direccion, telefono, correo, porcentaje_afi,nombre_banco, numero_cuenta,nmid_tomador  ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?)";
        Tomador tom = new Tomador();
       jdbcTemplate.update(insert,
                ben.getTipo_doc(),
                ben.getDocumento(),
                ben.getNombre(),
                ben.getApellido(),
                ben.getF_naci(),
                ben.getParentezco(),
                ben.getOcupacion(),
                ben.getDireccion(),
                ben.getTelefono(),
                ben.getCorreo(),
                ben.getPorcentaje_afi(),
                ben.getNombre_banco(),
                ben.getNumero_cuenta(),
                ben.getTomador().getNmid());

    }
    public void update(Beneficiario beneficiario) throws DaoException {
            String Update = "UPDATE public.beneficiario SET  tipo_doc=?,documento=?, nombre=?, apellido=?, f_naci=?, parentezco=?,ocupacion=?,direccion=?, telefono=?, correo=?, porcentaje_afi=?,nombre_banco=?, numero_cuenta=?,nmid_tomador=? WHERE nmid=?";
            Tomador tom = new Tomador();
            jdbcTemplate.update(Update,
            beneficiario.getTipo_doc(),
            beneficiario.getDocumento(),
            beneficiario.getNombre(),
            beneficiario.getApellido(),
            beneficiario.getF_naci(),
            beneficiario.getParentezco(),
            beneficiario.getOcupacion(),
            beneficiario.getDireccion(),
            beneficiario.getTelefono(),
            beneficiario.getCorreo(),
            beneficiario.getPorcentaje_afi(),
            beneficiario.getNombre_banco(),
            beneficiario.getNumero_cuenta(),
            beneficiario.getTomador().getNmid(),
            beneficiario.getNmid());

    }
    public Beneficiario getById(int nmid) throws DaoException {
        Beneficiario beneficiario = null;
        String SELECTBYID = "SELECT nmid, \n" +
                " tipo_doc,\n" +
                "\t documento,\n" +
                "\t nombre,\n" +
                "\t apellido,\n" +
                "\t f_naci,\n" +
                "\t parentezco,\n" +
                "\t ocupacion,\n" +
                "\t direccion,\n" +
                "\t telefono,\n" +
                "\t correo,\n" +
                "\t porcentaje_afi,\n" +
                "\t nombre_banco,\n" +
                "\t numero_cuenta,\n" +
                "\t nmid_tomador\n" +
                " FROM beneficiario  \n" +
                "WHERE nmid=? \t";
        try {
            beneficiario = jdbcTemplate.queryForObject(SELECTBYID, new Object[]{nmid}, new BeneficiarioMapper());


        } catch (DataAccessException ex) {

        }
        return beneficiario;
    }

        public void delete(int nmid) throws DaoException {
            String delete = "DELETE FROM beneficiario WHERE nmid = ?";
            try {
                jdbcTemplate.update(delete,nmid);
            }catch (Exception e) {
                throw new DaoException(e);
            }
        }

    public List<Map<String, Object>> getAll() throws DaoException {
        String select = "SELECT A.nmid, \n" +
                " A.tipo_doc,\n" +
                "\t A.documento,\n" +
                "\t A.nombre,\n" +
                "\t A.apellido,\n" +
                "\t A.f_naci,\n" +
                "\t A.parentezco,\n" +
                "\t A.ocupacion,\n" +
                "\t A.direccion,\n" +
                "\t A.telefono,\n" +
                "\t A.correo,\n" +
                "\t A.porcentaje_afi,\n" +
                "\t A.nombre_banco,\n" +
                "\t A.numero_cuenta,\n" +
                "\t A.nmid_tomador,\n" +
                "\t B.nmid AS idtomador,\n" +
                "\t B.documento AS documento_tom,\n" +
                "\t B.tipo_doc AS tipo_doc_tom,\n" +
                "\t B.nombre AS nombre_tom,\n" +
                "\t B.apellido AS apellido_tom,\n" +
                "\t B.direccion AS direccion_tom,\n" +
                "\t B.telefono AS telefono_tom,\n" +
                "\t B.ocupacion AS ocupacion_tom,\n" +
                "\t B.correo AS correo_tom,\n" +
                "\t B.f_naci AS f_naci_tom\n" +
                " FROM beneficiario A \n" +
                "INNER JOIN \n" +
                " tomador B ON A.nmid_tomador=B.nmid \n";
        List<Map<String,Object>> listbeneficiario;
        try {
            listbeneficiario = jdbcTemplate.queryForList(select);

        } catch (Exception e) {
            throw new DaoException(e);
        }
        return listbeneficiario;
    }
}


