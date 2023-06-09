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
public interface BeneficiarioBUS {
    public void createBeneficiario(Beneficiario ben) throws BusException;
    public void eleiminarBeneficiario(int nmid) throws BusException;
    public List<Map<String,Object>> mostrarBeneficiarios() throws BusException;

}
