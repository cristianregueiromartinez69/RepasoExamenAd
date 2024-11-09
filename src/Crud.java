import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Crud {

    public void insertCoches(String marca, String modelo, String color, int potencia) {
        String consulta = "insert into coches values (?,?,?,?)";

        try{
            Connection conn = EstablecerConexion.conectar();
            PreparedStatement ps = conn.prepareStatement(consulta);

            ps.setString(1, marca);
            ps.setString(2, modelo);
            ps.setString(3, color);
            ps.setInt(4, potencia);

            if(ps.executeUpdate() > 0){
                System.out.println("Insertado Correctamente en tabla coches");
            }
        }catch(SQLException e){
            System.out.println("Ups, no se pudo establecer conexión con la base de datos");
        }
    }

    public Coches selectCoches(int potencia) {
        String consulta = "select * from coches where potencia = ?";
        Coches coches = new Coches();
        try{
            Connection conn = EstablecerConexion.conectar();
            PreparedStatement pst = conn.prepareStatement(consulta);

            pst.setInt(1, potencia);

            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                coches.setMarca(rs.getString("marca"));
                coches.setModelo(rs.getString("modelo"));
                coches.setColor(rs.getString("color"));
                coches.setPotencia(rs.getInt("potencia"));
            }
        } catch (SQLException e) {
            System.out.println("Ups, no se pudo encontrar el registro en la base de datos al hacer select");
        }
        return coches;
    }

    public List<Coches> selectCochesPontnetes(LecturaEscrituraFicheros lectura, String path){
        List<Integer> potenciasCoches = lectura.getCochesPotentes(path);
        List<Coches> cochesPotentes = new ArrayList<>();
        for(int i = 0; i < potenciasCoches.size(); i++){
            Coches coches = selectCoches(potenciasCoches.get(i));
            cochesPotentes.add(coches);
        }
        return cochesPotentes;
    }


}
