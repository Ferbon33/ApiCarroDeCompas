package com.prueba.clovinn.dao;

import com.prueba.clovinn.domain.Articulos;
import com.prueba.clovinn.domain.Usuarios;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;

public interface ControlAccesMapper {

    ///find articulos por codigo
    @Select("select * from usuarios where user = #{usuario.user} and pass = #{usuario.pass}")
    @ResultMap("usuarioResult")
    Usuarios validaUser(@Param("usuario") Usuarios usuario);
}
