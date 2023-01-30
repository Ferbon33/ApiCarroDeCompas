package com.prueba.clovinn.controller;

import org.springframework.http.HttpStatus;
import com.prueba.clovinn.domain.Usuarios;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prueba.clovinn.service.ControlAccesService;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/Clovinn/validaUser")
@CrossOrigin
public class ControlAccesController {

    private static final Logger logger = LoggerFactory.getLogger(AreasController.class);

    @Autowired
    ControlAccesService controlAccesService;
    /**
     * Verifica user
     *
     * @return entidad user valida
     */


    @PostMapping
    public ResponseEntity <Usuarios>  getValida(@RequestBody Usuarios user) {
        try {
            Usuarios usuario = controlAccesService.getValidaUser(user);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            logger.error("Error general validacion", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error general validacion user" + e);
        }

    }
}
