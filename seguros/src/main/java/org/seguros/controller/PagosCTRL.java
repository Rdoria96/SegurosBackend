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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;


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
    @PostMapping("/pagos/generate")
    public ResponseEntity<Mensajes> generate(@RequestBody Map<String, Object> request) throws  RuntimeException{
        Mensajes mensajes = new Mensajes();

        String documento = (String) request.get("documento");
        String fechaStr = (String) request.get("fecha");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha;

        try {
            fecha = new Date(format.parse(fechaStr).getTime());
            pagosBUS.generatePagos(documento,fecha);
            mensajes.setCode("0");
            mensajes.setMensaje("se creo el dato con éxito");
        }catch (BusException ex){
            mensajes.setCode("1");
            mensajes.setMensaje("fallo "+ex.getMessage());
            throw new RuntimeException(ex);
        }catch (ParseException e) {
            throw new RuntimeException("Error al parsear fecha: " + fechaStr, e);
        }
        return ResponseEntity.ok( mensajes);
    }

    @GetMapping("/pagos/mostarpagos")
    public ResponseEntity<Mensajes> mostrarPagos() throws RuntimeException {
        Mensajes mensaje = new Mensajes();
        List<Map<String,Object>> pagos;
        try {
            pagos = pagosBUS.mostrarPagos();
            mensaje.setCode("0");
            mensaje.setMensaje("se creo el dato con éxito");
            mensaje.setDato(pagos);
        }catch (BusException ex){
            mensaje.setCode("1");
            mensaje.setMensaje("fallo " + ex.getMessage());
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return ResponseEntity.ok( mensaje);
    }

    @GetMapping("/pagos/pagosfiltrados/{año},{mes},{documento}")
    public ResponseEntity<Mensajes> pagosFiltrados(@Valid @PathVariable int año, @Valid @PathVariable int mes, @Valid @PathVariable String documento) throws RuntimeException {
        Mensajes mensaje = new Mensajes();
        List<Map<String,Object>> pagos;
        try {
            pagos = pagosBUS.mostrarPagosFiltrados(año, mes, documento);
            mensaje.setCode("0");
            mensaje.setMensaje("se creo el dato con éxito");
            System.out.println("ctrl "+pagos);
            mensaje.setDato(pagos);
        }catch (BusException ex){
            ex.printStackTrace();
            mensaje.setCode("1");
            mensaje.setMensaje("fallo " + ex.getMessage());
            ex.printStackTrace();
            throw new RuntimeException(ex);

        }
        return ResponseEntity.ok( mensaje);
    }

}
