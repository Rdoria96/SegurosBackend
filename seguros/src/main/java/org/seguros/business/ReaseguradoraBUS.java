package org.seguros.business;

import org.seguros.dto.Reaseguradora;
import org.seguros.exception.BusException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface ReaseguradoraBUS {


    void createReaseguradora(Reaseguradora rea) throws BusException;

    void eleiminarReaseguradora(int nmid) throws BusException;

    List<Map<String,Object>> mostrarReaseguradoras() throws BusException;
}
