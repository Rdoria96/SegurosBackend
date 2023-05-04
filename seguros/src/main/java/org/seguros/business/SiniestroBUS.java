package org.seguros.business;

import org.seguros.dto.Siniestro;
import org.seguros.dto.Tomador;
import org.seguros.exception.BusException;

import java.util.List;
import java.util.Map;

public interface SiniestroBUS {
    void createSiniestro(Siniestro sin) throws BusException;

    void eleiminarSiniestros(int nmid) throws BusException;

    List<Map<String,Object>> mostrarSiniestros() throws BusException;
}
