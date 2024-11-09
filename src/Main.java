import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Serializar ser = new Serializar();
        LecturaEscrituraFicheros lef = new LecturaEscrituraFicheros();
        Crud cr = new Crud();
        /*
        List<Coches> cochesList = ser.getArrayCoches();
        String pathSerializable = "C:/Users/crm23/OneDrive/Escritorio/dam2Clase/Acceso a Datos/1Examen1EvaAD/coches.dat";
        ser.escribirObjetoCoche(cochesList, pathSerializable);
        */
        //String pathSerializable = "C:/Users/crm23/OneDrive/Escritorio/dam2Clase/Acceso a Datos/1Examen1EvaAD/coches.dat";
        //List<Coches> cochesListSerializables = ser.leerObjetosCoches(pathSerializable);

        String pathTxt = "C:/Users/crm23/OneDrive/Escritorio/dam2Clase/Acceso a Datos/1Examen1EvaAD/coches.txt";

        List <Coches> cochesListPotentes = cr.selectCochesPontnetes(lef, pathTxt);
        cochesListPotentes.sort(Comparator.comparing(Coches::getPotencia).reversed());
        for(Coches c : cochesListPotentes) {
            System.out.println(c.toString());
        }








    }
}

