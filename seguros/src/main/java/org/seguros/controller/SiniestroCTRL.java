package org.seguros.controller;

import jakarta.validation.Valid;
import org.seguros.business.SiniestroBUS;
import org.seguros.dto.Siniestro;
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

@RestController
@Transactional
@Service
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost/80")
public class SiniestroCTRL {
    @Autowired
    private SiniestroBUS siniestroBUS;
    public SiniestroCTRL(SiniestroBUS siniestroBUS){
        this.siniestroBUS = siniestroBUS;

    }
    @CrossOrigin(origins = "http://localhost/80")
    @PostMapping("/siniestro/createsiniestro")
    public ResponseEntity<Mensajes> create(@Valid @RequestBody Siniestro siniestro) throws  RuntimeException {
        Mensajes mensajes = new Mensajes();
        try{
            siniestroBUS.createSiniestro(siniestro);
            mensajes.setCode("0");
            mensajes.setMensaje("se creo el siniestro con éxito");
        }catch (BusException ex){
            mensajes.setCode("1");
            mensajes.setMensaje("fallo "+ex.getMessage());
            throw new RuntimeException(ex);
        }
        return ResponseEntity.ok( mensajes);
    }

    @CrossOrigin(origins = "http://localhost/80")
    @GetMapping("/siniestro/siniestros")
    public ResponseEntity<Mensajes> getSiniestros() throws RuntimeException {
        Mensajes mensajes = new Mensajes();
        List<Map<String,Object>> siniestro;
        try {
            siniestro = siniestroBUS.mostrarSiniestros();
            mensajes.setCode("0");
            mensajes.setMensaje("Listado de siniestros...");
            mensajes.setDato(siniestro);

        }catch (BusException ex) {
            mensajes.setCode("1");
            mensajes.setMensaje("fallo " + ex.getMessage());
            throw new RuntimeException(ex);
        }
        return ResponseEntity.ok(mensajes);
    }

    @DeleteMapping("/siniestro/deletesiniestro/{nmid}")
    public ResponseEntity<Mensajes> delete(@Valid  @PathVariable int nmid) throws RuntimeException {
        Mensajes mensajes = new Mensajes();
        try {
            siniestroBUS.eleiminarSiniestros(nmid);
            mensajes.setCode("0");
            mensajes.setMensaje("Siniestro eliminado exitosamente!");
        }catch (BusException e){
            mensajes.setCode("1");
            mensajes.setMensaje("fallo " + e.getMessage());
        }
        return ResponseEntity.ok(mensajes);
    }

}
