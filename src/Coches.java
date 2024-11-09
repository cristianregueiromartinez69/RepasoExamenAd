import java.io.Serializable;

public class Coches implements Serializable {

    private String marca;
    private String modelo;
    private String color;
    private int potencia;

    public Coches(String marca, String modelo, String color, int potencia) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.potencia = potencia;
    }

    public Coches() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "Coches: " +
                "\nmarca: " + marca +
                "\nmodelo: " + modelo +
                "\ncolor: " + color +
                "\npotencia: " + potencia + " km/h";
    }
}
