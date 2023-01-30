package com.prueba.clovinn.dao;

import com.prueba.clovinn.domain.CarroDeCompas;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CarroDeComprasMapper {


    ///add articulos a carro de compra
    @Insert("insert into carroCompras (codigoArticulo, codigoUsuario,cantArticulo, estado) values (#{carro.codigoArticulo}, #{carro.codigoUsuario}, #{carro.cantArticulo}, #{carro.estado})")
    void addArticuloCarro(@Param("carro")CarroDeCompas carro);

    ///ver  Carro de Compra
    @Select("select * from carroCompras where codigoUsuario = #{codigoArticulo} and estado='enUso'")
    @ResultMap("carroDeComprasResult")
    CarroDeCompas verCarroDeCompras(@Param("codigoUsuario") Long codigoUsuario);

}
