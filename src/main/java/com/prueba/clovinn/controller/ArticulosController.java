package com.prueba.clovinn.controller;

import com.prueba.clovinn.domain.Articulos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.prueba.clovinn.service.ArticulosService;

import java.util.List;

@RestController
@RequestMapping("/Clovinn/Articulos")
@CrossOrigin
public class ArticulosController {

    private static final Logger logger = LoggerFactory.getLogger(AreasController.class);

    @Autowired
    ArticulosService articulosService;
    /**
     * Lista todas las entidades activas
     *
     * @return lista de entidades
     */
    @GetMapping
    public ResponseEntity<List<Articulos>> getAll() {

        try {
            List<Articulos> articulos = articulosService.getAllArticulos()
            return ResponseEntity.ok(articulos);

        } catch (Exception e) {
            logger.error("Error general obteniendo lista de articulo", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error general obteniendo la lista de articulo");
        }
    }
    /**
     * Obtiene una entidad a partir del codigo articulo
     *
     * @param codigo de la entidad a obtener
     * @return entidad obtenida o bien lanza una excepción si hay error en la operación.
     */
    @GetMapping("/{codigoArticulo}")
    public ResponseEntity<Articulos> get(@PathVariable(name = "codigoArticulo") Long codigoArticulo) {
        try {
            Articulos articulo = articulosService.getByCodigoArticulo(codigoArticulo)

            return ResponseEntity.ok(articulo);

        } catch (Exception e) {
            logger.error("Error general obteniendo el articulo codigo: " + codigoArticulo, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error general obteniendo el articulo");
        }
    }

    /**
     * Crea una entidad a partir de los datos recibidos
     *
     * @param obj entidad a crear con la información cargada
     * @return entidad creada o lanza una excepción en caso de error en la operación
     */
    @PostMapping
    public void create(@RequestBody Articulos obj) {
        try {
             articulosService.create(obj);

        } catch (Exception e) {
            logger.error("Error general creando el articulo", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error general creando el articulo" + e);
        }

    }

    /**
     * Elimina un articulo
     *
     * @param codigo a eliminar
     * @return id de la entidad eliminada o bien lanza una excepción si hay error en la operación
     */
    @DeleteMapping("/delete/{codigoArticulo}")
    public void delete(@PathVariable(name = "codigoArticulo") Long codigoArticulo) {
        try {
            articulosService.delete(codigoArticulo);


        } catch (Exception e) {
            logger.error("Error general eliminando el articulo de codigo: " + codigoArticulo, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error general eliminando el articulo");
        }
    }

    /**
     * Modifica una entidad a partir del id e información recibidas
     *
     * @param  entidad a modificar
     *
     */
    @PutMapping("/modifi/{codigoArticulo}")
    public void modify(@RequestBody Articulos articulo) {
        try {
            articulosService.modify(articulo);



        }  catch (Exception e) {
            logger.error("Error general modificando el articulo de id: " + articulo.getCodigoArticulo(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error general modificando el articulo");
        }

    }

    /**
     * Modifica stock
     *
     */
    @PostMapping
    public void modifyStock(@RequestBody Articulos articulo,@RequestBody Long cantidad ) {
        try {
            articulosService.modifyStock(articulo,cantidad);

        }  catch (Exception e) {
            logger.error("Error general modificando el Stock Codigo de Articulo: " + e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error general modificando el articulo");
        }

    }

    /**
     * Ver  stock de articulo
     *
     */
    @GetMapping("/verStock/{codigoArticulo}")
    public Long verStock(@RequestBody Long codigoArticulo ) {
        try {
           return articulosService.verStock(codigoArticulo);

        }  catch (Exception e) {
            logger.error("Error general modificando el Stock Codigo de Articulo: " + e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error general modificando el articulo");
        }

    }
}
