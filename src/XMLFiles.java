import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XMLFiles {

    public void escribirXml(List <Coches> cochesListPotentes, String path){
        XMLOutputFactory factory = XMLOutputFactory.newInstance();

        try{
            XMLStreamWriter xmlStreamWriter = factory.createXMLStreamWriter(new FileWriter(path));
            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeStartElement("coches");

            for(int i = 0; i < cochesListPotentes.size(); i++){
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("coche");
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("marca");
                xmlStreamWriter.writeCharacters(cochesListPotentes.get(i).getMarca());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("modelo");
                xmlStreamWriter.writeCharacters(cochesListPotentes.get(i).getModelo());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("color");
                xmlStreamWriter.writeCharacters(cochesListPotentes.get(i).getColor());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("potencia");
                xmlStreamWriter.writeCharacters(String.valueOf(cochesListPotentes.get(i).getPotencia()));
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeEndElement();

            }
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.close();
            System.out.println("Coches escritos correctamente");
        } catch (XMLStreamException e) {
            System.out.println("Ups, error al escribir en el xml");
        } catch (IOException e) {
            System.out.println("Ups, error operar en el xml");
        }
    }
}
