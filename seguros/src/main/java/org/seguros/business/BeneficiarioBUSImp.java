package org.seguros.business;

import org.seguros.dto.Beneficiario;
import org.seguros.dto.Tomador;
import org.seguros.exception.BusException;
import org.seguros.exception.MgrException;
import org.seguros.manager.BeneficiarioMGR;
import org.seguros.manager.TomadorMGR;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BeneficiarioBUSImp implements BeneficiarioBUS {
    private BeneficiarioMGR beneficiarioMGR;

    public BeneficiarioBUSImp(BeneficiarioMGR beneficiarioMGR) {
        this.beneficiarioMGR = beneficiarioMGR;
    }

    public void createBeneficiaripackage org.seguros.business;

import org.seguros.dto.Beneficiario;
import org.seguros.dto.Tomador;
import org.seguros.exception.BusException;
import org.seguros.exception.MgrException;
import org.seguros.manager.BeneficiarioMGR;
import org.seguros.manager.TomadorMGR;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BeneficiarioBUSImp implements BeneficiarioBUS {
    private BeneficiarioMGR beneficiarioMGR;

    public BeneficiarioBUSImp(BeneficiarioMGR beneficiarioMGR) {
        this.beneficiarioMGR = beneficiarioMGR;
    }

    public void createBeneficiario(Beneficiario ben) throws BusException {

        try {
            beneficiarioMGR.save_update(ben);
        } catch (MgrException e) {
            throw new BusException(e);
        }catch (Exception ex) {
            throw new BusException(ex);
        }
    }

    public void eleiminarBeneficiario(int nmid) throws BusException {

        try {
            beneficiarioMGR.delete(nmid);
        } catch (MgrException e) {
            throw new BusException(e);
        }catch (Exception ex) {
            throw new BusException(ex);
        }
    }

    public List<Map<String,Object>> mostrarBeneficiarios() throws BusException {
        List<Map<String,Object>> beneficiadores;

        try {
            beneficiadores = beneficiarioMGR.getAll();
        } catch (MgrException e) {
            throw new BusException(e);
        }catch (Exception ex) {
            throw new BusException(ex);
        }
        return beneficiadores;
    }
}

