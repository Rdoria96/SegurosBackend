package org.seguros.controller;

import jakarta.validation.Valid;
import org.seguros.business.PagosBUS;
import org.seguros.exception.BusException;
import org.seguros.msg.Mensajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;


@RestController
@Transactional
@Service
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost/80")
public class PagosCTRL {

    @Autowired
    private PagosBUS pagosBUS;

    public PagosCTRL(PagosBUS pagosBUS) {
        this.pagosBUS = pagosBUS;
    }

    @CrossOrigin(origins = "http://localhost/80")
    @PostMapping("/pagos/generate/{nmid},{fecha}")
    public ResponseEntity<Mensajes> generate(@Valid @PathVariable int nmid, Date fecha) throws  RuntimeException{
        Mensajes mensajes = new Mensajes();
        PagosBUS pagos;
        try {
            pagosBUS.generatePagos(nmid,fecha);
            mensajes.setCode("0");
            mensajes.setMensaje("se creo el dato con éxito");
        }catch (BusException ex){
            mensajes.setCode("1");
            mensajes.setMensaje("fallo "+ex.getMessage());
            throw new RuntimeException(ex);
        }
        return ResponseEntity.ok( mensajes);
    }
}
