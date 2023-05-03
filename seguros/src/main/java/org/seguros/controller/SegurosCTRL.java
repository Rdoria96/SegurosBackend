package org.seguros.controller;

import jakarta.validation.Valid;
import org.seguros.business.SegurosBUS;
import org.seguros.dto.Seguro;
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
public class SegurosCTRL {

@Autowired
    private SegurosBUS segurosBUS;

   public SegurosCTRL(SegurosBUS segurosBUS){
       this.segurosBUS= segurosBUS;
   }
    @CrossOrigin(origins = "http://localhost/80")
    @PostMapping("/seguros")
    public ResponseEntity<Mensajes> create(@Valid @RequestBody Seguro seguro) throws  RuntimeException {
        Mensajes mensajes = new Mensajes();
        try{
            segurosBUS.crearSeguro(seguro);
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
    @GetMapping("/seguros/mostrar_seguros")
    public ResponseEntity<Mensajes> getTomador() throws RuntimeException {
        Mensajes mensajes = new Mensajes();
        List<Map<String,Object>> Seguros;
        try {
            Seguros =  segurosBUS.mostrarSeguros();
            mensajes.setCode("0");
            mensajes.setMensaje("se creo el dato con éxito");
            mensajes.setDato(Seguros);
        }catch (BusException ex) {
            mensajes.setCode("1");
            mensajes.setMensaje("fallo " + ex.getMessage());
            throw new RuntimeException(ex);
        }
        return ResponseEntity.ok(mensajes);
    }

    @DeleteMapping("/seguros/delete/{nmid}")
    public ResponseEntity<Mensajes> delete(@Valid  @PathVariable int nmid) throws RuntimeException {
        Mensajes mensajes = new Mensajes();
        try {
            segurosBUS.EliminarSeguro(nmid);
            mensajes.setCode("0");
            mensajes.setMensaje("Seguro eliminado");
        }catch (BusException e){
            mensajes.setCode("1");
            mensajes.setMensaje("fallo " + e.getMessage());
        }
        return ResponseEntity.ok(mensajes);
    }

}
