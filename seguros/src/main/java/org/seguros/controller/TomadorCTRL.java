package org.seguros.controller;

import jakarta.validation.Valid;
import org.seguros.business.TomadorBUS;
import org.seguros.dto.Tomador;
import org.seguros.business.TomadorBUSImp;
import org.seguros.exception.BusException;
import org.seguros.msg.Mensajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Transactional
@Service
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost/80")
public class TomadorCTRL {

    @Autowired
    private TomadorBUS tomadorBus;

    public TomadorCTRL(TomadorBUS tomadorBus) {
        this.tomadorBus = tomadorBus;
    }

    @CrossOrigin(origins = "http://localhost/80")
    @PostMapping("/tomador/createtomador")
    public ResponseEntity<Mensajes> create(@Valid @RequestBody Tomador tomador) throws  RuntimeException {
        Mensajes mensajes = new Mensajes();
        try{
            tomadorBus.createTomador(tomador);
            mensajes.setCode("0");
            mensajes.setMensaje("se creo el dato con éxito");
        }catch (BusException ex){
            mensajes.setCode("1");
            mensajes.setMensaje("fallo "+ex.getMessage());
            throw new RuntimeException(ex);
        }
        return ResponseEntity.ok( mensajes);
    }

    @CrossOrigin(origins = "http://localhost/80")
    @GetMapping("/tomador/mostrartomador")
    public ResponseEntity<Mensajes> getTomador() throws RuntimeException {
        Mensajes mensajes = new Mensajes();
        List<Map<String,Object>> tomador;
        try {
            tomador = tomadorBus.mostrarTomadores();
            mensajes.setCode("0");
            mensajes.setMensaje("se creo el dato con éxito");
            mensajes.setDato(tomador);

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
            tomadorBus.eleiminarTomador(nmid);
            mensajes.setCode("0");
            mensajes.setMensaje("Tomador eleiminado");
        }catch (BusException e){
            mensajes.setCode("1");
            mensajes.setMensaje("fallo " + e.getMessage());
        }
        return ResponseEntity.ok(mensajes);
    }

}
