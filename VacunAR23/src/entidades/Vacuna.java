
package entidades;
import java.time.*;

public class Vacuna {
    private int nroSerieDosis;
    private String marca;
    private double medida;
    private LocalDate fechacaduca;
    private boolean colocada;

    public Vacuna() {
    }

    public Vacuna(int nroSerieDosis, String marca, double medida, LocalDate fechacaduca, boolean colocada) {
        this.nroSerieDosis = nroSerieDosis;
        this.marca = marca;
        this.medida = medida;
        this.fechacaduca = fechacaduca;
        this.colocada = false;
    }

    public Vacuna(String marca, double medida, LocalDate fechacaduca, boolean colocada) {
        this.marca = marca;
        this.medida = medida;
        this.fechacaduca = fechacaduca;
        this.colocada = false;
    }

    public int getNroSerieDosis() {
        return nroSerieDosis;
    }

    public void setNroSerieDosis(int nroSerieDosis) {
        this.nroSerieDosis = nroSerieDosis;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getMedida() {
        return medida;
    }

    public void setMedida(double medida) {
        this.medida = medida;
    }

    public LocalDate getFechacaduca() {
        return fechacaduca;
    }

    public void setFechacaduca(LocalDate fechacaduca) {
        this.fechacaduca = fechacaduca;
    }

    public boolean isColocada() {
        return colocada;
    }

    public void setColocada(boolean colocada) {
        this.colocada = colocada;
    }

    @Override
    public String toString() {
        return "Vacuna{" + "nroSerieDosis=" + nroSerieDosis + ", marca=" + marca + ", medida=" + medida + ", fechacaduca=" + fechacaduca + ", colocada=" + colocada + '}';
    }
    
    
    
}
