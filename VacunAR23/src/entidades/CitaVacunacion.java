/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;
import java.time.*;
/**
 *
 * @author carol
 */
public class CitaVacunacion {
    private int codigoCita;
    private Ciudadano ciudadano;
    private int codRefuerzo;
    private String fechaHoraCita;
    private String centroVacunacion;
    private LocalDateTime fechaHoraColoca;
    private Vacuna vacuna;

    public CitaVacunacion() {
    }

    public CitaVacunacion(int codigoCita, Ciudadano ciudadano, int codRefuerzo, String fechaHoraCita, String centroVacunacion, LocalDateTime fechaHoraColoca, Vacuna vacuna) {
        this.codigoCita = codigoCita;
        this.ciudadano = ciudadano;
        this.codRefuerzo = codRefuerzo;
        this.fechaHoraCita = fechaHoraCita;
        this.centroVacunacion = centroVacunacion;
        this.fechaHoraColoca = fechaHoraColoca;
        this.vacuna = vacuna;
    }

    public CitaVacunacion(Ciudadano ciudadano, int codRefuerzo, String fechaHoraCita, String centroVacunacion, LocalDateTime fechaHoraColoca, Vacuna vacuna) {
        this.ciudadano = ciudadano;
        this.codRefuerzo = codRefuerzo;
        this.fechaHoraCita = fechaHoraCita;
        this.centroVacunacion = centroVacunacion;
        this.fechaHoraColoca = fechaHoraColoca;
        this.vacuna = vacuna;
    }

    public int getCodigoCita() {
        return codigoCita;
    }

    public void setCodigoCita(int codigoCita) {
        this.codigoCita = codigoCita;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public int getCodRefuerzo() {
        return codRefuerzo;
    }

    public void setCodRefuerzo(int codRefuerzo) {
        this.codRefuerzo = codRefuerzo;
    }

    public String getFechaHoraCita() {
        return fechaHoraCita;
    }

    public void setFechaHoraCita(String fechaHoraCita) {
        this.fechaHoraCita = fechaHoraCita;
    }

    public String getCentroVacunacion() {
        return centroVacunacion;
    }

    public void setCentroVacunacion(String centroVacunacion) {
        this.centroVacunacion = centroVacunacion;
    }

    public LocalDateTime getFechaHoraColoca() {
        return fechaHoraColoca;
    }

    public void setFechaHoraColoca(LocalDateTime fechaHoraColoca) {
        this.fechaHoraColoca = fechaHoraColoca;
    }

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }

    @Override
    public String toString() {
        return "citaVacunacion{" + "codigoCita=" + codigoCita + ", ciudadano=" + ciudadano + ", codRefuerzo=" + codRefuerzo + ", fechaHoraCita=" + fechaHoraCita + ", centroVacunacion=" + centroVacunacion + ", fechaHoraColoca=" + fechaHoraColoca + ", vacuna=" + vacuna + '}';
    }
    
    
}
