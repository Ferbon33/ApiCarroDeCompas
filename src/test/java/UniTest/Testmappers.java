package UniTest;

import com.prueba.clovinn.dao.ArticulosMapper;
import com.prueba.clovinn.dao.CarroDeComprasMapper;
import com.prueba.clovinn.dao.ControlAccesMapper;
import com.prueba.clovinn.domain.Articulos;
import com.prueba.clovinn.domain.CarroDeCompas;
import com.prueba.clovinn.domain.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Testmappers {

    @Autowired
    private CarroDeComprasMapper carroDeComprasMapper;
    @Autowired
    private ControlAccesMapper controlAccesMapper;
    @Autowired
    private ArticulosMapper articulosMapper;

    @Test
    public CarroDeCompas TestverCarroDeCompras(){
       Long codUser = Long.valueOf(3);
       CarroDeCompas carroDeCompas = carroDeComprasMapper.verCarroDeCompras(codUser);
       return carroDeCompas;
    }

    @Test
    public Usuarios testvalidaUser(){
        Usuarios user = new Usuarios();
        user.setUser("fer");
        user.setPass("1234");
        Usuarios usuarios = controlAccesMapper.validaUser(user);
        return usuarios;
    }

    @Test
    public  List<Articulos> TestgetAllArticulos(){
        List<Articulos> articulos = articulosMapper.getAllArticulos();
        return articulos;
    }
   @Test
    public Articulos TestgetByCodigoArticulos(){
        Long codArt = Long.valueOf(1);
        Articulos art = articulosMapper.getByCodigoArticulos(codArt);
        return art;
   }

    @Test
    public Long TestgetCantStock(){
    Long codArt = Long.valueOf(1);
    Long cantStock = articulosMapper.getCantStock(codArt);
    return cantStock;
    }
}
