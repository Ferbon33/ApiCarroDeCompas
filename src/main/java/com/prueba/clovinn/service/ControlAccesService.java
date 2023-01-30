package com.prueba.clovinn.service;


import com.prueba.clovinn.dao.ControlAccesMapper;
import com.prueba.clovinn.domain.Articulos;
import com.prueba.clovinn.domain.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ControlAccesService {


    private static final Logger logger = LoggerFactory.getLogger(ArticulosService.class);

    @Autowired
    ControlAccesMapper controlAccesMapper;


    /**
     * Obtiene una entidad
     *
     * @param id de la entidad a obtener
     * @return entidad obtenida
     *
     */
    public Usuarios getValidaUser(Usuarios user) {
        logger.debug("Ingresando a validar usuario" );

        Usuarios usuario = controlAccesMapper.validaUser(user);
       if (usuario.getId() == 0){
           logger.debug("usuario no valido" );
       }
        return usuario;

    }
}
