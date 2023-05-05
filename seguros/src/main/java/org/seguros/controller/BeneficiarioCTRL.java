package org.seguros.controller;

import jakarta.validation.Valid;
import org.seguros.business.BeneficiarioBUS;
import org.seguros.business.TomadorBUS;
import org.seguros.dto.Beneficiario;
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
public class BeneficiarioCTRL {
    @Autowired
    private BeneficiarioBUS beneficiarioBUS;

    public BeneficiarioCTRL(BeneficiarioBUS beneficiarioBUS) {
        this.beneficiarioBUS = beneficiarioBUS;
    }

    @CrossOrigin(origins = "http://localhost/80")
    @PostMapping("/beneficiario/createbeneficiario")
    public ResponseEntity<Mensajes> create(@Valid @RequestBody Beneficiario beneficiario) throws  RuntimeException {
        Mensajes mensajes = new Mensajes();
        try{
            beneficiarioBUS.createBeneficiario(beneficiario);
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
    @GetMapping("/beneficiario/mostrarbeneficiario")
    public ResponseEntity<Mensajes> getTomador() throws RuntimeException {
        Mensajes mensajes = new Mensajes();
        List<Map<String,Object>> beneficiario;
        try {
            beneficiario = beneficiarioBUS.mostrarBeneficiarios();
            mensajes.setCode("0");
            mensajes.setMensaje("se creo el dato con éxito");
            mensajes.setDato(beneficiario);

        }catch (BusException ex) {
            mensajes.setCode("1");
            mensajes.setMensaje("fallo " + ex.getMessage());
            throw new RuntimeException(ex);
        }
        return ResponseEntity.ok(mensajes);
    }

    @DeleteMapping("/beneficiario/deletebeneficiario/{nmid}")
    public ResponseEntity<Mensajes> delete(@Valid  @PathVariable int nmid) throws RuntimeException {
        Mensajes mensajes = new Mensajes();
        try {
            beneficiarioBUS.eleiminarBeneficiario(nmid);
            mensajes.setCode("0");
            mensajes.setMensaje("Beneficiario eleiminado");
        }catch (BusException e){
            mensajes.setCode("1");
            mensajes.setMensaje("fallo " + e.getMessage());
        }
        return ResponseEntity.ok(mensajes);
    }

}
