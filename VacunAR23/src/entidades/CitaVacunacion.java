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
    private LocalDateTime fechaHoraCita;
    private String centroVacunacion;
    private LocalDateTime fechaHoraColoca;
    private Vacuna vacuna;
    private Boolean cancelar;
    
    public CitaVacunacion() {
    }

    public CitaVacunacion(int codigoCita, Ciudadano ciudadano, int codRefuerzo, LocalDateTime fechaHoraCita, String centroVacunacion, LocalDateTime fechaHoraColoca, Vacuna vacuna, Boolean cancelar) {
        this.codigoCita = codigoCita;
        this.ciudadano = ciudadano;
        this.codRefuerzo = codRefuerzo;
        this.fechaHoraCita = fechaHoraCita;
        this.centroVacunacion = centroVacunacion;
        this.fechaHoraColoca = fechaHoraColoca;
        this.vacuna = vacuna;
        this.cancelar=cancelar;
    }

    public CitaVacunacion(Ciudadano ciudadano, int codRefuerzo, LocalDateTime fechaHoraCita, String centroVacunacion, LocalDateTime fechaHoraColoca, Vacuna vacuna,Boolean cancelar) {
        this.ciudadano = ciudadano;
        this.codRefuerzo = codRefuerzo;
        this.fechaHoraCita = fechaHoraCita;
        this.centroVacunacion = centroVacunacion;
        this.fechaHoraColoca = fechaHoraColoca;
        this.vacuna = vacuna;
        this.cancelar=cancelar;
                
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

    public LocalDateTime getFechaHoraCita() {
        return fechaHoraCita;
    }

    public void setFechaHoraCita(LocalDateTime fechaHoraCita) {
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

    public boolean getCancelar(){return cancelar;}
    public void setCancelar(boolean cancelar){this.cancelar = cancelar;}
    
    
    @Override
    public String toString() {
        return "citaVacunacion{" + "codigoCita=" + codigoCita + ", ciudadano=" + ciudadano + ", codRefuerzo=" + codRefuerzo + ", fechaHoraCita=" + fechaHoraCita + ", centroVacunacion=" + centroVacunacion + ", fechaHoraColoca=" + fechaHoraColoca + ", vacuna=" + vacuna + '}';
    }
    
    
}
