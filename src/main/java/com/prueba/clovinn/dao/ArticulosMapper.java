package com.prueba.clovinn.dao;

import com.prueba.clovinn.domain.Articulos;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ArticulosMapper {

    ///lista articulos
    @Select("select * from articulos ")
    @Results(id = "ArticulosResult", value = {
            @Result(property = "id" , column = "Id"),
            @Result(property = "codigoArticulo" , column = "codigoArticulo"),
            @Result(property = "nombre" , column = "nombre"),
            @Result(property = "categoria" , column = "categoria"),
            @Result(property = "precio" , column = "precio"),
            @Result(property = "stock" , column = "stock"),
            @Result(property = "fechaAlta" , column = "fechaAlta")
    }
    )
    List<Articulos> getAllArticulos();

    ///find articulos por codigo
    @Select("select * from articulos where codigoArticulo = #{codigoArticulo}")
    @ResultMap("ArticulosResult")
    Articulos getByCodigoArticulos(@Param("codigoArticulo") Long codigoArticulo);


    ///inserta articulos
    @Insert("insert into articulos (codigoArticulo, nombre, categoria,precio,stock,fechaAlta) values (#{articulo.codigoArticulo}, #{articulo.nombre}, #{articulo.categoria},#{articulo.precio}, #{articulo.stock}, #{articulo.fechaAlta})")
    void createArticulos(@Param("articulo") Articulos articulo);


    ///elimina un articulo por codigo
    @Delete("DELETE FROM articulos WHERE codigoArticulo = #{codigoArticulo}")
    void deleteArticulos(Long codigoArticulo);

    ///actualiza datos de articulo
    @Update("update articulos set nombre = #{articulo.nombre}, Autor = #{articulo.categoria}  where codigoArticulo = #{articulo.codigoArticulo}")
    void updateArticulos(@Param("articulo") Articulos articulo);

    ///actualiza stock articulo
    @Update("update articulos set stock = #{cantidad} where codigoArticulo = #{articulo.codigoArticulo}")
    int updateStock(@Param("articulo") Articulos articulo, @Param("cantidad") Long cantidad);

   ///ver cantidad de stock de un articulo
   @Select("select stock from articulos where codigoArticulo = #{codigoArticulo}")
   @ResultMap("ArticuloResultStock")
   Long getCantStock(@Param("codigoArticulo") Long codigoArticulo);
}
