import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LecturaEscrituraFicheros {

    public List<Integer> getCochesPotentes(String path){
        File file = new File(path);
        String marca = null;
        String modelo = null;
        String color = null;
        int potencia = 0;

        List<Integer> potenciaList = new ArrayList<>();

        String linea;
        try{
            if(file.exists()){
                BufferedReader br = new BufferedReader(new FileReader(file));

                while ((linea = br.readLine()) != null){
                    if(linea.startsWith("marca")){
                        marca = linea.split(":")[1].trim();
                    } else if (linea.startsWith("modelo")) {
                        modelo = linea.split(":")[1].trim();
                    }
                     else if(linea.startsWith("color")){
                        color = linea.split(":")[1].trim();
                    }
                    else if(linea.startsWith("potencia")){
                        potencia = Integer.parseInt(linea.split(":")[1].trim());

                        assert marca != null;
                        if(potencia > 250){
                            potenciaList.add(potencia);
                        }
                    }
                }


            }

        } catch (FileNotFoundException e) {
            System.out.println("Ups, no se encontró el archivo para leer el txt");
        } catch (IOException e) {
            System.out.println("Ups, ha ocurrido un error al leer el archivo txt");
        }

        return potenciaList;
    }
}
