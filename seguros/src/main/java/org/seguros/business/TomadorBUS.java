package org.seguros.business;

import org.seguros.dto.Tomador;
import org.seguros.exception.BusException;

import java.util.List;
import java.util.Map;

public interface TomadorBUS {

    void createTomador(Tomador tom) throws BusException;

    void eleiminarTomador(int nmid) throws BusException;

    List<Map<String,Object>> mostrarTomadores() throws BusException;


}
