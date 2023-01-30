package com.prueba.clovinn.service;

import com.prueba.clovinn.dao.ArticulosMapper;
import com.prueba.clovinn.dao.CarroDeComprasMapper;
import com.prueba.clovinn.domain.CarroDeCompas;
import com.prueba.clovinn.domain.Usuarios;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CarroDeComprasService {

    private static final Logger logger = LoggerFactory.getLogger(CarroDeComprasService.class);

    @Autowired
    ArticulosMapper articulosMapper;

    @Autowired
    CarroDeComprasMapper carroDeComprasMapper;

    /**
     * Agragar Articulo a Carro de Compras
     *
     * @return true o false
     */
    public Boolean addArticuloCarro(CarroDeCompas carroDeCompas) {

        Long codigoArt = carroDeCompas.getCodigoArticulo();
        Long cantArt =  carroDeCompas.getCantArticulo();
        /////se Verfica si ese Articulo tiene Stock disponible
        Long cantEnStock = articulosMapper.getCantStock(codigoArt);
        if(cantArt>cantEnStock){
            carroDeCompas.setEstado("enUso");
            carroDeComprasMapper.addArticuloCarro(carroDeCompas);
            logger.debug("se agrego articulo correctamente al Carro");
        return true;
        }else{
            logger.debug("No se puede Agregar Articulo a Carro, por que no tiene stock");
        return false;
        }

    }
    /**
     * Ver contenido de Carro de Compras
     * @param Usuario
     * @return Carro de Compras
     */
    public CarroDeCompas getCarro(Usuarios usuario){

        Long idUser = usuario.getId();
        logger.debug("se muestra carro de compras segun idUser");
        CarroDeCompas carroDeCompas = carroDeComprasMapper.verCarroDeCompras(idUser);

        return carroDeCompas;
    }
}
