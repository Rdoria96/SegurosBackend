package org.seguros.manager;

import org.seguros.dto.Reaseguradora;
import org.seguros.exception.MgrException;

import java.util.List;
import java.util.Map;

public interface ReaseguradoraMGR {

    void saveOrInsert(Reaseguradora reaseguradora) throws MgrException;

    void delete(int nmid) throws  MgrException;

    List<Map<String,Object>> getAll() throws  MgrException;


}
