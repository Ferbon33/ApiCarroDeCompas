package com.prueba.clovinn.service;

import com.prueba.clovinn.dao.ArticulosMapper;
import com.prueba.clovinn.domain.Articulos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.List;

public class ArticulosService {

    private static final Logger logger = LoggerFactory.getLogger(ArticulosService.class);

    @Autowired
    ArticulosMapper articulosMapper;

    /**
     * Lista todas los articulos
     *
     * @return lista de entidades
     */

    public List<Articulos> getAllArticulos() {
        logger.debug("Ingresando a listar articulos");

        List<Articulos> articulos = articulosMapper.getAllArticulos();

        logger.debug("Cantidad de articulos obtenidos: " + articulos.size());

        return articulos;
    }

    /**
     * Obtiene una entidad a partir del id recibido
     *
     * @param id de la entidad a obtener
     * @return entidad obtenida
     *
     */
    public Articulos getByCodigoArticulo(Long id) {
        logger.debug("Ingresando a obtener un articulo por codigoarticulo: " + id);

       Articulos articulo = articulosMapper.getByCodigoArticulos(id);

        return articulo;

    }
    /**
     * Crea una entidad a partir de los datos recibidos
     *
     * @param articulo entidad a crear con la información cargada
     * @return entidad creada
     *
     */
    public void create(Articulos articulo)  {


        try {
            articulo.setFechaAlta(new Date());
            articulosMapper.createArticulos(articulo);

        } catch (Exception e) {
            logger.error("No se ha Posido cargar el articulo error:" + e);

        }

    }

    /**
     * Elimina un articulo
     * @param codigo de articulo de la entidad a eliminar
     * @return sin retorno
     *
     */
    public void delete(Long codigoArticulo)  {
        logger.debug("Ingresando a eliminar articulo con codigo: " + codigoArticulo);

        try {

            articulosMapper.deleteArticulos(codigoArticulo);

        }catch(Exception e) {
            logger.error("No ha sido posible eliminar el articulo Error." + e);

        }
    }

    /**
     * Modifica una entidad a partir del id e información recibidas
     * @param articulo de la entidad a modificar
     * @return sin return
     *
     */
    public void modify(Articulos articulo)  {
        logger.debug("Ingresando a modificar un articulo: " );

        try {

            articulosMapper.updateArticulos(articulo);


        } catch (Exception e) {
            logger.error("No se ha Podido Modificar los datos del articulo", e);

        }
    }

    /**
     * Modifica Stock a Prtir de  información recibida
     * @param articulo de la entidad a modificar y cantidad de stock
     * @return sin return
     *
     */

    public void modifyStock(Articulos articulo, Long cantidad)  {
        logger.debug("Ingresando a modificar un Stock: " );

        try {

            articulosMapper.updateStock(articulo,cantidad);


        } catch (Exception e) {
            logger.error("No se ha Podido Modificar el stock de articulo", e);

        }
    }

    /**
     * Muestra Stock a Prtir de  Codigo de articulo
     * @param codigoArticulo de articulo
     * @return numerico de tipo Long
     *
     */

    public Long verStock(Long codigoArticulo)  {
        logger.debug("Ingresando a ver un Stock: " );
        Long stock = null;
        try {

             stock =  articulosMapper.getCantStock(codigoArticulo);

         return  stock;
        } catch (Exception e) {
            logger.error("No se ha Podido ver el stock de articulo", e);

        }
        return  stock;
    }
}
