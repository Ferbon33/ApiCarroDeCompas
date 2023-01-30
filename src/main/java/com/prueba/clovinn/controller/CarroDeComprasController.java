package com.prueba.clovinn.controller;

import com.prueba.clovinn.domain.Articulos;
import com.prueba.clovinn.domain.CarroDeCompas;
import com.prueba.clovinn.domain.Usuarios;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.prueba.clovinn.service.ArticulosService;
import com.prueba.clovinn.service.CarroDeComprasService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/Clovinn/CarroDeCompras")
@CrossOrigin
public class CarroDeComprasController {

    private static final Logger logger = LoggerFactory.getLogger(CarroDeComprasController.class);

    @Autowired
    CarroDeComprasService carroDeComprasService;


    /**
     * Obtiene articulos del carro de compras
     *
     * @param usuario  de la entidad a obtener
     * @return arroDeCompas
     */
    @GetMapping("varCarro/")
    public ResponseEntity<CarroDeCompas> getVerCarro(@RequestBody Usuarios user) {
        try {
            CarroDeCompas carroDeCompas = carroDeComprasService.getCarro(user);

            return ResponseEntity.ok(carroDeCompas);

        } catch (Exception e) {
            logger.error("Error al obtener Carro: " +  e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error general obteniendo carro de compras");
        }
    }
    /**
     * Obtiene articulos del carro de compras
     *
     * @param usuario  de la entidad a obtener
     * @return arroDeCompas
     */
    @PostMapping
    public boolean getVerCarro(@RequestBody CarroDeCompas carroDeCompas) {
        try {
            boolean compra = false;

            compra = carroDeComprasService.addArticuloCarro(carroDeCompas);


            return compra;

        } catch (Exception e) {
            logger.error("Error al cargar Carro: " +  e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error general cargar carro de compras");
        }
    }
}
