package org.seguros.manager;

import org.seguros.dto.Siniestro;
import org.seguros.dto.Tomador;
import org.seguros.exception.MgrException;

import java.util.List;
import java.util.Map;

public interface SiniestroMGR {
    void saveOrInsert(Siniestro sin) throws MgrException;

    void delete(int nmid) throws  MgrException;

    List<Map<String,Object>> getAll() throws  MgrException;
}
