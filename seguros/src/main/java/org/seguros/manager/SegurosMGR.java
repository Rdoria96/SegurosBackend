package org.seguros.manager;

import org.seguros.dto.Seguro;
import org.seguros.exception.MgrException;
import java.util.List;
import java.util.Map;

public interface SegurosMGR {
    public void saveUpdate(Seguro seguro) throws MgrException;
    public void delete(int nmid)throws MgrException;
    public List<Map<String,Object>> getAll() throws  MgrException;
}
