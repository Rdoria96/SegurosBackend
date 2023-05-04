package org.seguros.manager;

import org.seguros.dao.BeneficiarioDAO;
import org.seguros.dto.Beneficiario;
import org.seguros.exception.DaoException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.seguros.exception.MgrException;
import java.util.List;
import java.util.Map;
@Component
@Service
public class BeneficiarioMGRImp implements BeneficiarioMGR {
    private BeneficiarioDAO beneficiarioDAO;

    private BeneficiarioMGRImp(BeneficiarioDAO package org.seguros.manager;

import org.seguros.dao.BeneficiarioDAO;
import org.seguros.dto.Beneficiario;
import org.seguros.exception.DaoException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.seguros.exception.MgrException;
import java.util.List;
import java.util.Map;
@Component
@Service
public class BeneficiarioMGRImp implements BeneficiarioMGR {
    private BeneficiarioDAO beneficiarioDAO;

    private BeneficiarioMGRImp(BeneficiarioDAO beneficiarioDAO){
        this.beneficiarioDAO=beneficiarioDAO;
    }

    public void save_update(Beneficiario ben) throws MgrException {
            try {
            Beneficiario   beneficiario = beneficiarioDAO.getById(ben.getNmid());
            if (beneficiario == null) {
                beneficiarioDAO.insert(ben);
            } else {
                beneficiarioDAO.update(ben);
            }
        } catch (DaoException ex) {
            throw new MgrException(ex);
        }
    }


    public void delete(int nmid) throws MgrException{
        try {
           Beneficiario beneficiario = beneficiarioDAO.getById(nmid);
            if(beneficiario == null){
                System.out.println("Error, no encuentra el id");
            }else {
                beneficiarioDAO.delete(nmid);
            }
        }catch (DaoException ex){
            throw new MgrException(ex);
        } catch (Exception ex){
            throw new MgrException(ex);
        }
    }

    public List<Map<String,Object>> getAll() throws MgrException {
        List<Map<String,Object>> t ;
        try{
            t= beneficiarioDAO.getAll();
        }catch (DaoException ex){
            throw new MgrException(ex);

        }
        return t;
    }
}
