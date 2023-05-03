package org.seguros.business;

import org.seguros.dto.Seguro;
import org.seguros.exception.BusException;

import java.util.List;
import java.util.Map;

public interface SegurosBUS {

    public void  crearSeguro(Seguro seguro) throws BusException;

    public void EliminarSeguro(int nmid) throws BusException;

    public List<Map<String,Object>> mostrarSeguros() throws BusException;
}
