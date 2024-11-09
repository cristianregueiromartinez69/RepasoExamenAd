import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializar {

    Crud crud = new Crud();

    public void escribirObjetoCoche(List<Coches> cochesList, String path) {

        File file = new File(path);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    writeObjetcsCars(cochesList, path);
                }
            } catch (IOException e) {
                System.out.println("Ups, no se pudo crear el archivo para escribir");
            }
        } else {
            if (file.isFile()) {
                try {
                    writeObjetcsCars(cochesList, path);
                } catch (IOException e) {
                    System.out.println("Ups, ha ocurrido un error a la hora de escribir en el archivo serializable");
                }
            }
        }
    }

    public List<Coches> leerObjetosCoches(String path){
        File file = new File(path);
        List<Coches> cochesList = new ArrayList<>();
        try{
            if (file.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
                Coches coche;

                while ((coche = (Coches) ois.readObject()) != null) {
                    crud.insertCoches(coche.getMarca(), coche.getModelo(), coche.getColor(), coche.getPotencia());
                    cochesList.add(coche);
                }

                ois.close();
                return cochesList;
            }
        } catch (IOException e) {
            System.out.println("Ups, no se pudo leer el archivo serializable");
        } catch (ClassNotFoundException e) {
            System.out.println("Ups, no se encontró la clase Coches");
        }
        return cochesList;
    }

    private void writeObjetcsCars(List<Coches> cochesList, String path) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));

        for (int i = 0; i < cochesList.size(); i++) {
            Coches c = cochesList.get(i);
            oos.writeObject(c);
        }
        System.out.println("Coches escritos correctamente");
        oos.close();
    }



    public List<Coches> getArrayCoches() {
        List<Coches> coches = new ArrayList<Coches>();

        Coches c1 = new Coches("BMW", "BMW serie 3 (330i)", "azul metálico", 258);
        Coches c2 = new Coches("Audi", "Audi A4 (2.0 TFSI)", "blanco perlado", 190);
        Coches c3 = new Coches("Mercedes Benz", "Mercedes-Benz Clase C (C300)", "gris grafito", 255);
        Coches c4 = new Coches("Toyota", "Toyota Corolla (Híbrido)", "rojo brillante", 122);
        Coches c5 = new Coches("Ford", "Ford Mustang (GT)", "negro mate", 450);

        coches.add(c1);
        coches.add(c2);
        coches.add(c3);
        coches.add(c4);
        coches.add(c5);
        return coches;
    }
}



