package org.seguros.controller;

import jakarta.validation.Valid;
import org.seguros.business.ReaseguradoraBUS;
import org.seguros.business.TomadorBUS;
import org.seguros.dto.Reaseguradora;
import org.seguros.dto.Tomador;
import org.seguros.exception.BusException;
import org.seguros.msg.Mensajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


public class ReaseguradoraCTRL {



    private ReaseguradoraBUS reaseguradoraBUS;

    public ReaseguradoraCTRL(ReaseguradoraBUS reaseguradoraBUS) {
        this.reaseguradoraBUS = reaseguradoraBUS;
    }

    @CrossOrigin(origins = "http://localhost/80")
    @PostMapping("/reaseguradora/createreaseguradora")
    public ResponseEntity<Mensajes> create(@Valid @RequestBody Reaseguradora reaseguradora) throws  RuntimeException {
        Mensajes mensajes = new Mensajes();
        try{
            reaseguradoraBUS.createReaseguradora(reaseguradora);
            mensajes.setCode("0");
            mensajes.setMensaje("Reaseguradora registrada con éxito");
        }catch (BusException ex){
            mensajes.setCode("1");
            mensajes.setMensaje("fallo "+ex.getMessage());
            throw new RuntimeException(ex);
        }
        return ResponseEntity.ok( mensajes);
    }

    @CrossOrigin(origins = "http://localhost/80")
    @GetMapping("/reaseguradora/mostrarreaseguradora")
    public ResponseEntity<Mensajes> getReaseguradora() throws RuntimeException {
        Mensajes mensajes = new Mensajes();
        List<Map<String,Object>> reaseguradora;
        try {
            reaseguradora = reaseguradoraBUS.mostrarReaseguradoras();
            mensajes.setCode("0");
            mensajes.setMensaje("Se mostro la reaseguradora con exito");
            mensajes.setDato(reaseguradora);

        }catch (BusException ex) {
            mensajes.setCode("1");
            mensajes.setMensaje("fallo " + ex.getMessage());
            throw new RuntimeException(ex);
        }
        return ResponseEntity.ok(mensajes);
    }

    @DeleteMapping("/tomador/deletetomador/{nmid}")
    public ResponseEntity<Mensajes> delete(@Valid  @PathVariable int nmid) throws RuntimeException {
        Mensajes mensajes = new Mensajes();
        try {
            reaseguradoraBUS.eleiminarReaseguradora(nmid);
            mensajes.setCode("0");
            mensajes.setMensaje("Reaseguradora eleiminada con exito");
        }catch (BusException e){
            mensajes.setCode("1");
            mensajes.setMensaje("fallo " + e.getMessage());
        }
        return ResponseEntity.ok(mensajes);
    }

}
