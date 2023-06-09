package org.seguros.manager;

import org.seguros.dto.Beneficiario;
import org.seguros.exception.MgrException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Component
@Service
public interface BeneficiarioMGR {
    public void save_update(Beneficiario beneficiario) throws MgrException;
    public void delete(int nmid) throws MgrException;
    public List<Map<String,Object>> getAll() throws MgrException;
}

